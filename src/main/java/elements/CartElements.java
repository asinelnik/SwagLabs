package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartElements {
    public SelenideElement inventoryItemName = $(".inventory_item_name").as("Наименование товара");
    public SelenideElement inventoryItemPrice = $(".inventory_item_price").as("Цена товара");
    public SelenideElement continueShoppingButton = $("#continue-shopping").as("Кнопка продолжить покупки");
    public SelenideElement checkoutButton = $("#checkout").as("Кнопка для перехода на страницу оформления товара");
    public SelenideElement removeFromCartBackPack = $("#remove-sauce-labs-backpack").as("Удалени из корзины товара Sauce Labs Backpack");
}
