package servise.WebDriver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;

public class CustomChromeDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-cache");
        options.addArguments("--disable-cookies");
        options.addArguments("-incognito");
        options.setCapability("browserVersion", "117.0");
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        options.setCapability("videoName", "testUI" + ".mp4");
        options.setCapability("logName", "testUI" + ".log");

        SeleniumManager.getInstance().getDriverPath(options, false);
        return new ChromeDriver(options);
    }
}
