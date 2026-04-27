package driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{
    @Override
    public void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (Boolean.getBoolean("headless")) {
            options.addArguments("-headless");
        }
        this.driver = new FirefoxDriver(options);
    }
}
