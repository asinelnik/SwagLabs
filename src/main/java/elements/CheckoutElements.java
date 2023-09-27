package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CheckoutElements {
    public SelenideElement firstNameField = $("#first-name").as("Поле ввода имени");
    public SelenideElement lastNameField = $("#last-name").as("Поле ввода фамилии");
    public SelenideElement zipPostalCodeField = $("#postal-code").as("поле ввода почтового индекса");
    public ElementsCollection yourInformationForm = $$(".form_group").as("Форма заполнения информации о покупателе");
    public SelenideElement continueButton = $("#continue").as("Кнопка продолжения оформления товара");
    public SelenideElement finishButton = $("#finish").as("Кнопка завершения оформления");
    public SelenideElement inventoryItemName = $(".inventory_item_name").as("Наименование товара");
    public SelenideElement inventoryItemPrice = $(".inventory_item_price").as("Цена товара");
    public SelenideElement checkoutOverview = $x("//*[@class='title' and contains(text(), 'Checkout: Overview')]").as("Заголовок страницы Checkout");
    public SelenideElement itemTotal = $(".summary_subtotal_label").as("Общая стоимость оформляемого товара");
    public SelenideElement textTax = $(".summary_tax_label").as("Налог");
    public SelenideElement textTotal = $x("//*[@class='summary_info_label summary_total_label']").as("Общая стоимость с налогом");
    public SelenideElement paymentInformation = $x("//*[@class='summary_info_label' and contains (text(), 'Payment Information')]/following::div[1]")
            .as("Информация об оплате");
    public SelenideElement shippingInformation = $x("//*[@class='summary_info_label' and contains (text(), 'Shipping Information')]/following::div[1]")
            .as("Информация о доставке");
    public SelenideElement completeMessage = $(".complete-header").as("Сообщение Thank you for your order! после завершения оформления");
    public SelenideElement completePage = $x("//*[@class='title' and contains(text(), 'Checkout: Complete!')]")
            .as("Заголовок странице успешнго оформления товара");
}
