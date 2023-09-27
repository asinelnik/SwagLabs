package servise;

import org.aeonbits.owner.Config;
import org.openqa.selenium.WebDriver;

@Config.Sources("classpath:Application.properties")
public interface TestConfig extends Config {

    @Key("login.url")
    String url();

    @Key("login.login")
    String user();

    @Key("login.problemLogin")
    String problemUser();

    @Key("login.password")
    String password();
}
