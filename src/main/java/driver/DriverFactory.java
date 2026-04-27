package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static void setDriver(WebDriver driver) {
        DRIVER.set(driver);
    }

    public static boolean hasDriver() {
        return getDriver() != null;
    }

    public static void quitDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
        }
        removeDriverThreadLocal();
    }

    public static void removeDriverThreadLocal() {
        DRIVER.remove();
    }
}
