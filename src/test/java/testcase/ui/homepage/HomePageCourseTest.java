package testcase.ui.homepage;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class HomePageCourseTest extends HomePageTestBase {
    //============ COURSE TESTS ============ TC_17 - TC_30
    @Test(description = "TC_17 - Xác minh hiển thị Textbox 'Khóa học phổ biến'")
    public void verifyPopularCourseTitleDisplayed() {

        LOG.info("TC_17: Kiểm tra hiển thị Textbox 'Khóa học phổ biến'");
        ExtentReportManager.info("TC_17: Kiểm tra hiển thị Textbox 'Khóa học phổ biến'");
        Assert.assertTrue(homePage.isPopularCourseDisplayed());
        ExtentReportManager.pass("TC_17: Hiển thị Textbox 'Khóa học phổ biến'");
    }

    @Test(description = "TC_18 - Xác minh hiển thị Textbox 'Khóa học tham khảo'")
    public void verifyReferenceCourseTitleDisplayed() {
        LOG.info("TC_18: Kiểm tra hiển thị Textbox 'Khóa học tham khảo'");
        ExtentReportManager.info("TC_18: Kiểm tra hiển thị Textbox 'Khóa học tham khảo'");
        Assert.assertTrue(homePage.isCategoryTitleDisplayed());
        ExtentReportManager.pass("TC_18: Hiển thị Textbox 'Khóa học tham khảo'");
    }

    @Test(description = "TC_19 - Xác minh hiển thị Textbox 'Khóa học Front End React Js'")
    public void verifyFrontEndReactCourseTitleDisplayed() {
        LOG.info("TC_19: Kiểm tra hiển thị Textbox 'Khóa học Front End React Js'");
        ExtentReportManager.info("TC_19: Kiểm tra hiển thị Textbox 'Khóa học Front End React Js'");
        Assert.assertTrue(homePage.isFrontEndReactCourseDisplayed());
        ExtentReportManager.pass("TC_19: Hiển thị Textbox 'Khóa học Front End React Js'");
    }

    @Test(description = "TC_20 - Xác minh hiển thị hình ảnh các khóa học")
    public void verifyCourseImageDisplayed() {
        LOG.info("TC_20: Kiểm tra hiển thị hình ảnh các khóa học");
        ExtentReportManager.info("TC_20: Kiểm tra hiển thị hình ảnh các khóa học");
        Assert.assertTrue(homePage.isCourseImageDisplayed(), "TC_20 Thất bại: Hiển thị hình ảnh không phù hợp các khóa học hoặc ảnh bị lỗi tải!");
        ExtentReportManager.pass("TC_20: Hình ảnh các khóa học hiển thị chính xác.");
    }

    @Test(description = "TC_21 - Xác minh hiển thị mô tả khóa học")
    public void verifyCourseDescriptionDisplayed() {
        LOG.info("TC_21: Kiểm tra hiển thị mô tả khóa học");
        ExtentReportManager.info("TC_21: Kiểm tra hiển thị mô tả khóa học");
        Assert.assertTrue(homePage.isCardBodyDisplayed(), "TC_21 Thất bại: Hiển thị mô tả khóa học lỗi trùng lặp hoặc không hiển thị phần thân thẻ!");
        ExtentReportManager.pass("TC_21: Mô tả khóa học hiển thị đầy đủ, không trùng lặp.");
    }

    @Test(description = "TC_22 - Xác minh hiển thị Label 'Yêu thích'")
    public void verifyFavoriteLabelDisplayed() {
        LOG.info("TC_22: Kiểm tra hiển thị Label 'Yêu thích'");
        ExtentReportManager.info("TC_22: Kiểm tra hiển thị Label 'Yêu thích'");
        Assert.assertTrue(homePage.isCardSaleDisplayed(), "TC_22 Thất bại: Hiển thị Label 'Yêu thích' bị vỡ layout hoặc không xuất hiện!");
        ExtentReportManager.pass("TC_22: Label 'Yêu thích' hiển thị đúng layout thiết kế.");
    }

    @Test(description = "TC_23 - Xác minh hiển thị Tag khóa học")
    public void verifyCourseTagDisplayed() {
        LOG.info("TC_23: Kiểm tra hiển thị Tag khóa học");
        ExtentReportManager.info("TC_23: Kiểm tra hiển thị Tag khóa học");
        Assert.assertTrue(homePage.isStickerDisplayed(), "TC_23 Thất bại: Hiển thị Tag khóa học lỗi trùng lặp hoặc không tương thích nội dung!");
        ExtentReportManager.pass("TC_23: Tag khóa học hiển thị chính xác, tương thích tốt với nội dung.");
    }

    @Test(description = "TC_24 - Xác minh hiển thị Icon thông tin thời lượng khóa học")
    public void verifyCourseIconDisplayed() {

        LOG.info("TC_24: Kiểm tra hiển thị Icon thời lượng khóa học");
        ExtentReportManager.info("TC_24: Kiểm tra hiển thị Icon thời lượng khóa học");
        Assert.assertTrue(homePage.isCardIconDisplayed());
        ExtentReportManager.pass("TC_24: Hiển thị Icon thời lượng khóa học");
    }

    @Test(description = "TC_25-28 - Xác minh hiển thị giá khóa học")
    public void verifyCoursePriceDisplayed() {
        LOG.info("TC_25-28: Kiểm tra hiển thị giá khóa học");
        ExtentReportManager.info("TC_25-28: Kiểm tra hiển thị giá khóa học");
        Assert.assertTrue(homePage.isPricesDisplayed());
        ExtentReportManager.pass("TC_25-28: Hiển thị giá khóa học");
    }

    @Test(description = "TC_26 - Xác minh hiển thị Profile Image")
    public void verifyTeacherAvatarDisplayed() {
        LOG.info("TC_26: Kiểm tra hiển thị Profile Image");
        ExtentReportManager.info("TC_26: Kiểm tra hiển thị Profile Image");
        Assert.assertTrue(homePage.isTeacherAvatarDisplayed());
        ExtentReportManager.pass("TC_26: Hiển thị Profile Image");
    }

    @Test(description = "TC_27 - Xác minh hiển thị tên giảng viên")
    public void verifyTeacherNameDisplayed() {
        LOG.info("TC_27: Kiểm tra hiển thị tên giảng viên");
        ExtentReportManager.info("TC_27: Kiểm tra hiển thị tên giảng viên");
        Assert.assertTrue(homePage.isTeacherNameDisplayed(), "TC_27 Thất bại: Tên giảng viên bị lỗi hiển thị hoặc trùng lặp cho tất cả các khóa học!");
        ExtentReportManager.pass("TC_27: Tên giảng viên hiển thị chính xác trên từng khóa học.");
    }

    @Test(description = "TC_29 - Xác minh khi Hover vào từng khóa học")
    public void verifyHoverCourseCard() {
        LOG.info("TC_29: Hover vào khóa học");
        ExtentReportManager.info("TC_29: Hover vào từng khóa học");
        homePage.hoverCourseCard();
        LOG.info("TC_29: Kiểm tra Hover Card");
        ExtentReportManager.info("TC_29: Kiểm tra Hover Card");
        Assert.assertTrue(homePage.isHoverCardDisplayed(), "TC_29 Thất bại: Hover Card hiển thị không đúng nội dung, bị lỗi trùng lặp dữ liệu!");
        ExtentReportManager.pass("TC_29: Hover vào khóa học hiển thị thông tin popover chính xác.");
    }

    @Test(description = "TC_30 - Xác minh Click khóa học")
    // Bạn có thể đổi thành enabled = true khi muốn chạy bài này
    public void verifyClickCourseCard() {
        LOG.info("TC_30: Click khóa học");
        ExtentReportManager.info("TC_30: Click khóa học");
        homePage.clickCourseCard();
        LOG.info("TC_30: Kiểm tra điều hướng sau khi click");
        ExtentReportManager.info("TC_30: Kiểm tra điều hướng sau khi click");
        Assert.assertTrue(homePage.isCourseDetailDisplayed(), "TC_30 Thất bại: Click vào khóa học nhưng hệ thống không điều hướng đến trang chi tiết!");
        ExtentReportManager.pass("TC_30: Điều hướng đến trang chi tiết khóa học thành công.");
    }
}