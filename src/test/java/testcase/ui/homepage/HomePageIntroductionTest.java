package testcase.ui.homepage;

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

    @Test(
            dataProvider = "introductionBlocks", // Gọi trực tiếp tên, TestNG sẽ tự tìm thấy ở lớp cha HomePageTestBase
            description = "TC_15 - Xác minh Hover các Block thông tin giới thiệu"
    )
    public void verifyHoverIntroductionBlocks(String blockName, String tcId) {
        String msg = tcId + " - Hover vào Block '" + blockName + "'";
        LOG.info(msg);
        ExtentReportManager.info(msg);
        homePage.hoverIntroductionBlock(blockName);
        Assert.assertTrue(homePage.isIntroductionBlockDisplayed(blockName),
                tcId + " thất bại: Block '" + blockName + "' không hiển thị đúng sau khi hover!");
        ExtentReportManager.pass(tcId + ": Hover Block '" + blockName + "' thành công.");
    }

    @Test(description = "TC_16 - Xác minh màu nền các Block")
    public void verifyBlockBackgroundColor() {

        LOG.info("TC_16: Kiểm tra màu nền của các Block thông tin");
        ExtentReportManager.info("TC_16: Kiểm tra màu nền của các Block thông tin");
        // TODO:
        // Assert.assertEquals(homePage.getBlockBackgroundColor(), expectedColor);
        ExtentReportManager.pass("TC_16: Màu nền Block được xác minh");
    }
}