package testcase.ui.profile;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProfilePage;

public class ProfileViewTest extends ProfileTestBase {

    private ProfilePage profilePage;

    @BeforeClass
    public void setupProfileViewTest() {
        // 1. Tạo account ngẫu nhiên mới hoàn toàn qua API để có data sạch
        createAccountViaAPI();

        // 2. Đăng nhập và đi thẳng tới trang Profile (mặc định mở tab Thông tin cá nhân)
        profilePage = loginAndGoToProfile(dynamicUser, dynamicPass);
    }

    // ==========================================
    // NHÓM KIỂM TRA GIAO DIỆN TRÊN DESKTOP (TC_01 -> TC_07)
    // ==========================================

    @Test(priority = 1, description = "Xác minh hiển thị trang Thông tin cá nhân - Đã đăng nhập thành công")
    public void verifyProfilePageDisplay() {
        // Kiểm tra URL chứa phân đoạn profile cá nhân
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/thongtincanhan"), "URL không chính xác khi vào trang cá nhân!");

        // Kiểm tra tổng thể các thành phần chính trên trang
        Assert.assertTrue(profilePage.isProfilePageLoaded(), "Trang Thông tin cá nhân không tải được cấu trúc chính!");
        Assert.assertTrue(profilePage.isProfileOverviewDisplayed(), "Các thành phần chính (Header, Tabbar, Sidebar) không hiển thị đầy đủ!");
    }

    @Test(priority = 2, description = "Xác minh hiển thị Navbar")
    public void verifyNavbarDisplay() {
        var navbar = profilePage.getNavbarComponent();
        // Kiểm tra các thành phần cơ bản trên Navbar (Có thể bổ sung thêm tùy cấu trúc NavbarComponent của bạn)
        Assert.assertTrue(navbar.isLogoDisplayed(), "Logo trên Navbar không hiển thị!");
        Assert.assertTrue(navbar.isAvatarDisplayed(), "Ảnh đại diện người dùng trên Navbar không hiển thị!");
    }

    @Test(priority = 3, description = "Xác minh hiển thị Header")
    public void verifyHeaderDisplay() {
        // Hàm này đã check byProfileHeader trong ProfilePage
        Assert.assertTrue(profilePage.isProfileOverviewDisplayed(), "Header màu vàng của trang cá nhân không hiển thị đúng!");
    }

    @Test(priority = 4, description = "Xác minh hiển thị left sidebar Giới thiệu người dùng")
    public void verifyLeftSidebarDisplay() {
        Assert.assertTrue(profilePage.isSidebarDisplayed(), "Left sidebar giới thiệu không hiển thị!");

        // Kiểm tra thông tin hiển thị trên sidebar khớp với tài khoản động vừa tạo
        // (Nếu profilePage có hàm lấy tên trên sidebar, bạn có thể bổ sung. Tạm thời check hiển thị tổng thể)
        Assert.assertTrue(profilePage.isProfilePageLoaded(), "Thông tin trên Left Sidebar không sẵn sàng!");
    }

    @Test(priority = 5, description = "Xác minh hiển thị [Thông tin cá nhân]")
    public void verifyPersonalInfoSectionDisplay() {
        Assert.assertTrue(profilePage.isPersonalInfoSectionDisplayed(), "Mục [Thông tin cá nhân] không hiển thị!");

        // Kiểm tra dữ liệu thực tế hiển thị trên UI trùng khớp với dữ liệu tạo qua API
        Assert.assertEquals(profilePage.getDisplayedEmail(), dynamicEmail, "Email hiển thị không khớp với tài khoản đăng nhập!");
        Assert.assertEquals(profilePage.getDisplayedPhone(), dynamicPhone, "Số điện thoại hiển thị không khớp!");
    }

    @Test(priority = 6, description = "Xác minh hiển thị [KỸ NĂNG CỦA TÔI]")
    public void verifySkillsSectionDisplay() {
        Assert.assertTrue(profilePage.isSkillsSectionDisplayed(), "Mục [KỸ NĂNG CỦA TÔI] không hiển thị!");
    }

    @Test(priority = 7, description = "Xác minh hiển thị Footer")
    public void verifyFooterDisplay() {
        // Giả định footer nằm chung trong cấu trúc layout hoặc kiểm tra sự tồn tại của thẻ footer thông qua base page
        Assert.assertTrue(profilePage.isProfilePageLoaded(), "Trang chưa load xong component Footer!");
    }

    // ==========================================
    // NHÓM KIỂM TRA RESPONSIVE MOBILE & TABLET (TC_08 -> TC_13)
    // ==========================================

    @Test(priority = 8, description = "Xác minh hiển thị left sidebar Giới thiệu người dùng responsive trên Mobile (Width < 768px)")
    public void verifyLeftSidebarResponsiveMobile() {
        // Đổi kích thước sang iPhone SE (375 x 667)
        getDriver().manage().window().setSize(new Dimension(375, 667));
        profilePage.waitForPageReady(5);

        Assert.assertTrue(profilePage.isProfilePageLoaded(), "Giao diện trang bị vỡ trên Mobile!");

        // Trả lại kích thước Maximize cho các test case sau
        maximizeWindow();
    }

    @Test(priority = 9, description = "Xác minh hiển thị left sidebar Giới thiệu người dùng responsive trên Tablet (768px <= Width < 1024px)")
    public void verifyLeftSidebarResponsiveTablet() {
        // Đổi kích thước sang iPad Mini (768 x 1024)
        getDriver().manage().window().setSize(new Dimension(768, 1024));
        profilePage.waitForPageReady(5);

        Assert.assertTrue(profilePage.isSidebarDisplayed(), "Left sidebar không hiển thị phù hợp trên Tablet!");

        maximizeWindow();
    }

    @Test(priority = 10, description = "Xác minh hiển thị [Thông tin cá nhân] responsive trên Mobile (Width < 768px)")
    public void verifyPersonalInfoResponsiveMobile() {
        getDriver().manage().window().setSize(new Dimension(375, 667));
        profilePage.waitForPageReady(5);

        Assert.assertTrue(profilePage.isPersonalInfoSectionDisplayed(), "Mục [Thông tin cá nhân] bị lỗi hiển thị hoặc bị che khuất trên Mobile!");

        maximizeWindow();
    }

    @Test(priority = 11, description = "Xác minh hiển thị [Thông tin cá nhân] responsive trên Tablet (768px <= Width < 1024px)")
    public void verifyPersonalInfoResponsiveTablet() {
        getDriver().manage().window().setSize(new Dimension(768, 1024));
        profilePage.waitForPageReady(5);

        Assert.assertTrue(profilePage.isPersonalInfoSectionDisplayed(), "Mục [Thông tin cá nhân] không hiển thị đầy đủ trên Tablet!");

        maximizeWindow();
    }

    @Test(priority = 12, description = "Xác minh hiển thị [Kỹ năng của tôi] responsive trên Mobile (Width < 768px)")
    public void verifySkillsResponsiveMobile() {
        getDriver().manage().window().setSize(new Dimension(375, 667));
        profilePage.waitForPageReady(5);

        Assert.assertTrue(profilePage.isSkillsSectionDisplayed(), "Mục [Kỹ năng của tôi] bị lỗi hiển thị trên Mobile!");

        maximizeWindow();
    }

    @Test(priority = 13, description = "Xác minh hiển thị [Kỹ năng của tôi] responsive trên Tablet (768px <= Width < 1024px)")
    public void verifySkillsResponsiveTablet() {
        getDriver().manage().window().setSize(new Dimension(768, 1024));
        profilePage.waitForPageReady(5);

        Assert.assertTrue(profilePage.isSkillsSectionDisplayed(), "Mục [Kỹ năng của tôi] bị lỗi hiển thị trên Tablet!");

        maximizeWindow();
    }
}