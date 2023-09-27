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

    @Test(description = "Добавление товара в корзину", dataProvider = "authParamUser", dataProviderClass = BaseStep.class)
    public void getProductsInBasket(String USER, String PASS) {
        baseStep.loginOnStartPageDataProvider(USER, PASS);
        productSteps.addBackpackInCart();
        cartSteps.openCartPageGetInfoItem();
        cartSteps.continueShoppingOnProduct();
    }
}
