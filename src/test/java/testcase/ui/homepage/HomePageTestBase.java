package testcase.ui.homepage;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class HomePageTestBase extends BaseTest {

    protected HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void openHomePage() {
        openBaseUrl();          // mở trang chủ
        waitForPageReady();     // đợi load
        homePage = new HomePage(getDriver());
    }
}