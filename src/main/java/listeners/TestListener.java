package listeners;

import driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import report.ExtentReportManager;


public class TestListener implements ITestListener {

    private final Logger LOG = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("onTestStart: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        LOG.info("onTestSuccess: {} - PASSED", methodName);
        ExtentReportManager.pass("PASSED: " + methodName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        LOG.info("onTestFailure: {} - FAILED", methodName);

        Throwable throwable = result.getThrowable();
        String errorDetail = throwable != null ? throwable.toString() : "Test failed without throwable";
        LOG.error("Exception: {}", errorDetail);

        ExtentReportManager.fail("FAILED: " + methodName);
        ExtentReportManager.fail(errorDetail);
        ExtentReportManager.captureScreenshot(DriverFactory.getDriver(), methodName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        LOG.info("onTestSkipped: {}", methodName);
        Throwable throwable = result.getThrowable();
        String skipReason = throwable != null ? throwable.toString() : "No skip reason";
        ExtentReportManager.skip("SKIPPED: " + methodName);
        ExtentReportManager.skip(skipReason);
    }

    @Override
    public void onStart(ITestContext context) {
        LOG.info("onStart: {}", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        LOG.info("onFinish: {}", context.getName());
    }
}
