package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Collections;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        ChromeOptions options = new ChromeOptions();

        // 1. Cấu hình chống sập, tối ưu hóa WebSocket & bộ nhớ
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");

        // Chiến lược tải trang EAGER - chỉ đợi DOM cơ bản load xong
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        // 2. Tắt dòng thông báo "Chrome is being controlled by automated test software"
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        // 3. Cấu hình riêng cho chế độ chạy ngầm (Headless)
        if (Boolean.getBoolean("headless")) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        // 4. Khởi tạo DUY NHẤT một instance driver với toàn bộ cấu hình trên
        WebDriver chromeDriver = new ChromeDriver(options);

        // Giới hạn thời gian tải trang tối đa là 20 giây
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        // Gán ngược lại cho biến driver của lớp cha (DriverManager)
        this.driver = chromeDriver;;
    }
}