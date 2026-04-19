package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    //race condition

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //ThreadLocal: mỗi thread sẽ có một bản sao của biến này,
    //đảm bảo rằng mỗi thread sẽ có một instance riêng biệt của WebDriver, tránh xung đột khi nhiều thread cùng truy cập và sử dụng WebDriver.

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver driver){
        DriverFactory.driver.set(driver);
    }

    public static void removeDriverThreadLocal(){
        driver.remove();
    }
}
