package base;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverManagerFactory;
import report.ExtentReportManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class BaseTest {
    private static final String DEFAULT_BASE_URL = "https://demo2.cybersoft.edu.vn";
    protected final Logger LOG = LogManager.getLogger(getClass());

    @BeforeSuite
    public void setUpSuite() {
        LOG.info("Start suite setup - initialize extent report");
        ExtentReportManager.initializeExtentReports();
    }

    @BeforeClass
    @Parameters({"browser"})
    public void setUpClass(@Optional String browserFromSuite) {
        String browser = resolveBrowser(browserFromSuite);
        LOG.info("Start class setup - initialize web driver for browser: {}", browser);

        DriverManager driverManager = DriverManagerFactory.getDriverManager(browser);
        driverManager.createWebDriver();

        WebDriver driver = driverManager.getDriver();
        driver.manage().window().maximize();
        DriverFactory.setDriver(driver);
    }

    @BeforeMethod
    public void setUpMethod(Method method) {
        LOG.info("Start test method - create extent test for method: {}", method.getName());
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod
    public void tearDownMethod(ITestResult testResult) {
        LOG.info("End test method - handle result for method: {}", testResult.getName());
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String testName = testResult.getName() != null ? testResult.getName() : testResult.getMethod().getMethodName();
            ExtentReportManager.captureScreenshot(DriverFactory.getDriver(), testName);
            Throwable throwable = testResult.getThrowable();
            ExtentReportManager.fail(throwable != null ? throwable.toString() : "Test failed without throwable");
        }
    }

    @AfterClass
    public void tearDownClass() {
        LOG.info("End class setup - quit web driver");
        WebDriver driver = DriverFactory.getDriver();
        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            DriverFactory.removeDriverThreadLocal();
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        LOG.info("End suite setup - flush extent report");
        ExtentReportManager.flushReports();
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    protected String getBaseUrl() {
        String baseUrl = System.getProperty("baseUrl");
        if (baseUrl != null && !baseUrl.trim().isEmpty()) {
            return baseUrl.trim();
        }
        return DEFAULT_BASE_URL;
    }

    protected void openBaseUrl() {
        openUrl(getBaseUrl());
    }

    protected void openUrl(String urlOrPath) {
        WebDriver driver = getDriver();
        String targetUrl = urlOrPath;

        if (urlOrPath != null && !urlOrPath.trim().isEmpty() && !urlOrPath.startsWith("http://") && !urlOrPath.startsWith("https://")) {
            String baseUrl = getBaseUrl();
            if (urlOrPath.startsWith("/")) {
                targetUrl = baseUrl + urlOrPath;
            } else {
                targetUrl = baseUrl + "/" + urlOrPath;
            }
        }

        LOG.info("Open URL: {}", targetUrl);
        driver.get(targetUrl);
    }

    protected void maximizeWindow() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }

    protected void refreshPage() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.navigate().refresh();
        }
    }

    protected void waitForPageReady() {
        WebDriver driver = getDriver();
        if (driver == null) {
            return;
        }

        long timeoutSeconds = 20;
        long started = System.currentTimeMillis();
        while (System.currentTimeMillis() - started < timeoutSeconds * 1000L) {
            Object readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState");
            if ("complete".equals(readyState)) {
                return;
            }
        }
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
