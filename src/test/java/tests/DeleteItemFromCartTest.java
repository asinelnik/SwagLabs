package tests;

import org.testng.annotations.Test;
import servise.BaseTest;
import steps.CartSteps;
import steps.ProductSteps;

public class DeleteItemFromCartTest extends BaseTest {
    ProductSteps productSteps = new ProductSteps();
    CartSteps cartSteps = new CartSteps();

    @Test(description = "Удаление товара из корзины", groups = "smock")
    public void removeBackPackFromCart() {
        loginInOnStartPage();
        productSteps.addBackpackInCart();
        cartSteps.openCartPageGetInfoItem();
        cartSteps.removeBackPack();
        cartSteps.continueShoppingOnProduct();
    }

}
