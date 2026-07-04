package testcase.ui.homePageTC;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class HomePage_03_CourseTest extends HomePageTestBase {

    @Test(enabled = true, description = "TC_17 - Xác minh hiển thị Textbox 'Khóa học phổ biến'")
    public void verifyPopularCourseTitleDisplayed() {

        LOG.info("TC_17: Kiểm tra hiển thị Textbox 'Khóa học phổ biến'");
        ExtentReportManager.info("TC_17: Kiểm tra hiển thị Textbox 'Khóa học phổ biến'");
        Assert.assertTrue(homePage.isPopularCourseDisplayed());
        ExtentReportManager.pass("TC_17: Hiển thị Textbox 'Khóa học phổ biến'");
    }

    @Test(enabled = true, description = "TC_18 - Xác minh hiển thị Textbox 'Khóa học tham khảo'")
    public void verifyReferenceCourseTitleDisplayed() {
        LOG.info("TC_18: Kiểm tra hiển thị Textbox 'Khóa học tham khảo'");
        ExtentReportManager.info("TC_18: Kiểm tra hiển thị Textbox 'Khóa học tham khảo'");
        Assert.assertTrue(homePage.isCategoryTitleDisplayed());
        ExtentReportManager.pass("TC_18: Hiển thị Textbox 'Khóa học tham khảo'");
    }

    @Test(enabled = true, description = "TC_19 - Xác minh hiển thị Textbox 'Khóa học Front End React Js'")
    public void verifyFrontEndReactCourseTitleDisplayed() {
        LOG.info("TC_19: Kiểm tra hiển thị Textbox 'Khóa học Front End React Js'");
        ExtentReportManager.info("TC_19: Kiểm tra hiển thị Textbox 'Khóa học Front End React Js'");
        Assert.assertTrue(homePage.isFrontEndReactCourseDisplayed());
        ExtentReportManager.pass("TC_19: Hiển thị Textbox 'Khóa học Front End React Js'");
    }

    @Test(enabled = true, description = "TC_20 - Xác minh hiển thị hình ảnh các khóa học")
    public void verifyCourseImageDisplayed() {

        LOG.info("TC_20: Kiểm tra hiển thị hình ảnh các khóa học");
        ExtentReportManager.info("TC_20: Kiểm tra hiển thị hình ảnh các khóa học");
        Assert.assertTrue(homePage.isCourseImageDisplayed());
        ExtentReportManager.fail("TC_20: Hiển thị hình ảnh không phù hợp các khóa học");
    }

    @Test(enabled = true, description = "TC_21 - Xác minh hiển thị mô tả khóa học")
    public void verifyCourseDescriptionDisplayed() {
        LOG.info("TC_21: Kiểm tra hiển thị mô tả khóa học");
        ExtentReportManager.info("TC_21: Kiểm tra hiển thị mô tả khóa học");
        Assert.assertTrue(homePage.isCardBodyDisplayed());
        ExtentReportManager.fail("TC_21: Hiển thị mô tả khóa học lỗi trùng lặp");
    }

    @Test(enabled = true, description = "TC_22 - Xác minh hiển thị Label 'Yêu thích'")
    public void verifyFavoriteLabelDisplayed() {

        LOG.info("TC_22: Kiểm tra hiển thị Label 'Yêu thích'");
        ExtentReportManager.info("TC_22: Kiểm tra hiển thị Label 'Yêu thích'");
        Assert.assertTrue(homePage.isCardSaleDisplayed());
        ExtentReportManager.fail("TC_22: Hiển thị Label 'Yêu thích' vỡ layout ");
    }

    @Test(enabled = true, description = "TC_23 - Xác minh hiển thị Tag khóa học")
    public void verifyCourseTagDisplayed() {

        LOG.info("TC_23: Kiểm tra hiển thị Tag khóa học");
        ExtentReportManager.info("TC_23: Kiểm tra hiển thị Tag khóa học");
        Assert.assertTrue(homePage.isStickerDisplayed());
        ExtentReportManager.fail("TC_23: Hiển thị Tag khóa học lỗi trùng lặp , không tương thích nội dung");
    }

    @Test(enabled = true, description = "TC_24 - Xác minh hiển thị Icon thông tin thời lượng khóa học")
    public void verifyCourseIconDisplayed() {

        LOG.info("TC_24: Kiểm tra hiển thị Icon thời lượng khóa học");
        ExtentReportManager.info("TC_24: Kiểm tra hiển thị Icon thời lượng khóa học");
        Assert.assertTrue(homePage.isCardIconDisplayed());
        ExtentReportManager.pass("TC_24: Hiển thị Icon thời lượng khóa học");
    }

    @Test(enabled = true, description = "TC_25 - Xác minh hiển thị giá khóa học")
    public void verifyCoursePriceDisplayed() {
        LOG.info("TC_25: Kiểm tra hiển thị giá khóa học");
        ExtentReportManager.info("TC_25: Kiểm tra hiển thị giá khóa học");
        Assert.assertTrue(homePage.isPricesDisplayed());
        ExtentReportManager.pass("TC_25: Hiển thị giá khóa học");
    }

    @Test(enabled = true, description = "TC_26 - Xác minh hiển thị Profile Image")
    public void verifyTeacherAvatarDisplayed() {
        LOG.info("TC_26: Kiểm tra hiển thị Profile Image");
        ExtentReportManager.info("TC_26: Kiểm tra hiển thị Profile Image");
        Assert.assertTrue(homePage.isTeacherAvatarDisplayed());
        ExtentReportManager.pass("TC_26: Hiển thị Profile Image");
    }

    @Test(enabled = true, description = "TC_27 - Xác minh hiển thị tên giảng viên")
    public void verifyTeacherNameDisplayed() {
        LOG.info("TC_27: Kiểm tra hiển thị tên giảng viên");
        ExtentReportManager.info("TC_27: Kiểm tra hiển thị tên giảng viên");
        Assert.assertTrue(homePage.isTeacherNameDisplayed());
        ExtentReportManager.fail("TC_27: Hiển thị tên giảng viên trùng lặp cho tất cả các khóa học");
    }

    @Test(enabled = true, description = "TC_29 - Xác minh khi Hover vào từng khóa học")
    public void verifyHoverCourseCard() {
        LOG.info("TC_29: Hover vào khóa học");
        ExtentReportManager.info("TC_29: Hover vào từng khóa học");
        homePage.hoverCourseCard();
        LOG.info("TC_29: Kiểm tra Hover Card");
        ExtentReportManager.info("TC_29: Kiểm tra Hover Card");
        Assert.assertTrue(homePage.isHoverCardDisplayed());
        ExtentReportManager.fail("TC_29: Hover Card hiển thị không đúng nội dung, trùng lặp");
    }

    @Test(enabled = true, description = "TC_30 - Xác minh Click khóa học")
    public void verifyClickCourseCard() {

        LOG.info("TC_30: Click khóa học");
        ExtentReportManager.info("TC_30: Click khóa học");

        homePage.clickCourseCard();

        LOG.info("TC_30: Thực hiện click thành công");
        ExtentReportManager.fail("TC_30: Click khóa học không điều hướng đến trang chi tiết");
    }
}