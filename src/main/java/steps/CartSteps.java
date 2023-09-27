package steps;

import io.qameta.allure.Step;
import pages.CartPage;
import pages.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CartSteps {
    private final CartPage cartPage = new CartPage();
    private final ProductPage productPage = new ProductPage();

    @Step("Открытие корзины")
    public void openCartPageGetInfoItem() {
        productPage.productsElement.inventoryItemSauceLabsBackpack.click();
        String itemName = productPage.inventoryItemElements.productName.getText();
        String itemPrice = productPage.inventoryItemElements.productPrice.getText();
        productPage.productsElement.shoppingCart.click();
        assertThat(cartPage.cartElements.inventoryItemName.getText()).as("Наименование товара не соответствует выбранному значению").isEqualTo(itemName);
        assertThat(cartPage.cartElements.inventoryItemPrice.getText()).as("Цена товара не соответствует выбранному значению").isEqualTo(itemPrice);
    }

    @Step("Возвращение на страницу продуктов")
    public void continueShoppingOnProduct() {
        cartPage.cartElements.continueShoppingButton.click();
        assertThat(productPage.productsElement.productHeader.exists()).as("Страница Products не открывается").isTrue();
    }

    @Step("Нажать на кнопку Remove")
    public void removeBackPack() {
        cartPage.cartElements.removeFromCartBackPack.click();
        assertThat((cartPage.cartElements.inventoryItemName.exists()) && (cartPage.cartElements.inventoryItemPrice.exists()))
                .as("Товар отображается в корзине").isFalse();
        assertThat(productPage.productsElement.shoppingBadge.exists()).as("У корзины не пропал номер").isFalse();
    }
}
