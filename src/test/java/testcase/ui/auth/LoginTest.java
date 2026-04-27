package testcase.ui.auth;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Sample TC: login form accepts valid credential input")
    public void testValidLogin() {
        String username = "trucanhtest";
        String password = "Abcd1234@";

        maximizeWindow();
        openUrl("/login");
        waitForPageReady();

        WebDriver driver = getDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);

        loginPage.clickLoginBtn();
    }
}
