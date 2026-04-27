package testcase.ui.profile;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import components.NavbarComponent;
import pages.LoginPage;
import pages.ProfilePage;

public abstract class ProfileTestBase extends BaseTest {

    protected WebDriver openProfileAsLoggedInUser() {
        String username = resolveCredential("test.username", "TEST_USERNAME");
        String password = resolveCredential("test.password", "TEST_PASSWORD");

        if (isBlank(username) || isPlaceholder(username) || isBlank(password) || isPlaceholder(password)) {
            throw new SkipException("Profile UI tests require test.username and test.password (system property or env var).");
        }

        openBaseUrl();
        waitForPageReady();

        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginBtn();

        waitForPageReady();
        return driver;
    }

    protected ProfilePage openProfilePage() {
        WebDriver driver = openProfileAsLoggedInUser();

        // Entry flow may be adjusted later if the actual product uses a different navigation path.
        NavbarComponent navbar = new NavbarComponent(driver);
        navbar.clickAvatar();
        navbar.openProfileLink();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitForPageLoaded();
        return profilePage;
    }

    protected String resolveCredential(String systemPropertyName, String envName) {
        String value = System.getProperty(systemPropertyName);
        if (!isBlank(value)) {
            return value.trim();
        }

        value = System.getenv(envName);
        if (!isBlank(value)) {
            return value.trim();
        }

        return "REPLACE_ME";
    }

    protected boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    protected boolean isPlaceholder(String value) {
        return value != null && value.trim().equalsIgnoreCase("REPLACE_ME");
    }
}


