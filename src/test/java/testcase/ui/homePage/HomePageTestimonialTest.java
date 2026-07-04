package testcase.ui.homePageTC;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class HomePage_06_TestimonialTest extends HomePageTestBase {

    @Test(enabled = true, description = "TC_51 - TC_52: Xác minh khu vực đánh giá của học viên")
    public void verifyStudentReviewDisplayedCorrectly() {

        LOG.info("TC_51: Kiểm tra hiển thị khu vực đánh giá học viên");
        ExtentReportManager.info("TC_51: Kiểm tra hiển thị khu vực đánh giá học viên");
        Assert.assertTrue(homePage.isReviewSectionDisplayed());

        LOG.info("TC_51: Kiểm tra hiển thị ảnh đại diện học viên");
        ExtentReportManager.info("TC_51: Kiểm tra hiển thị ảnh đại diện học viên");
        Assert.assertTrue(homePage.isStudentImageDisplayed());

        LOG.info("TC_51: Kiểm tra hiển thị nội dung đánh giá");
        ExtentReportManager.info("TC_51: Kiểm tra hiển thị nội dung đánh giá");
        Assert.assertTrue(homePage.isQuoteDisplayed());

        LOG.info("TC_52: Kiểm tra hiển thị tên học viên");
        ExtentReportManager.info("TC_52: Kiểm tra hiển thị tên học viên");
        Assert.assertTrue(homePage.isStudentNameDisplayed());

        LOG.info("TC_52: Kiểm tra hiển thị chức danh học viên");
        ExtentReportManager.info("TC_52: Kiểm tra hiển thị chức danh học viên");
        Assert.assertTrue(homePage.isStudentTitleDisplayed());

        LOG.info("TC_51 - TC_52 hoàn thành");
        ExtentReportManager.pass("TC_51 - TC_52: Khu vực đánh giá học viên hiển thị đầy đủ");
    }
}