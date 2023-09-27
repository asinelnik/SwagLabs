package servise;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.ProductPage;

import static com.codeborne.selenide.Condition.text;

public class BaseStep {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    TestConfig testConfig = ConfigFactory.create(TestConfig.class);
    String propUser = testConfig.user();
    String propPass = testConfig.password();

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


    public void removeAllItemFromCart() {
        if (productPage.productsElement.removeSauceLabsBackpack.exists()) {
            productPage.productsElement.removeSauceLabsBackpack.click();
        } else if (productPage.productsElement.removeSauceLabsBikeLight.exists()) {
            productPage.productsElement.removeSauceLabsBikeLight.click();
        } else if (productPage.productsElement.removeSauceLabsBoltTshirt.exists()) {
            productPage.productsElement.removeSauceLabsBoltTshirt.click();
        } else if (productPage.productsElement.removeSauceLabsFleeceJacket.exists()) {
            productPage.productsElement.removeSauceLabsFleeceJacket.click();
        } else if (productPage.productsElement.removeSauceLabsOnesie.exists()) {
            productPage.productsElement.removeSauceLabsOnesie.click();
        } else if (productPage.productsElement.removeSauceLabsBoltTshirtRed.exists()) {
            productPage.productsElement.removeSauceLabsBoltTshirtRed.click();
        }
    }
}
