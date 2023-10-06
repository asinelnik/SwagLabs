package servise;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import servise.WebDriver.SelenoidWebDriverProvider;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    TestConfig testConfig = ConfigFactory.create(TestConfig.class);
    String propUrl = testConfig.url();

    @BeforeClass
    public void setUp() {
        Configuration.browser = SelenoidWebDriverProvider.class.getCanonicalName();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUpAll() {
        open(propUrl);
    }

    @AfterClass
    public void close() {
        closeWebDriver();
    }
}
