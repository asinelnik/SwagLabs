package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageSteps {
    private final LoginPage loginPage = new LoginPage();
    private final ProductPage productPage = new ProductPage();

    @Step("open URL")
    public void openLoginForm() {
        assertThat(loginPage.loginElements.userNameField.exists()).as("Поле username не найдено").isTrue();
        assertThat(loginPage.loginElements.passwordField.exists()).as("Поле password не найдено").isTrue();
        assertThat(loginPage.loginElements.loginButton.exists()).as("Кнопка логин не найдена").isTrue();
    }

    @Step("Заполнение логина")
    public void setName(String a) {
        loginPage.loginElements.userNameField.sendKeys(a);
        assertThat(loginPage.loginElements.userNameField.getValue()).as("Введеное значение не отображается").isEqualTo(a);
    }

    @Step("Заполнение пароля")
    public void setPasswordField(String b) {
        loginPage.loginElements.passwordField.sendKeys(b);
        assertThat(loginPage.loginElements.passwordField.getValue()).as("Введеное значение не отображается").isEqualTo(b);
    }

    @Step("Нажатие на кнопку Логин")
    public void openStartPage() {
        loginPage.loginElements.loginButton.click();
        assertThat(productPage.productsElement.productHeader.exists()).as("Страница Products не открывается").isTrue();
    }
}
