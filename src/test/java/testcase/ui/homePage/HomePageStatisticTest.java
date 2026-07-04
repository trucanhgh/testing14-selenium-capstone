package testcase.ui.homePageTC;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class HomePage_04_StatisticTest extends HomePageTestBase {

    @Test(enabled = true, description = "TC_31 - TC_34: Xác minh hiển thị các Icon thống kê")
    public void verifyStatisticIconsDisplayed() {

        LOG.info("TC_31: Kiểm tra hiển thị Icon 'Học viên'");
        ExtentReportManager.info("TC_31: Kiểm tra hiển thị Icon 'Học viên'");
        Assert.assertTrue(homePage.isIconDisplayed());

        LOG.info("TC_32: Kiểm tra hiển thị Icon 'Khóa học'");
        ExtentReportManager.info("TC_32: Kiểm tra hiển thị Icon 'Khóa học'");
        Assert.assertTrue(homePage.isIconDisplayed());

        LOG.info("TC_33: Kiểm tra hiển thị Icon 'Giờ học'");
        ExtentReportManager.info("TC_33: Kiểm tra hiển thị Icon 'Giờ học'");
        Assert.assertTrue(homePage.isIconDisplayed());

        LOG.info("TC_34: Kiểm tra hiển thị Icon 'Giảng viên'");
        ExtentReportManager.info("TC_34: Kiểm tra hiển thị Icon 'Giảng viên'");
        Assert.assertTrue(homePage.isIconDisplayed());

        LOG.info("TC_31 - TC_34 hoàn thành");
        ExtentReportManager.pass("TC_31 - TC_34: Hiển thị đầy đủ các Icon thống kê");
    }

    @Test(enabled = true, description = "TC_35 - TC_38: Xác minh hiển thị tiêu đề thống kê")
    public void verifyStatisticTitlesDisplayed() {

        LOG.info("TC_35: Kiểm tra hiển thị Textbox 'Học viên'");
        ExtentReportManager.info("TC_35: Kiểm tra hiển thị Textbox 'Học viên'");
        Assert.assertTrue(homePage.isTitleSLDisplayed());

        LOG.info("TC_36: Kiểm tra hiển thị Textbox 'Khóa học'");
        ExtentReportManager.info("TC_36: Kiểm tra hiển thị Textbox 'Khóa học'");
        Assert.assertTrue(homePage.isTitleSLDisplayed());

        LOG.info("TC_37: Kiểm tra hiển thị Textbox 'Giờ học'");
        ExtentReportManager.info("TC_37: Kiểm tra hiển thị Textbox 'Giờ học'");
        Assert.assertTrue(homePage.isTitleSLDisplayed());

        LOG.info("TC_38: Kiểm tra hiển thị Textbox 'Giảng viên'");
        ExtentReportManager.info("TC_38: Kiểm tra hiển thị Textbox 'Giảng viên'");
        Assert.assertTrue(homePage.isTitleSLDisplayed());

        LOG.info("TC_35 - TC_38 hoàn thành");
        ExtentReportManager.pass("TC_35 - TC_38: Hiển thị đầy đủ các Textbox thống kê");
    }

    @Test(enabled = true, description = "TC_39 - TC_42: Xác minh hiển thị số liệu thống kê")
    public void verifyStatisticNumbersDisplayed() {

        LOG.info("TC_39: Kiểm tra hiển thị số liệu 'Học viên'");
        ExtentReportManager.info("TC_39: Kiểm tra hiển thị số liệu 'Học viên'");
        Assert.assertTrue(homePage.isNumberDisplayed());

        LOG.info("TC_40: Kiểm tra hiển thị số liệu 'Khóa học'");
        ExtentReportManager.info("TC_40: Kiểm tra hiển thị số liệu 'Khóa học'");
        Assert.assertTrue(homePage.isNumberDisplayed());

        LOG.info("TC_41: Kiểm tra hiển thị số liệu 'Giờ học'");
        ExtentReportManager.info("TC_41: Kiểm tra hiển thị số liệu 'Giờ học'");
        Assert.assertTrue(homePage.isNumberDisplayed());

        LOG.info("TC_42: Kiểm tra hiển thị số liệu 'Giảng viên'");
        ExtentReportManager.info("TC_42: Kiểm tra hiển thị số liệu 'Giảng viên'");
        Assert.assertTrue(homePage.isNumberDisplayed());

        LOG.info("TC_39 - TC_42 hoàn thành");
        ExtentReportManager.pass("TC_39 - TC_42: Hiển thị đầy đủ số liệu thống kê");
    }
}