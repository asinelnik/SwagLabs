package tests;

import org.testng.annotations.Test;
import servise.BaseTest;
import steps.CartSteps;
import steps.ProductSteps;

public class GetItemInCartTestTest extends BaseTest {
    ProductSteps productSteps = new ProductSteps();
    CartSteps cartSteps = new CartSteps();

    @Test(description = "Добавление товара в корзину",groups = "smock")
    public void getProductsInBasket() {
        loginInOnStartPage();
        productSteps.addBackpackInCart();
        cartSteps.openCartPageGetInfoItem();
        cartSteps.continueShoppingOnProduct();
    }
}
