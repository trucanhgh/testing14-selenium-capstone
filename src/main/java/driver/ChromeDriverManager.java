package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Collections;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        ChromeOptions options = new ChromeOptions();

        // 1. Cấu hình áp dụng cho MỌI trường hợp (chống crash, mất kết nối)
        options.addArguments("--remote-allow-origins=*"); // Khắc phục lỗi websocket/DevTools bị ngắt kết nối
        options.addArguments("--no-sandbox"); // Vô hiệu hóa chế độ hộp cát, chống crash trên máy yếu hoặc CI/CD
        options.addArguments("--disable-dev-shm-usage"); // Khắc phục lỗi tràn bộ nhớ đệm (RAM) làm sập trình duyệt
        options.addArguments("--disable-notifications"); // Tắt các popup thông báo (Ví dụ: Allow/Block location)

        // 2. Tắt dòng thông báo "Chrome is being controlled by automated test software"
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        // 3. Cấu hình riêng cho chế độ chạy ngầm (Headless)
        if (Boolean.getBoolean("headless")) {
            options.addArguments("--headless=new"); // Chạy ngầm với engine mới của Chrome (render chuẩn như có UI)
            options.addArguments("--window-size=1920,1080"); // Set độ phân giải chuẩn để tránh lỗi không tìm thấy element
        }

        this.driver = new ChromeDriver(options);
    }
}