package tests;

import org.testng.annotations.Test;
import servise.BaseTest;
import steps.LoginPageSteps;

public class LoginOnStartPageTest extends BaseTest {
    private final static String USER = ("standard_user");
    private final static String PASS = ("secret_sauce");

    LoginPageSteps loginPageSteps = new LoginPageSteps();

    @Test(description = "Авторизация в магазине", groups = "smock")
    public void loginIn() {
        loginPageSteps.openLoginForm();
        loginPageSteps.setName(USER);
        loginPageSteps.setPasswordField(PASS);
        loginPageSteps.openStartPage();
    }
}
