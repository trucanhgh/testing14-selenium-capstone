package testcase.ui.homePageTC;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class HomePage_02_IntroductionTest extends HomePageTestBase {

    @Test(enabled = true, description = "TC_10 - TC_14: Xác minh hiển thị các Block thông tin")
    public void verifyInformationBlocksDisplayed() {

        LOG.info("TC_10: Kiểm tra hiển thị Block 'Khóa học'");
        ExtentReportManager.info("TC_10: Kiểm tra hiển thị Block 'Khóa học'");
        Assert.assertTrue(homePage.isTitleDisplayed("Khóa học"));

        LOG.info("TC_11: Kiểm tra hiển thị Block 'Lộ trình phù hợp'");
        ExtentReportManager.info("TC_11: Kiểm tra hiển thị Block 'Lộ trình phù hợp'");
        Assert.assertTrue(homePage.isTitleDisplayed("Lộ trình phù hợp"));

        LOG.info("TC_12: Kiểm tra hiển thị Block 'Hệ thống học tập'");
        ExtentReportManager.info("TC_12: Kiểm tra hiển thị Block 'Hệ thống học tập'");
        Assert.assertTrue(homePage.isTitleDisplayed("Hệ thống học tập"));

        LOG.info("TC_13: Kiểm tra hiển thị Block 'Giảng viên'");
        ExtentReportManager.info("TC_13: Kiểm tra hiển thị Block 'Giảng viên'");
        Assert.assertTrue(homePage.isTitleDisplayed("Giảng viên"));

        LOG.info("TC_14: Kiểm tra hiển thị Block 'Chứng nhận'");
        ExtentReportManager.info("TC_14: Kiểm tra hiển thị Block 'Chứng nhận'");
        Assert.assertTrue(homePage.isTitleDisplayed("Chứng nhận"));

        LOG.info("TC_10 - TC_14 hoàn thành");
        ExtentReportManager.pass("TC_10 - TC_14: Tất cả Block thông tin hiển thị đầy đủ");
    }

    @Test(enabled = true, description = "TC_15 - Xác minh hiệu ứng Hover trên các Block")
    public void verifyHoverEffectOnBlocks() {

        LOG.info("TC_15: Di chuyển chuột đến từng Block thông tin");
        ExtentReportManager.info("TC_15: Di chuyển chuột đến từng Block thông tin");

        // TODO: Hover vào từng Block
        // homePage.hoverOnInformationBlocks();

        LOG.info("TC_15: Kiểm tra hiệu ứng Hover");
        ExtentReportManager.info("TC_15: Kiểm tra hiệu ứng Hover");

        // TODO:
        // Assert.assertTrue(homePage.isHoverEffectDisplayed());

        ExtentReportManager.fail("TC_15: Hiệu ứng Hover chưa được xác minh");
    }

    @Test(enabled = true, description = "TC_16 - Xác minh màu nền các Block")
    public void verifyBlockBackgroundColor() {

        LOG.info("TC_16: Kiểm tra màu nền của các Block thông tin");
        ExtentReportManager.info("TC_16: Kiểm tra màu nền của các Block thông tin");

        // TODO:
        // Assert.assertEquals(homePage.getBlockBackgroundColor(), expectedColor);

        ExtentReportManager.fail("TC_16: Màu nền Block chưa được xác minh");
    }
}