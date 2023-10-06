package servise.WebDriver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SelenoidWebDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        RemoteWebDriver driver;
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-cache");
        options.addArguments("--disable-cookies");
        options.addArguments("-incognito");
        SeleniumManager.getInstance().getDriverPath(options, false);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), options);
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
            driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
            driver.setFileDetector(new LocalFileDetector());
            return driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            assert false;
            return null;
        }
    }
}
