package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    private final Logger LOG = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("onTestStart: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("onTestSuccess: " + result.getMethod().getMethodName() + " - PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("onTestFailure: {} - FAILED", result.getMethod().getMethodName());
        Throwable throwable = result.getThrowable();
        LOG.error("Exception: {}", throwable != null ? throwable.toString() : "unknown");
        LOG.info("Screenshot capture is handled by BaseTest + ExtentReportManager");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.info("onTestSkipped: {}", result.getMethod().getMethodName());
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
