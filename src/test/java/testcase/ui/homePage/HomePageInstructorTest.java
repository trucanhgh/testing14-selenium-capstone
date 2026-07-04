package testcase.ui.homePage;

import org.testng.Assert;
import org.testng.annotations.Test;
import report.ExtentReportManager;

import static constants.TimeOutConstant.EXPECTED_RATING;

public class HomePageInstructorTest extends HomePageTestBase {
   // ============================INSTRUCTOR========================TC_43 - TC_50

    @Test(description = "TC_43 - Xác minh hiển thị tiêu đề 'Giảng viên hàng đầu'")
    public void verifyTopInstructorTitleDisplayed() {

        LOG.info("TC_43: Kiểm tra hiển thị tiêu đề 'Giảng viên hàng đầu'");
        ExtentReportManager.info("TC_43: Kiểm tra hiển thị tiêu đề 'Giảng viên hàng đầu'");
        Assert.assertTrue(homePage.isTopInstructorTitleDisplayed());
        ExtentReportManager.pass("TC_43: Tiêu đề hiển thị đúng");
    }

    @Test(description = "TC_44 - Xác minh hiển thị danh sách giảng viên")
    public void verifyInstructorContainerDisplayed() {

        LOG.info("TC_44: Kiểm tra hiển thị danh sách giảng viên");
        ExtentReportManager.info("TC_44: Kiểm tra hiển thị danh sách giảng viên");
        Assert.assertTrue(homePage.isInstructorContainerDisplayed());
        ExtentReportManager.pass("TC_44: Danh sách giảng viên hiển thị đúng");
    }

    @Test(description = "TC_45 - Xác minh hiển thị tên giảng viên")
    public void verifyInstructorNameDisplayed() {

        LOG.info("TC_45: Kiểm tra hiển thị tên giảng viên");
        ExtentReportManager.info("TC_45: Kiểm tra hiển thị tên giảng viên");
        Assert.assertTrue(homePage.isInstructorNameDisplayed("IcarDi MenBor"));
        // viết  test case cho từng tén giảng viên(locator động theo tên giảng viên)
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("Bladin Slaham"));
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("Chris Andersan"));
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("VueLo Gadi"));
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("Hoàng Nam"));
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("David Ngô Savani"));
//        Assert.assertTrue(homePage.isInstructorNameDisplayed("Big DadMoon"));
        ExtentReportManager.pass("TC_45: Tên giảng viên hiển thị đúng");
    }


    @Test(description = "TC_46 - Xác minh hiển thị ảnh giảng viên ")
    public void verifyImageDisplayed() {

        LOG.info("TC_46: Kiểm tra hiển thị ảnh giảng viên ");
        ExtentReportManager.info("TC_46.1: Kiểm tra hiển thị ảnh giảng viên");
//        Assert.assertTrue(homePage.isInstructorImageDisplayed("IcarDi MenBor"));
        Assert.assertTrue(homePage.isInstructorImageDisplayed("Chris Andersan"));
//        Assert.assertTrue(homePage.isInstructorImageDisplayed("VueLo Gadi"));
//        Assert.assertTrue(homePage.isInstructorImageDisplayed("Hoàng Nam"));
//        Assert.assertTrue(homePage.isInstructorImageDisplayed("David Ngô Savani"));
//        Assert.assertTrue(homePage.isInstructorImageDisplayed("Big DadMoon"));
        ExtentReportManager.pass("TC_46: Ảnh giảng viên  hiển thị đúng.");
    }

    @Test(description = "TC_47 - Xác minh hiển thị chức danh giảng viên'IcarDi MenBor'")
    public void verifyInstructorRoleDisplayed() {
        ExtentReportManager.info("TC_47.1: Kiểm tra chức danh giảng viên 'IcarDi MenBor'");
        Assert.assertEquals(
                homePage.getInstructorRole("IcarDi MenBor"),
                homePage.getExpectedInstructorRole("IcarDi MenBor"));
        ExtentReportManager.pass("TC_47.1: Chức danh hiển thị đúng.");

//        ExtentReportManager.info("TC_47.2: Kiểm tra chức danh giảng viên 'Bladin Slaham'");
//        Assert.assertEquals(
//                homePage.getInstructorRole("Bladin Slaham"),
//                homePage.getExpectedInstructorRole("Bladin Slaham"));
//        ExtentReportManager.pass("TC_47.2: Chức danh hiển thị đúng.");
//
//        ExtentReportManager.info("TC_47.3: Kiểm tra chức danh giảng viên 'Chris Andersan'");
//        Assert.assertEquals(
//                homePage.getInstructorRole("Chris Andersan"),
//                homePage.getExpectedInstructorRole("Chris Andersan"));
//        ExtentReportManager.pass("TC_47.3: Chức danh hiển thị đúng.");
//
//        ExtentReportManager.info("TC_47.4: Kiểm tra chức danh giảng viên 'VueLo Gadi'");
//        Assert.assertEquals(
//                homePage.getInstructorRole("VueLo Gadi"),
//                homePage.getExpectedInstructorRole("VueLo Gadi"));
//        ExtentReportManager.pass("TC_47.4: Chức danh hiển thị đúng.");
//
//        ExtentReportManager.info("TC_47.5: Kiểm tra chức danh giảng viên 'Hoàng Nam'");
//        Assert.assertEquals(
//                homePage.getInstructorRole("Hoàng Nam"),
//                homePage.getExpectedInstructorRole("Hoàng Nam"));
//        ExtentReportManager.pass("TC_47.5: Chức danh hiển thị đúng.");
//
//        ExtentReportManager.info("TC_47.6: Kiểm tra chức danh giảng viên 'David Ngô Savani'");
//        Assert.assertEquals(
//                        homePage.getInstructorRole("David Ngô Savani"),
//                        homePage.getExpectedInstructorRole("David Ngô Savani"));
//        ExtentReportManager.pass("TC_47.6: Chức danh hiển thị đúng.");
//
//        ExtentReportManager.info("TC_47.7: Kiểm tra chức danh giảng viên 'Big DadMoon'");
//        Assert.assertEquals(
//                homePage.getInstructorRole("Big DadMoon"),
//                homePage.getExpectedInstructorRole("Big DadMoon"));
//        ExtentReportManager.pass("TC_47.7: Chức danh hiển thị đúng.");
    }

    @Test(description = "TC_48.1 - Xác minh điểm đánh giá giảng viên 'IcarDi MenBor'")
    public void verifyIcarDiMenBorRating() {

        LOG.info("TC_48: Kiểm tra điểm đánh giá giảng viên ");
        ExtentReportManager.info("TC_48.1: Kiểm tra điểm đánh giá giảng viên ");
        Assert.assertTrue(
                homePage.isRatingDisplayed("IcarDi MenBor"),
//              homePage.isReviewStarDisplayed("Bladin Slaham"),
//                .....
                EXPECTED_RATING);
        ExtentReportManager.pass("TC_48: Điểm đánh giá hiển thị đúng.");
    }

    @Test(description = "TC_48.3 - Xác minh hiển thị lượt đánh giá giảng viên")
    public void verifyReviewCountDisplayed() {

        LOG.info("TC_48.3: Kiểm tra hiển thị lượt đánh giá giảng viên");
        ExtentReportManager.info("TC_48.3: Kiểm tra hiển thị lượt đánh giá giảng viên");
        Assert.assertTrue(homePage.isReviewCountDisplayed());
        ExtentReportManager.pass("TC_48.3: Lượt đánh giá hiển thị đúng.");
    }


    @Test(description = "TC_49 - Xác minh Hover giảng viên")
    public void verifyHoverInstructorCard() {
        LOG.info("TC_49: Hover vào thẻ giảng viên");
        ExtentReportManager.info("TC_49: Hover vào thẻ giảng viên");
        homePage.hoverInstructorCard();
        ExtentReportManager.fail("TC_49: Hover giảng viên không thành công.");
    }

    @Test(description = "TC_50 - Xác minh Click vào thẻ giảng viên")
    public void verifyClickInstructorCard() {

        LOG.info("TC_50: Click vào thẻ giảng viên");
        ExtentReportManager.info("TC_50: Click vào thẻ giảng viên");
        homePage.clickInstructorCardDisplayed();
        Assert.assertTrue(homePage.isInstructorDetailDisplayed());
        ExtentReportManager.fail("TC_50: Điều hướng đến trang chi tiết giảng viên không thành công");
    }
}