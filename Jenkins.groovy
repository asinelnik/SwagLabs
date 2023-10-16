pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Init') {
            steps {
                script {
                    try {
                        docker.image("aerokube/cm:latest-release")
                                .withRun("--rm -v selenoid:/root/.aerokube/selenoid/ -v /var/run/docker.sock:/var/run/docker.sock",
                                        "selenoid configure --browsers 'chrome' --last-versions 1 --tmpfs 128 --force") {}
                    } catch (err) {
                        echo err.getMessage()
                    }

                    cleanWs()
                    git credentialsId: 'gitlabUiCredentials', url: 'https://github.com/asinelnik/SwagLabs', branch: 'master'
                }
            }
        }
        stage('Tests') {
            steps {
                script {
                    try {
                        docker.image("aerokube/selenoid:latest-release")
                                .withRun("--rm -v /var/run/docker.sock:/var/run/docker.sock -v selenoid:/etc/selenoid/:ro --network=host", "--limit 12 --timeout 5m") {
                                    container ->
                                        withCredentials([
                                                usernamePassword(credentialsId: 'siteAdmin', usernameVariable: 'siteAdminUser', passwordVariable: 'siteAdminPass'),
                                                usernamePassword(credentialsId: 'dbUser', usernameVariable: 'dbUser', passwordVariable: 'dbPass'),
                                                string(credentialsId: 'universalTestPassword', variable: 'universalTestPassword')
                                        ]) {
                                            withEnv([
                                                    'PATH+EXTRA=/var/jenkins_home/tools/hudson.model.JDK/OpenJDK_8/jdk8u292-b05/bin',
                                                    'JAVA_HOME=/var/jenkins_home/tools/hudson.model.JDK/OpenJDK_8/jdk8u292-b05'
                                            ]) {
                                                sh "mvn " +
                                                        "-Dmaven.test.failure.ignore=true " +
                                                        "-Dusers.webAdminSite.login=${siteAdminUser} " +
                                                        "-Dusers.webAdminSite.password=${siteAdminPass} " +
                                                        "-Dusers.db.login=${dbUser} " +
                                                        "-Dusers.db.password=${dbPass} " +
                                                        "-DdriverType=remote " +
                                                        "-DselenoidUri=http://docker:4444/wd/hub " +
                                                        "-Dusers.universalTestPassword=${universalTestPassword} " +
                                                        "-f pom.xml " +
                                                        "-DthreadCount=5 " +
                                                        "-Dgroups=Checklist " +
                                                        "-Dtestenv=${testenv} " +
                                                        "test "
                                                sh "docker logs --tail 500 ${container.id}"
                                            }
                                        }

                                }
                    } catch (err) {
                        echo err.getMessage()
                    }
                }
            }
        }
    }
    post {
        always {
            script {
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [
                                [path: 'target/allure-results']
                        ]
                ])
            }
        }
    }
}