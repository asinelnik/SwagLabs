package servise;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.ProductPage;
import servise.WebDriver.CustomChromeDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    CustomChromeDriver customChromeDriver = new CustomChromeDriver();
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    TestConfig testConfig = ConfigFactory.create(TestConfig.class);
    String propUrl = testConfig.url();
    String propUser = testConfig.user();
    String propPass = testConfig.password();

    String getBaseUrl = ConfigProvider.URL;
    String getLogin = ConfigProvider.LOGIN;
    String getPassword = ConfigProvider.PASSWORD;


    @BeforeClass
    public void setUp() {
        Configuration.browser = CustomChromeDriver.class.getCanonicalName();
        SelenideLogger.addListener("allure", new AllureSelenide());
        /*Configuration.browserCapabilities = new ChromeOptions()
                .addArguments("--window-size=1920,1080")
                .addArguments("--disable-cache")
                .addArguments("--disable-cookies")
                .addArguments("-incognito")
                .addArguments("--incognito")
                .addArguments("--disable-cache")
                .addArguments("--disable-application-cache")
                .addArguments("--disable-offline-load-stale-cache")
                .addArguments("--clear-session-cache")
                .addArguments("disable-gpu-shader-disk-cache")
                .addArguments("disable-gpu-sandbox");*/
        open(propUrl);
    }

    /**
     * Добавил закрытие вебдрайвера, чтобы открывалась для каждого теста новая страница,
     * либо все параметры небудут действовать в рамках одной инициализации веб драйвера
     */
    @AfterClass
    public void close() {
        closeWebDriver();
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
