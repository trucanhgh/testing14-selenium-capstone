package driver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends DriverManager{
    @Override
    public void createWebDriver() {
        EdgeOptions options = new EdgeOptions();
        if (Boolean.getBoolean("headless")) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }
        this.driver = new EdgeDriver(options);
    }
}
