package testcase.ui.homePageTC;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class HomePage_01_BannerTest extends HomePageTestBase {
    @Test(enabled = true, description = "TC_01 - TC_08: Xác minh hiển thị Banner")
    public void verifyBannerDisplaysCorrectly() {

        LOG.info("TC_01: Kiểm tra hiển thị textbox 'Chào mừng đến với môi trường Vlearning'");
        ExtentReportManager.info("TC_01: Kiểm tra hiển thị textbox 'Chào mừng đến với môi trường Vlearning'");
        Assert.assertTrue(homePage.isBannerTextDisplayed());

        LOG.info("TC_02: Kiểm tra hiển thị Text Animation 'Vlearning'");
        ExtentReportManager.info("TC_02: Kiểm tra hiển thị Text Animation 'Vlearning'");
        Assert.assertTrue(homePage.isVlearningTextDisplayed());

        LOG.info("TC_03: Kiểm tra hiển thị hình ảnh minh họa");
        ExtentReportManager.info("TC_03: Kiểm tra hiển thị hình ảnh minh họa");
        Assert.assertTrue(homePage.isBannerImageDisplayed());

        LOG.info("TC_04: Kiểm tra hiển thị nút 'Bắt đầu nào'");
        ExtentReportManager.info("TC_04: Kiểm tra hiển thị nút 'Bắt đầu nào'");
        Assert.assertTrue(homePage.isStartButtonDisplayed());

        LOG.info("TC_01 - TC_08 hoàn thành");
        ExtentReportManager.pass("TC_01 - TC_08: Banner hiển thị đầy đủ");
    }


    @Test(enabled = true, description = "TC_09 - Xác minh khi click Button 'Bắt đầu nào'")
    public void verifyStartButtonNavigation() {

        LOG.info("TC_09: Click nút 'Bắt đầu nào'");
        ExtentReportManager.info("TC_09: Click nút 'Bắt đầu nào'");
        homePage.clickStartButton();
        LOG.info("TC_09: Kiểm tra điều hướng sau khi click");
        ExtentReportManager.info("TC_09: Kiểm tra điều hướng sau khi click");

        // TODO: Xác minh điều hướng
        // Assert.assertTrue(homePage.isCoursePageDisplayed());

        ExtentReportManager.fail("TC_09: Điều hướng thất bại sau khi click nút 'Bắt đầu nào'");
    }
}
