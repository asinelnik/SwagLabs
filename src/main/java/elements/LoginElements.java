package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginElements {
    public SelenideElement userNameField = $("#user-name").as("Поле ввода логина");
    public SelenideElement passwordField = $("#password").as("Поле ввода пароля");
    public SelenideElement loginButton = $("#login-button").as("Кнопка Login");
}
