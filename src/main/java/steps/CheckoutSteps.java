package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.CartPage;
import pages.CheckoutPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutSteps {
    private final CartPage cartPage = new CartPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();
    public static String FIRS_TNAME = ("Георгий");
    public static String LAST_NAME = ("Жигарев");
    public static String ZIP_POSTAL_CODE = ("156000");


    @Step("Нажать на кнопку Checkout")
    public void openFormYourInformation() {
        cartPage.cartElements.checkoutButton.click();
        assertThat(checkoutPage.checkoutElements.firstNameField.exists()).as("Поле FirstName не найдено").isTrue();
        assertThat(checkoutPage.checkoutElements.lastNameField.exists()).as("Поле LastName не найдено").isTrue();
        assertThat(checkoutPage.checkoutElements.zipPostalCodeField.exists()).as("Поле ZipPostalCode не найдено").isTrue();
    }

    public void openFormYour() {
        cartPage.cartElements.checkoutButton.click();
        assertThat(checkoutPage.checkoutElements.yourInformationForm.findBy(Condition.name("firstName")).exists()).as("Поле FirstName не найдено").isTrue();
        assertThat(checkoutPage.checkoutElements.yourInformationForm.findBy(Condition.name("lastName")).exists()).as("Поле LastName не найдено").isTrue();
        assertThat(checkoutPage.checkoutElements.yourInformationForm.findBy(Condition.name("postalCode")).exists()).as("Поле ZipPostalCode не найдено").isTrue();
    }

    @Step("Проверка заполнения полей")
    public void editYourInformation() {
        checkoutPage.checkoutElements.firstNameField.sendKeys(FIRS_TNAME);
        assertThat(checkoutPage.checkoutElements.firstNameField.getValue()).as("FIRSTNAME не соответствует введеному значению").isEqualTo(FIRS_TNAME);
        checkoutPage.checkoutElements.lastNameField.sendKeys(LAST_NAME);
        assertThat(checkoutPage.checkoutElements.lastNameField.getValue()).as("LASTNAME не соответствует введеному значению").isEqualTo(LAST_NAME);
        checkoutPage.checkoutElements.zipPostalCodeField.sendKeys(ZIP_POSTAL_CODE);
        assertThat(checkoutPage.checkoutElements.zipPostalCodeField.getValue()).as("ZIPPOSTALCODE не соответствует введеному значению").isEqualTo(ZIP_POSTAL_CODE);
    }

    @Step("Нажать на кнопку Continue")
    public void continueCheckInformation() {
        checkoutPage.checkoutElements.continueButton.click();
        assertThat(checkoutPage.checkoutElements.checkoutOverview.exists()).as("Не отрывается страница \"CHECKOUT: OVERVIEW\"").isTrue();
        assertThat(checkoutPage.checkoutElements.inventoryItemName.exists()).as("Не отображается имя товара").isTrue();
        assertThat(checkoutPage.checkoutElements.inventoryItemPrice.exists()).as("Не отображается цена товара").isTrue();
        assertThat(checkoutPage.checkoutElements.paymentInformation.getText())
                .as("Payment Information не соответствует ожидаемому").isEqualTo("SauceCard #31337");
        assertThat(checkoutPage.checkoutElements.shippingInformation.getText()).
                as("Shipping Information не соответствует ожидаемому").isEqualTo("Free Pony Express Delivery!");
        assertThat(checkoutPage.checkoutElements.itemTotal.getText()).as("Item total не соответствует ожидаемому").isEqualTo("Item total: $29.99");
        assertThat(checkoutPage.checkoutElements.textTax.getText()).as("Tax не соответствует ожидаемому").isEqualTo("Tax: $2.40");
        assertThat(checkoutPage.checkoutElements.textTotal.getText()).as("Total не соответствует ожидаемому").isEqualTo("Total: $32.39");
    }

    @Step("Завершение оформления товара -Нажать на кнопку Finish")
    public void clickFinishButton() {
        checkoutPage.checkoutElements.finishButton.click();
        assertThat(checkoutPage.checkoutElements.completePage.exists()).as("Не отображается страница \"CHECKOUT: COMPLETE!\"").isTrue();
        assertThat(checkoutPage.checkoutElements.completeMessage.getText()).as("").isEqualTo("Thank you for your order!");
    }
}
