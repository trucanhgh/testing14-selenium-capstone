package testcase.ui.homepage;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class HomePageTestimonialTest extends HomePageTestBase {
// =============Testimonial==========TC51-TC52
    @Test(description = "TC_51.1 - Xác minh hiển thị khu vực đánh giá học viên")
    public void verifyReviewSectionDisplayed() {
        LOG.info("TC_51.1: Kiểm tra hiển thị khu vực đánh giá học viên");
        ExtentReportManager.info("TC_51.1: Kiểm tra hiển thị khu vực đánh giá học viên");
        Assert.assertTrue(homePage.isReviewSectionDisplayed());
        ExtentReportManager.pass("TC_51.1: Khu vực đánh giá học viên hiển thị đúng.");
    }

    @Test(description = "TC_51.2 - Xác minh hiển thị ảnh đại diện học viên")
    public void verifyStudentImageDisplayed() {

        LOG.info("TC_51.2: Kiểm tra hiển thị ảnh đại diện học viên");
        ExtentReportManager.info("TC_51.2: Kiểm tra hiển thị ảnh đại diện học viên");
        Assert.assertTrue(homePage.isStudentImageDisplayed());
        ExtentReportManager.pass("TC_51.2: Ảnh đại diện học viên hiển thị đúng.");
    }

    @Test(description = "TC_51.3 - Xác minh hiển thị nội dung đánh giá")
    public void verifyQuoteDisplayed() {

        LOG.info("TC_51.3: Kiểm tra hiển thị nội dung đánh giá");
        ExtentReportManager.info("TC_51.3: Kiểm tra hiển thị nội dung đánh giá");
        Assert.assertTrue(homePage.isQuoteDisplayed());
        ExtentReportManager.pass("TC_51.3: Nội dung đánh giá hiển thị đúng.");
    }

    @Test(description = "TC_52.1 - Xác minh hiển thị tên học viên")
    public void verifyStudentNameDisplayed() {

        LOG.info("TC_52.1: Kiểm tra hiển thị tên học viên");
        ExtentReportManager.info("TC_52.1: Kiểm tra hiển thị tên học viên");
        Assert.assertTrue(homePage.isStudentNameDisplayed());
        ExtentReportManager.pass("TC_52.1: Tên học viên hiển thị đúng.");
    }

    @Test(description = "TC_52.2 - Xác minh hiển thị chức danh học viên")
    public void verifyStudentTitleDisplayed() {

        LOG.info("TC_52.2: Kiểm tra hiển thị chức danh học viên");
        ExtentReportManager.info("TC_52.2: Kiểm tra hiển thị chức danh học viên");
        Assert.assertTrue(homePage.isStudentTitleDisplayed());
        ExtentReportManager.pass("TC_52.2: Chức danh học viên hiển thị đúng.");
    }
}