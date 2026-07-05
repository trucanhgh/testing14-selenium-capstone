package testcase.ui.homePage;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

public class HomePageStatisticTest extends HomePageTestBase {

    // ========================STATISTIC========================TC_31 - TC_42

    @Test(description = "TC_31 - Xác minh hiển thị Icon 'Học viên'")
    public void verifyStudentIconDisplayed() {

        LOG.info("TC_31: Kiểm tra hiển thị Icon 'Học viên'");
        ExtentReportManager.info("TC_31: Kiểm tra hiển thị Icon 'Học viên'");
        Assert.assertTrue(homePage.isStudentIconDisplayed());
        ExtentReportManager.pass("TC_31: Icon 'Học viên' hiển thị đúng");
    }

    @Test(description = "TC_32 - Xác minh hiển thị Icon 'Khóa học'")
    public void verifyTimetableIconDisplayed() {

        LOG.info("TC_32: Kiểm tra hiển thị Icon 'Khóa học'");
        ExtentReportManager.info("TC_32: Kiểm tra hiển thị Icon 'Khóa học'");
        Assert.assertTrue(homePage.isTimetableIconDisplayed());
        ExtentReportManager.pass("TC_32: Icon 'Khóa học' hiển thị đúng");
    }

    @Test(description = "TC_33 - Xác minh hiển thị Icon 'Giờ học'")
    public void verifyHourIconDisplayed() {

        LOG.info("TC_33: Kiểm tra hiển thị Icon 'Giờ học'");
        ExtentReportManager.info("TC_33: Kiểm tra hiển thị Icon 'Giờ học'");
        Assert.assertTrue(homePage.isHourIconDisplayed());
        ExtentReportManager.pass("TC_33: Icon 'Giờ học' hiển thị đúng");
    }

    @Test(description = "TC_34 - Xác minh hiển thị Icon 'Giảng viên'")
    public void verifyTeacherIconDisplayed() {

        LOG.info("TC_34: Kiểm tra hiển thị Icon 'Giảng viên'");
        ExtentReportManager.info("TC_34: Kiểm tra hiển thị Icon 'Giảng viên'");
        Assert.assertTrue(homePage.isTeacherIconDisplayed());
        ExtentReportManager.pass("TC_34: Icon 'Giảng viên' hiển thị đúng");
    }

    @Test(description = "TC_35 - Xác minh hiển thị Textbox 'Học viên'")
    public void verifyStudentTitleDisplayed() {

        LOG.info("TC_35: Kiểm tra Textbox 'Học viên'");
        ExtentReportManager.info("TC_35: Kiểm tra Textbox 'Học viên'");
        Assert.assertTrue(homePage.isTitleSLDisplayed("Học viên"));
        ExtentReportManager.pass("TC_35: Textbox 'Học viên' hiển thị đúng.");
    }

    @Test(description = "TC_36 - Xác minh hiển thị Textbox 'Khóa học'")
    public void verifyCourseTitleDisplayed() {

        LOG.info("TC_36: Kiểm tra Textbox 'Khóa học'");
        ExtentReportManager.info("TC_36: Kiểm tra Textbox 'Khóa học'");
        Assert.assertTrue(homePage.isTitleSLDisplayed("Khóa học"));
        ExtentReportManager.pass("TC_36: Textbox 'Khóa học' hiển thị đúng.");
    }

    @Test(description = "TC_37 - Xác minh hiển thị Textbox 'Giờ học'")
    public void verifyHourTitleDisplayed() {

        LOG.info("TC_37: Kiểm tra hiển thị Textbox 'Giờ học'");
        ExtentReportManager.info("TC_37: Kiểm tra hiển thị Textbox 'Giờ học'");
        Assert.assertTrue(homePage.isTitleSLDisplayed("Giờ học"));
        ExtentReportManager.pass("TC_37: Textbox 'Giờ học' hiển thị đúng");
    }

    @Test(description = "TC_38 - Xác minh hiển thị Textbox 'Giảng viên'")
    public void verifyTeacherTitleDisplayed() {

        LOG.info("TC_38: Kiểm tra hiển thị Textbox 'Giảng viên'");
        ExtentReportManager.info("TC_38: Kiểm tra hiển thị Textbox 'Giảng viên'");
        Assert.assertTrue(homePage.isTitleSLDisplayed("Giảng viên"));
        ExtentReportManager.pass("TC_38: Textbox 'Giảng viên' hiển thị đúng");
    }

    @Test(description = "TC_39 - Xác minh hiển thị số liệu 'Học viên'")
    public void verifyStudentNumberDisplayed() {

        LOG.info("TC_39: Kiểm tra số liệu 'Học viên'");
        ExtentReportManager.info("TC_39: Kiểm tra số liệu 'Học viên'");
        Assert.assertTrue(homePage.isStudentNumberDisplayed());
        ExtentReportManager.pass("TC_39: Số liệu 'Học viên' hiển thị đúng.");
    }

    @Test(description = "TC_40 - Xác minh hiển thị số liệu 'Khóa học'")
    public void verifyCourseNumberDisplayed() {

        LOG.info("TC_40: Kiểm tra số liệu 'Khóa học'");
        ExtentReportManager.info("TC_40: Kiểm tra số liệu 'Khóa học'");
        Assert.assertTrue(homePage.isCourseNumberDisplayed());
        ExtentReportManager.pass("TC_40: Số liệu 'Khóa học' hiển thị đúng.");
    }

    @Test(description = "TC_41 - Xác minh hiển thị số liệu 'Giờ học'")
    public void verifyHourNumberDisplayed() {

        LOG.info("TC_41: Kiểm tra số liệu 'Giờ học'");
        ExtentReportManager.info("TC_41: Kiểm tra số liệu 'Giờ học'");
        Assert.assertTrue(homePage.isHourNumberDisplayed());
        ExtentReportManager.pass("TC_41: Số liệu 'Giờ học' hiển thị đúng.");
    }

    @Test(description = "TC_42 - Xác minh hiển thị số liệu 'Giảng viên'")
    public void verifyTeacherNumberDisplayed() {

        LOG.info("TC_42: Kiểm tra số liệu 'Giảng viên'");
        ExtentReportManager.info("TC_42: Kiểm tra số liệu 'Giảng viên'");
        Assert.assertTrue(homePage.isTeacherNumberDisplayed());
        ExtentReportManager.pass("TC_42: Số liệu 'Giảng viên' hiển thị đúng.");
    }
}