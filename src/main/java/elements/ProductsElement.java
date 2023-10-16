package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProductsElement {
    public SelenideElement inventoryItemSauceLabsBackpack = $("a[id='item_4_title_link'] div[class^='inventory']")
            .as("Ссылка на страницу товара Sauce Labs Backpack");
    public SelenideElement addToCartButton = $("#add-to-cart-sauce-labs-backpack").as("Кнопка добавления в корзину");
    public SelenideElement removeFromCart = $x("//*[@class='btn btn_secondary btn_small btn_inventory']").as("Кнопка удаления товара из корзины");
    public SelenideElement addSauceLabsBackpack = $("#add-to-cart-sauce-labs-backpack").as("Кнопка добавления в корзину Sauce Labs Backpack");
    public SelenideElement removeSauceLabsBackpack = $("#remove-sauce-labs-backpack").as("Кнопка удаления из корзины Sauce Labs Backpack");
    public SelenideElement shoppingCart = $(".shopping_cart_link").as("Корзина");
    public SelenideElement shoppingBadge = $(".shopping_cart_badge").as("Иконка отображающая количество товаров в корзине");
    public SelenideElement productHeader = $x("//*[@class=\"title\" and contains(text(), 'Products')]").as("Заголовок страницы продукты");
    public ElementsCollection itemListButton = $$x("//div[@class='inventory_item']//button").as("Кнопки из карточки товара на странице Products");
}
