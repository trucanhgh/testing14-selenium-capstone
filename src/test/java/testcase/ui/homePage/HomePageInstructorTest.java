package testcase.ui.homePageTC;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class HomePage_05_InstructorTest extends HomePageTestBase {

    @Test(enabled = true, description = "TC_43 - TC_50: Xác minh khu vực Giảng viên hàng đầu")
    public void verifyInstructorSectionDisplayedCorrectly() {

        LOG.info("TC_43: Kiểm tra hiển thị tiêu đề 'Giảng viên hàng đầu'");
        ExtentReportManager.info("TC_43: Kiểm tra hiển thị tiêu đề 'Giảng viên hàng đầu'");
        Assert.assertTrue(homePage.isInstructorContainerDisplayed());

        LOG.info("TC_44: Kiểm tra hiển thị danh sách giảng viên");
        ExtentReportManager.info("TC_44: Kiểm tra hiển thị danh sách giảng viên");
        Assert.assertTrue(homePage.isInstructorListDisplayed());

        LOG.info("TC_45: Kiểm tra hiển thị tên giảng viên");
        ExtentReportManager.info("TC_45: Kiểm tra hiển thị tên giảng viên");
        Assert.assertTrue(homePage.isInstructorNameDisplayed());

        LOG.info("TC_46: Kiểm tra hiển thị ảnh giảng viên");
        ExtentReportManager.info("TC_46: Kiểm tra hiển thị ảnh giảng viên");
        Assert.assertTrue(homePage.isInstructorImageDisplayed());

        LOG.info("TC_47: Kiểm tra hiển thị chức danh giảng viên");
        ExtentReportManager.info("TC_47: Kiểm tra hiển thị chức danh giảng viên");
        Assert.assertTrue(homePage.isInstructorRoleDisplayed());

        LOG.info("TC_48: Kiểm tra hiển thị đánh giá giảng viên");
        ExtentReportManager.info("TC_48: Kiểm tra hiển thị đánh giá giảng viên");
        Assert.assertTrue(homePage.isReviewDisplayed());
        Assert.assertTrue(homePage.isRatingDisplayed());
        Assert.assertTrue(homePage.isReviewCountDisplayed());

        LOG.info("TC_43 - TC_48 hoàn thành");
        ExtentReportManager.pass("TC_43 - TC_48: Khu vực Giảng viên hàng đầu hiển thị đầy đủ");
    }

    @Test(enabled = true, description = "TC_49 - Xác minh hiệu ứng Hover trên thẻ giảng viên")
    public void verifyInstructorHoverEffect() {

        LOG.info("TC_49: Hover vào thẻ giảng viên");
        ExtentReportManager.info("TC_49: Hover vào thẻ giảng viên");

        homePage.hoverInstructorCard();

        LOG.info("TC_49: Kiểm tra hiển thị thông tin sau khi hover");
        ExtentReportManager.info("TC_49: Kiểm tra hiển thị thông tin sau khi hover");

        Assert.assertTrue(homePage.isInstructorCardDisplayed());

        ExtentReportManager.fail("TC_49: Hover thẻ giảng viên không thành công");
    }

    @Test(enabled = true, description = "TC_50 - Xác minh Click vào thẻ giảng viên")
    public void verifyClickInstructorCard() {

        LOG.info("TC_50: Click thẻ giảng viên");
        ExtentReportManager.info("TC_50: Click thẻ giảng viên");

        homePage.clickInstructorCard();

        LOG.info("TC_50: Kiểm tra điều hướng đến trang chi tiết giảng viên");
        ExtentReportManager.info("TC_50: Kiểm tra điều hướng đến trang chi tiết giảng viên");

        Assert.assertTrue(homePage.isInstructorDetailDisplayed());

        ExtentReportManager.fail("TC_50: Điều hướng đến trang chi tiết giảng viên không thành công");
    }
}