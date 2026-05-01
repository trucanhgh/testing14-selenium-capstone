package testcase.ui.profile;

import base.BaseTest;
import components.NavbarComponent;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProfilePage;

public abstract class ProfileTestBase extends BaseTest {

    /**
     * Tái sử dụng luồng thao tác tự nhiên từ UI (Trang chủ -> Đăng nhập -> Profile)
     * để tránh lỗi crash do ép URL.
     */
    protected ProfilePage loginAndGoToProfile(String username, String password) {
        WebDriver driver = getDriver();

        // Dọn dẹp session trước khi chạy để test case độc lập
        driver.manage().deleteAllCookies();

        // 1. Mở trang chủ và đợi script load xong (Logic cũ của bạn)
        openBaseUrl();
        waitForPageReady(20);

        NavbarComponent navbar = new NavbarComponent(driver);

        // 2. Click nút Đăng nhập trên Navbar
        LOG.info("Đang nhấn nút Đăng nhập trên Navbar...");
        navbar.clickLoginLink();

        // 3. Thực hiện đăng nhập
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();

        // 4. Đợi quá trình gọi API login hoàn tất và render lại UI
        waitForPageReady(20);

        // 5. Mở trang Profile từ Avatar
        LOG.info("Đang mở trang Profile...");
        navbar.clickAvatar();
        navbar.openProfileLink();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForPageLoaded();

        return profilePage;
    }
}