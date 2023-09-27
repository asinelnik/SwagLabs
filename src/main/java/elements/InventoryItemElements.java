package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class InventoryItemElements {
    public SelenideElement productName = $(".inventory_details_name").as("Наименование товара");
    public SelenideElement productPrice = $(".inventory_details_price").as("Цена товара");
}
