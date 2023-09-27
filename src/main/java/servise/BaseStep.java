package servise;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import pages.LoginPage;
import pages.ProductPage;

import static com.codeborne.selenide.Condition.text;

public class BaseStep {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    static TestConfig testConfig = ConfigFactory.create(TestConfig.class);
    static String propUser = testConfig.user();
    static String propPass = testConfig.password();

    static String problemUser = testConfig.problemUser();

    @DataProvider(name = "authParamUser")
    public static Object[][] authParamUser() {
        return new Object[][]{
                {propUser, propPass},
                {problemUser, propPass}
        };
    }
    public void loginOnStartPageDataProvider(String a, String b){
        loginPage.loginElements.userNameField.sendKeys(a);
        loginPage.loginElements.passwordField.sendKeys(b);
        loginPage.loginElements.loginButton.click();
    }

    public void loginInOnStartPage() {
        loginPage.loginElements.userNameField.sendKeys(propUser);
        loginPage.loginElements.passwordField.sendKeys(propPass);
        loginPage.loginElements.loginButton.click();
    }

    public void getSauceLabsBackpackInCart() {
        productPage.productsElement.inventoryItemSauceLabsBackpack.click();
        productPage.productsElement.addToCartButton.click();
        productPage.productsElement.shoppingCart.click();
    }


    public void cycleForPasha() {
        while (productPage.productsElement.removeFromCart.exists()) {
            productPage.productsElement.removeFromCart.click();
        }
    }

    //Не нашел информации по коллекциям, как можно реализовать в одну строку
    public void collectionForPasha() {
        for (WebElement element : productPage.productsElement.itemListButton.filterBy(text("Remove"))) {
            element.click();
        }
    }
}
