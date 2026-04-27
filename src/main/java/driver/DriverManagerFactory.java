package driver;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(String browser) {
        String normalizedBrowser = browser == null ? "chrome" : browser.trim().toLowerCase();
        switch (normalizedBrowser) {
            case "chrome":
                return new ChromeDriverManager();
            case "edge":
                return new EdgeDriverManager();
            case "firefox":
                return new FirefoxDriverManager();
            case "safari":
                return new SafariDriverManager();
            default:
                throw new IllegalArgumentException("Browser '" + browser + "' is not supported.");
        }
    }
}
