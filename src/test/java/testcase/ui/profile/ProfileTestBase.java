package testcase.ui.profile;

import api.UserAPI;
import base.BaseTest;
import components.NavbarComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProfilePage;

public abstract class ProfileTestBase extends BaseTest {

    // Chuyển access modifier sang protected để các class con gọi được
    protected String dynamicUser;
    protected String dynamicEmail;
    protected final String dynamicPass = "ValidPass123@";
    protected final String dynamicPhone = "0901234567";
    protected final String existingSystemEmail = "abbcccdddd@gmail.com";


    // 1. Helper Method: Tạo tài khoản
    protected void createAccountViaAPI() {
        long timestamp = System.currentTimeMillis();
        dynamicUser = "auto_" + timestamp;
        dynamicEmail = "auto_" + timestamp + "@test.com";

        int statusCode = UserAPI.registerUser(
                dynamicUser, dynamicPass, "Test Auto Name", dynamicEmail, dynamicPhone, "GP01"
        ).getStatusCode();

        Assert.assertEquals(statusCode, 200, "API Tạo Account thất bại!");
        LOG.info("Đã tạo user thành công qua API: " + dynamicUser);
    }

    protected ProfilePage loginAndGoToProfile(String username, String password) {
        WebDriver driver = getDriver();

        // 1. Mở trang chủ và đợi script load xong\
        openBaseUrl();
        waitForPageReady(20);

        NavbarComponent navbar = new NavbarComponent(driver);

        // 2. Click nút Đăng nhập trên Navbar
        navbar.clickLoginLink();

        // 3. Thực hiện đăng nhập
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();

        // 4. Đợi quá trình gọi API login hoàn tất và render lại UI
        waitForPageReady(20);

        // 5. Mở trang Profile từ Avatar
        navbar.clickAvatar();
        navbar.openProfileLink();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForPageLoaded();

        return profilePage;
    }
}