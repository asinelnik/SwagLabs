package tests;

import org.testng.annotations.Test;
import servise.BaseTest;
import steps.CheckoutSteps;

public class OrderProcessingTest extends BaseTest {

    CheckoutSteps checkoutSteps = new CheckoutSteps();

    @Test(description = "Добавление товара в корзину", groups = "smock")
    public void productClearance() {
        loginInOnStartPage();
        getSauceLabsBackpackInCart();
        checkoutSteps.openFormYourInformation();
        checkoutSteps.editYourInformation();
        checkoutSteps.continueCheckInformation();
        checkoutSteps.clickFinishButton();
    }

}
