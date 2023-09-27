package tests;

import org.testng.annotations.Test;
import servise.BaseStep;
import servise.BaseTest;
import steps.CartSteps;
import steps.ProductSteps;

public class GetItemInCartTestTest extends BaseTest {

    private final BaseStep baseStep = new BaseStep();
    private final ProductSteps productSteps = new ProductSteps();
    private final CartSteps cartSteps = new CartSteps();

    @Test(description = "Добавление товара в корзину",groups = "smock")
    public void getProductsInBasket() {
        baseStep.loginInOnStartPage();
        productSteps.addBackpackInCart();
        cartSteps.openCartPageGetInfoItem();
        cartSteps.continueShoppingOnProduct();
    }
}
