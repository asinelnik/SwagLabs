package tests;

import org.testng.annotations.Test;
import servise.BaseStep;
import servise.BaseTest;
import steps.CheckoutSteps;

public class OrderProcessingTest extends BaseTest {
    private final BaseStep baseStep = new BaseStep();
    private final CheckoutSteps checkoutSteps = new CheckoutSteps();

    @Test(description = "Добавление товара в корзину", groups = "smock")
    public void productClearance() {
        baseStep.loginInOnStartPage();
        baseStep.getSauceLabsBackpackInCart();
        checkoutSteps.openFormYourInformation();
        checkoutSteps.editYourInformation();
        checkoutSteps.continueCheckInformation();
        checkoutSteps.clickFinishButton();
    }

}
