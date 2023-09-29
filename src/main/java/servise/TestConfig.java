package servise;

import org.aeonbits.owner.Config;
@Config.Sources({"classpath:Application.properties"})
@Config.LoadPolicy(Config.LoadType.MERGE)

public interface TestConfig extends Config {

    @Key("login.url")
    String url();

    @Key("login.login")
    String user();

    @Key("login.problemLogin")
    String problemUser();

    @Key("login.password")
    String password();
}
