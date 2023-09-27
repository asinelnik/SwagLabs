package tests;

import org.testng.annotations.Test;
import servise.BaseStep;
import servise.BaseTest;
import steps.CheckoutSteps;

public class OrderProcessingTest extends BaseTest {
    private final BaseStep baseStep = new BaseStep();
    private final CheckoutSteps checkoutSteps = new CheckoutSteps();

    @Test(description = "Добавление товара в корзину", dataProvider = "authParamUser", dataProviderClass = BaseStep.class)
    public void productClearance(String USER, String PASS) {
        baseStep.loginOnStartPageDataProvider(USER, PASS);
        baseStep.getSauceLabsBackpackInCart();
        checkoutSteps.openFormYourInformation();
        checkoutSteps.editYourInformation();
        checkoutSteps.continueCheckInformation();
        checkoutSteps.clickFinishButton();
    }

}
