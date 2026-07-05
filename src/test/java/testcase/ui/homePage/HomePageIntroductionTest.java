package testcase.ui.homePage;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class HomePageIntroductionTest extends HomePageTestBase {
//============ INTRODUCTION BLOCK TESTS ============ TC_10 - TC_16
    @Test(description = "TC_10 - Xác minh hiển thị Block Khóa học")
    public void verifyCourseBlockDisplayed() {

        LOG.info("TC_10: Kiểm tra hiển thị Block 'Khóa học'");
        ExtentReportManager.info("TC_10: Kiểm tra hiển thị Block 'Khóa học'");
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed("Khóa học"));
        ExtentReportManager.pass("TC_10: Block 'Khóa học' hiển thị đúng.");
    }

    @Test(description = "TC_11 - Xác minh hiển thị Block 'Lộ trình phù hợp'")
    public void verifyLearningPathBlockDisplayed() {

        LOG.info("TC_11: Kiểm tra hiển thị Block 'Lộ trình phù hợp'");
        ExtentReportManager.info("TC_11 :Kiểm tra hiển thị Block 'Lộ trình phù hợp'");
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed("Lộ trình phù hợp"));
        ExtentReportManager.pass("TC_11: Block 'Lộ trình phù hợp' hiển thị đúng.");
    }

    @Test(description = "TC_12 - Xác minh hiển thị Block 'Hệ thống học tập'")
    public void verifyLearningSystemBlockDisplayed() {

        LOG.info("TC_12: Kiểm tra hiển thị Block 'Hệ thống học tập'");
        ExtentReportManager.info("TC_12: Kiểm tra hiển thị Block 'Hệ thống học tập'");
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed("Hệ thống học tập"));
        ExtentReportManager.pass("TC_12: Block 'Hệ thống học tập' hiển thị đúng");
    }

    @Test(description = "TC_13 - Xác minh hiển thị Block 'Giảng viên'")
    public void verifyInstructorBlockDisplayed() {

        LOG.info("TC_13: Kiểm tra hiển thị Block 'Giảng viên'");
        ExtentReportManager.info("TC_13: Kiểm tra hiển thị Block 'Giảng viên'");
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed("Giảng viên"));
        ExtentReportManager.pass("TC_13: Block 'Giảng viên' hiển thị đúng");
    }

    @Test(description = "TC_14 - Xác minh hiển thị Block 'Chứng nhận'")
    public void verifyCertificateBlockDisplayed() {

        LOG.info("TC_14: Kiểm tra hiển thị Block 'Chứng nhận'");
        ExtentReportManager.info("TC_14: Kiểm tra hiển thị Block 'Chứng nhận'");
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed("Chứng nhận"));
        ExtentReportManager.pass("TC_14: Block 'Chứng nhận' hiển thị đúng");
    }
//============ HOVER BLOCK INTRODUCTION TESTS ============ TC_15

    @Test(description = "TC_15.1 - Xác minh Hover Block 'Khóa học'")
    public void verifyHoverCourseBlock() {

        LOG.info("TC_15.1: Hover vào Block 'Khóa học'");
        ExtentReportManager.info("TC_15.1: Hover vào Block 'Khóa học'");
        homePage.hoverIntroductionBlock("Khóa học");
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed("Khóa học"));
        ExtentReportManager.pass("TC_15.1 :Hover Block 'Khóa học' thành công.");
    }

    @Test(description = "TC_15.2 - Xác minh Hover Block 'Lộ trình phù hợp'")
    public void verifyHoverLearningPathBlock() {

        LOG.info("TC_15.2: Hover vào Block 'Lộ trình phù hợp'");
        ExtentReportManager.info("TC_15.2: Hover vào Block 'Lộ trình phù hợp'");
        homePage.hoverIntroductionBlock("Lộ trình phù hợp");
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed("Lộ trình phù hợp"));
        ExtentReportManager.pass("TC_15.2: Hover Block 'Lộ trình phù hợp' thành công.");
    }

    @Test(description = "TC_15.3 - Xác minh Hover Block 'Hệ thống học tập'")
    public void verifyHoverLearningSystemBlock() {

        LOG.info("TC_15.3: Hover vào Block 'Hệ thống học tập'");
        ExtentReportManager.info("TC_15.3: Hover vào Block 'Hệ thống học tập'");
        homePage.hoverIntroductionBlock("Hệ thống học tập");
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed("Hệ thống học tập"));
        ExtentReportManager.pass("TC_15.3: Hover Block 'Hệ thống học tập' thành công.");
    }

    @Test(description = "TC_15.4 - Xác minh Hover Block 'Giảng viên'")
    public void verifyHoverInstructorBlock() {

        LOG.info("TC_15.4: Hover vào Block 'Giảng viên'");
        ExtentReportManager.info("TC_15.4: Hover vào Block 'Giảng viên'");
        homePage.hoverIntroductionBlock("Giảng viên");
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed("Giảng viên"));
        ExtentReportManager.pass("TC_15.4: Hover Block 'Giảng viên' thành công.");
    }

    @Test(description = "TC_15.5 - Xác minh Hover Block 'Chứng nhận'")
    public void verifyHoverCertificateBlock() {

        LOG.info("TC_15.5: Hover vào Block 'Chứng nhận'");
        ExtentReportManager.info("TC_15.5: Hover vào Block 'Chứng nhận'");
        homePage.hoverIntroductionBlock("Chứng nhận");
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed("Chứng nhận"));
        ExtentReportManager.pass("TC_15.5: Hover Block 'Chứng nhận' thành công.");    }

    @Test(description = "TC_16 - Xác minh màu nền các Block")
    public void verifyBlockBackgroundColor() {

        LOG.info("TC_16: Kiểm tra màu nền của các Block thông tin");
        ExtentReportManager.info("TC_16: Kiểm tra màu nền của các Block thông tin");

        // TODO:
        // Assert.assertEquals(homePage.getBlockBackgroundColor(), expectedColor);

        ExtentReportManager.fail("TC_16: Màu nền Block chưa được xác minh");
    }
}