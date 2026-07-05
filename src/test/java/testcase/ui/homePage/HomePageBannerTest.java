package testcase.ui.homePage;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class HomePageBannerTest extends HomePageTestBase {
//============ BANNER TESTS ============ TC_01 - TC_09
    @Test(description = "TC_01 - Kiểm tra hiển thị textbox 'Chào mừng đến với môi trường Vlearning'")
    public void verifyBannerTextDisplayed() {

        LOG.info("TC_01: Kiểm tra hiển thị textbox 'Chào mừng đến với môi trường Vlearning'");
        ExtentReportManager.info("TC_01: Kiểm tra hiển thị textbox 'Chào mừng đến với môi trường Vlearning'");
        Assert.assertTrue(homePage.isBannerTextDisplayed());
        ExtentReportManager.pass("TC_01: Banner text hiển thị đúng");
    }

    @Test(description = "TC_02 - Kiểm tra hiển thị Text Animation 'Vlearning'")
    public void verifyVlearningTextDisplayed() {
        LOG.info("TC_02: Kiểm tra hiển thị Text Animation 'Vlearning'");
        ExtentReportManager.info("TC_02: Kiểm tra hiển thị Text Animation 'Vlearning'");
        Assert.assertTrue(homePage.isVlearningTextDisplayed());
        ExtentReportManager.pass("TC_02: Text Animation hiển thị đúng");
    }

    @Test(description = "TC_03 - Kiểm tra hiển thị hình ảnh minh họa")
    public void verifyBannerImageDisplayed() {
        LOG.info("TC_03: Kiểm tra hiển thị hình ảnh minh họa");
        ExtentReportManager.info("TC_03: Kiểm tra hiển thị hình ảnh minh họa");
        Assert.assertTrue(homePage.isBannerImageDisplayed());
        ExtentReportManager.pass("TC_03: Banner Image hiển thị đúng");
    }

    @Test(description = "TC_04 - Kiểm tra hiển thị nút 'Bắt đầu nào'")
    public void verifyStartButtonDisplayed() {
        LOG.info("TC_04: Kiểm tra hiển thị nút 'Bắt đầu nào'");
        ExtentReportManager.info("TC_04: Kiểm tra hiển thị nút 'Bắt đầu nào'");
        Assert.assertTrue(homePage.isStartButtonDisplayed());
        ExtentReportManager.pass("TC_04: Nút 'Bắt đầu nào' hiển thị đúng");
    }
    @Test(description = "TC_06 - Verify Responsive Web")
    public void verifyResponsiveWeb() {
        int[][] screenSizes = {

                {1920,1080},
                {1366,768},
                {1024,768},
                {768,1024},
                {390,844}};

        for (int[] size : screenSizes) {

            homePage.resizeBrowser(1920, 1080);
            Assert.assertTrue(homePage.isBannerTextDisplayed());
            Assert.assertTrue(homePage.isVlearningTextDisplayed());
            Assert.assertTrue(homePage.isBannerImageDisplayed());

        }
    }
    @Test(description = "TC_07 - Verify GIF Image Display")
    public void verifyGifImageDisplayed() {

        LOG.info("TC_07: Kiểm tra GIF hiển thị");
        ExtentReportManager.info("TC_07: Kiểm tra GIF hiển thị");
        Assert.assertTrue(homePage.isBannerImageDisplayed());
        ExtentReportManager.pass("TC_07: GIF image hiển thị đúng.");
    }

    @Test(description = "TC_09 - Kiểm tra điều hướng khi click nút 'Bắt đầu nào'")
    public void verifyStartButtonNavigation() {
        LOG.info("TC_09: Click nút 'Bắt đầu nào'");
        ExtentReportManager.info("TC_09: Click nút 'Bắt đầu nào'");
        homePage.clickStartButton();
        LOG.info("TC_09: Kiểm tra điều hướng");
        ExtentReportManager.info("TC_09: Kiểm tra điều hướng");
        // TODO
        // Assert.assertTrue(homePage.isCoursePageDisplayed());
        ExtentReportManager.fail("TC_09: Điều hướng thành công");
    }

}