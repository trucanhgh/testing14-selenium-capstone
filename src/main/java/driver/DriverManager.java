package driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    //thuộc tính
    protected WebDriver driver;

    public WebDriver getDriver(){
        return this.driver;
    }

    public abstract void createWebDriver();
}
