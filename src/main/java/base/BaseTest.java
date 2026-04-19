package base;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverManagerFactory;
import report.ExtentReportManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class BaseTest {
    protected final Logger LOG = LogManager.getLogger(getClass());

    @BeforeSuite
    public void beforeSuite() {
        LOG.info("Starting berfore suite - initialize extent report");
        ExtentReportManager.initializeExtentReports();
    }

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(@Optional String browserFromSuite) {
        String browser = resolveBrowser(browserFromSuite);
        LOG.info("Starting before class - initialize web driver for browser: {}", browser);

        DriverManager driverManager = DriverManagerFactory.getDriverManager(browser);
        driverManager.createWebDriver();

        WebDriver driver = driverManager.getDriver();
        DriverFactory.setDriver(driver);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        LOG.info("Starting before method - create test in extent report for method: " + method.getName());
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        LOG.info("Starting after method - capture screenshot if test failed for method: " + testResult.getName());
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String testName = testResult.getName() != null ? testResult.getName() : testResult.getMethod().getMethodName();
            ExtentReportManager.captureScreenshot(DriverFactory.getDriver(), testName);
            ExtentReportManager.fail(testResult.getThrowable().toString());
        }
    }

    @AfterClass
    public void afterClass() {
        LOG.info("Starting after class - quit web driver");
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
        }
        DriverFactory.removeDriverThreadLocal();
    }

    @AfterSuite
    public void afterSuite() {
        LOG.info("Starting after suite - flush extent report");
        ExtentReportManager.flushReports();
    }

    private String resolveBrowser(String browserFromSuite) {
        if (browserFromSuite != null && !browserFromSuite.trim().isEmpty()) {
            return browserFromSuite.trim();
        }

        String browserFromProperty = System.getProperty("browser");
        if (browserFromProperty != null && !browserFromProperty.trim().isEmpty()) {
            return browserFromProperty.trim();
        }

        return "chrome";
    }
}
