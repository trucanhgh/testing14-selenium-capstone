package testcase.ui.homepage;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;



public class HomePageInstructorTest extends HomePageTestBase {
   // ============================INSTRUCTOR========================TC_43 - TC_51

    @Test(description = "TC_43 - Xác minh hiển thị tiêu đề 'Giảng viên hàng đầu'")
    public void verifyTopInstructorTitleDisplayed() {

        LOG.info("TC_43: Kiểm tra hiển thị tiêu đề 'Giảng viên hàng đầu'");
        ExtentReportManager.info("TC_43: Kiểm tra hiển thị tiêu đề 'Giảng viên hàng đầu'");
        Assert.assertTrue(homePage.isTopInstructorTitleDisplayed());
        ExtentReportManager.pass("TC_43: Tiêu đề hiển thị đúng");
    }

    @Test(description = "TC_44 - Xác minh hiển thị danh sách giảng viên")
    public void verifyInstructorContainerDisplayed() {

        LOG.info("TC_44: Kiểm tra hiển thị danh sách giảng viên");
        ExtentReportManager.info("TC_44: Kiểm tra hiển thị danh sách giảng viên");
        Assert.assertTrue(homePage.isInstructorContainerDisplayed());
        ExtentReportManager.pass("TC_44: Danh sách giảng viên hiển thị đúng");
    }

    @Test(description = "TC_45 - Xác minh hiển thị tên giảng viên")
    public void verifyInstructorNameDisplayed() {

        LOG.info("TC_45: Kiểm tra hiển thị tên giảng viên");
        ExtentReportManager.info("TC_45: Kiểm tra hiển thị tên giảng viên");
        Assert.assertTrue(homePage.isInstructorNameDisplayed("IcarDi MenBor"));
        // viết  test case cho từng tén giảng viên(locator động theo tên giảng viên)
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("Bladin Slaham"));
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("Chris Andersan"));
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("VueLo Gadi"));
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("Hoàng Nam"));
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("David Ngô Savani"));
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("Big DadMoon"));
        ExtentReportManager.pass("TC_45: Tên giảng viên hiển thị đúng");
    }


    @Test(
            dataProvider = "instructorNames", // Gọi lại danh sách tên giảng viên đã tạo ở BaseTest
            description = "TC_46 - Xác minh hiển thị ảnh giảng viên"
    )
    public void verifyImageDisplayed(String instructorName) {
        LOG.info("TC_46: Bắt đầu kiểm tra ảnh của giảng viên '" + instructorName + "'");
        ExtentReportManager.info("TC_46: Kiểm tra hiển thị ảnh của giảng viên '" + instructorName + "'");
        boolean isDisplayed = homePage.isInstructorImageDisplayed(instructorName);
        Assert.assertTrue(
                isDisplayed,
                "TC_46 Thất bại: Ảnh của giảng viên '" + instructorName + "' không hiển thị hoặc bị lỗi!");
        ExtentReportManager.pass("TC_46: Ảnh của giảng viên '" + instructorName + "' hiển thị thành công.");
    }

    @Test(
            dataProvider = "instructorNames",
            description = "TC_47 - Xác minh hiển thị chức danh giảng viên"
    )
    public void verifyInstructorRoleDisplayed(String instructorName) {

        LOG.info("TC_47: Bắt đầu kiểm tra chức danh của giảng viên '" + instructorName + "'");
        ExtentReportManager.info("TC_47: Bắt đầu kiểm tra chức danh giảng viên '" + instructorName + "'");
        String actualRole = homePage.getInstructorRole(instructorName);
        String expectedRole = homePage.getInstructorRole(instructorName);
        LOG.info("   -> Chức danh mong đợi (từ DataBase): " + expectedRole);
        LOG.info("   -> Chức danh thực tế (trên UI Web): " + actualRole);
        ExtentReportManager.info("Mong đợi: [" + expectedRole + "] | Thực tế: [" + actualRole + "]");
        Assert.assertEquals(
                actualRole,
                expectedRole,
                "TC_47 Thất bại: Chức danh của giảng viên '" + instructorName + "' không khớp!");
        ExtentReportManager.pass("TC_47: Chức danh hiển thị chính xác là '" + actualRole + "'.");
    }

    @Test(
            dataProvider = "instructorNames",
            description = "TC_48 - Xác minh hiển thị điểm đánh giá giảng viên"
    )
    public void verifyInstructorRatingDisplayed(String instructorName) {
        LOG.info("TC_48: Bắt đầu kiểm tra điểm đánh giá của giảng viên '" + instructorName + "'");
        ExtentReportManager.info("TC_48: Kiểm tra hiển thị điểm đánh giá giảng viên '" + instructorName + "'");
        boolean isRatingVisible = homePage.isRatingDisplayed(instructorName);
        Assert.assertTrue(
                isRatingVisible,
                "TC_48 Thất bại: Điểm đánh giá của giảng viên '" + instructorName + "' không hiển thị hoặc bị ẩn!");
        ExtentReportManager.pass("TC_48: Điểm đánh giá của giảng viên '" + instructorName + "' hiển thị thành công.");
    }


    @Test(
            dataProvider = "instructorNames",
            description = "TC_49 - Xác minh hiển thị lượt đánh giá của giảng viên"
    )
    public void verifyInstructorReviewCountDisplayed(String instructorName) {
        LOG.info("TC_49: Bắt đầu kiểm tra lượt đánh giá của giảng viên '" + instructorName + "'");
        ExtentReportManager.info("TC_49: Kiểm tra hiển thị lượt đánh giá giảng viên '" + instructorName + "'");
        boolean isReviewCountVisible = homePage.isReviewCountDisplayed(instructorName);
        Assert.assertTrue(
                isReviewCountVisible,
                "TC_49 Thất bại: Lượt đánh giá của giảng viên '" + instructorName + "' không hiển thị hoặc bị ẩn!");
        ExtentReportManager.pass("TC_49: Lượt đánh giá của giảng viên '" + instructorName + "' hiển thị thành công.");
    }

    @Test(description = "TC_50 - Xác minh Hover giảng viên")
    public void verifyHoverInstructorCard() {
        LOG.info("TC_50: Hover vào thẻ giảng viên");
        ExtentReportManager.info("TC_50: Hover vào thẻ giảng viên");
        homePage.hoverInstructorCard();
        Assert.assertTrue(homePage.isInstructorhoverDisplayed(), "TC_49 Thất bại: Hover vào thẻ giảng viên nhưng giao diện hover/thông tin bổ sung không hiển thị!");
        ExtentReportManager.pass("TC_50: Hover vào thẻ giảng viên thành công, giao diện hiển thị đúng.");
    }

    @Test(description = "TC_51 - Xác minh Click vào thẻ giảng viên")
    public void verifyClickInstructorCard() {
        LOG.info("TC_51: Click vào thẻ giảng viên");
        ExtentReportManager.info("TC_51: Click vào thẻ giảng viên");
        homePage.clickInstructorCardDisplayed();
        Assert.assertTrue(homePage.isInstructorDetailDisplayed(), "TC_50 Thất bại: Click vào thẻ giảng viên nhưng hệ thống không điều hướng đến trang chi tiết giảng viên!");
        ExtentReportManager.pass("TC_51: Điều hướng đến trang chi tiết giảng viên thành công.");
    }
}