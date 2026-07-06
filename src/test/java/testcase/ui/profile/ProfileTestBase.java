package testcase.ui.profile;

import api.UserAPI;
import base.BaseTest;
import components.NavbarComponent;
import io.restassured.response.Response; // Thêm import này
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProfilePage;

public abstract class ProfileTestBase extends BaseTest {

    protected String dynamicUser;
    protected String dynamicEmail;
    protected final String dynamicPass = "ValidPass123@";
    protected final String dynamicPhone = "0901234567";
    protected final String existingSystemEmail = "abbcccdddd@gmail.com";

    // 1. Helper Method: Tạo tài khoản độc lập
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

    /**
     * Tự động Đăng nhập API -> Lấy Token -> Ghi danh danh sách khóa học cho User động vừa tạo
     * Giúp chuẩn bị trước data sạch hoàn toàn cho UI Test
     */

    protected void enrollCoursesForDynamicUserViaAPI(String[] maKhoaHocList) {
        // 1. Gọi API login chính tài khoản vừa tạo để lấy Bearer Token học viên
        Response loginRes = UserAPI.loginUser(dynamicUser, dynamicPass);
        Assert.assertEquals(loginRes.getStatusCode(), 200, "API Login để lấy Token học viên bị thất bại!");

        String userToken = loginRes.jsonPath().getString("accessToken");
        if (userToken == null) {
            userToken = loginRes.jsonPath().getString("token"); // Dự phòng trường hợp key trả về tên khác
        }
        Assert.assertNotNull(userToken, "Không lấy được mã Access Token của user từ API Login!");

        // 2. Tiến hành ghi danh hàng loạt qua token vừa lấy
        for (String maKhoaHoc : maKhoaHocList) {
            Response enrollRes = UserAPI.enrollCourseViaAPI(maKhoaHoc, dynamicUser, userToken);

            if (enrollRes.getStatusCode() != 200) {
                LOG.error("Ghi danh thất bại cho khóa học: " + maKhoaHoc + ". Response từ server: " + enrollRes.asString());
            }
            Assert.assertEquals(enrollRes.getStatusCode(), 200, "API Ghi danh khóa học " + maKhoaHoc + " bị lỗi!");
        }
        LOG.info("Đã ghi danh thành công " + maKhoaHocList.length + " khóa học bằng Token học viên cho: " + dynamicUser);
    }

    protected ProfilePage loginAndGoToProfile(String username, String password) {
        WebDriver driver = getDriver();

        openBaseUrl();
        waitForPageReady(20);

        NavbarComponent navbar = new NavbarComponent(driver);
        navbar.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();

        waitForPageReady(20);

        navbar.clickAvatar();
        navbar.openProfileLink();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForPageLoaded();

        return profilePage;
    }
}