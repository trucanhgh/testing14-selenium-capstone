package testcase.auth;

import base.BaseTest;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Sample TC: login form accepts valid credential input")
    public void testValidLogin() {
        String username = "trucanhtest";
        String password = "Abcd1234@";

        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://demo2.cybersoft.edu.vn/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUsername(username);
        loginPage.inputPassword(password);

        loginPage.clickLoginBtn();
    }
}
