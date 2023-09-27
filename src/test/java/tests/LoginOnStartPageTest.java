package tests;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import servise.BaseStep;
import servise.BaseTest;
import servise.TestConfig;
import steps.LoginPageSteps;

public class LoginOnStartPageTest extends BaseTest {
    private final LoginPageSteps loginPageSteps = new LoginPageSteps();

    @Test(description = "Авторизация в магазине", dataProvider = "authParamUser", dataProviderClass = BaseStep.class)
    public void loginIn(String USER, String PASS) {
        loginPageSteps.openLoginForm();
        loginPageSteps.setName(USER);
        loginPageSteps.setPasswordField(PASS);
        loginPageSteps.openStartPage();
    }
}
