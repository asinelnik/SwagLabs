package tests;

import org.testng.annotations.Test;
import servise.BaseStep;
import servise.BaseTest;
import steps.CartSteps;
import steps.ProductSteps;

public class DeleteItemFromCartTest extends BaseTest {
    private final BaseStep baseStep = new BaseStep();
    private final ProductSteps productSteps = new ProductSteps();
    private final CartSteps cartSteps = new CartSteps();

    @Test(description = "Удаление товара из корзины", dataProvider = "authParamUser", dataProviderClass = BaseStep.class)
    public void removeBackPackFromCart(String USER, String PASS) {
        baseStep.loginOnStartPageDataProvider(USER, PASS);
        productSteps.addBackpackInCart();
        cartSteps.openCartPageGetInfoItem();
        cartSteps.removeBackPack();
        cartSteps.continueShoppingOnProduct();
    }

}
