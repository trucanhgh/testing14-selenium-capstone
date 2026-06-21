package testcase.ui.auth;


import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void setupPage() {
        WebDriver driver = getDriver();
        homePage = new HomePage(driver);
        homePage.open();
    }

    @Test
    public void TC_01_VerifyWelcomeTextbox() {
        Assert.assertTrue(homePage.isWelcomeDisplayed());
    }

    @Test
    public void TC_02_VerifyVlearningText() {
        Assert.assertTrue(homePage.isVlearningDisplayed());
    }

    @Test
    public void TC_03_VerifyBannerImage() {
        Assert.assertTrue(homePage.isBannerDisplayed());
    }

    @Test
    public void TC_04_VerifyStartButton() {
        Assert.assertTrue(homePage.isStartButtonDisplayed());
    }

    @Test
    public void TC_08_VerifyGif() {
        Assert.assertTrue(homePage.isGifDisplayed());
    }

    @Test
    public void TC_10_VerifyCourseBlock() {
        Assert.assertTrue(homePage.isKhoaHocBlockDisplayed());
    }

    @Test
    public void TC_25_VerifyPrice() {
        Assert.assertTrue(homePage.isCoursePriceDisplayed());
    }

    @Test
    public void TC_26_VerifyTeacher() {
        Assert.assertTrue(homePage.isTeacherNameDisplayed());
    }

    @Test
    public void TC_27_VerifyCourseExist() {
        Assert.assertTrue(homePage.getTotalCourses() > 0);
    }
}