package steps;

import io.qameta.allure.Step;
import pages.ProductPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductSteps {
    private final ProductPage productPage = new ProductPage();

    @Step("Проверка изменения кнопки на Remove")
    public void addBackpackInCart() {
        productPage.productsElement.addSauceLabsBackpack.click();
        assertThat(productPage.productsElement.removeSauceLabsBackpack.exists()).as("Кнопка Remove не отображается").isTrue();
        assertThat(productPage.productsElement.shoppingBadge.exists()).as("Не отображается бейдж указывающий количество товара в корзине").isTrue();
        assertThat(productPage.productsElement.shoppingBadge.getText()).as("Количество товара в корзине не соответствует ожидаемому").isEqualTo("1");
    }
}

