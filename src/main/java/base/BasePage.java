package base;

import constants.TimeOutConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final Logger LOG = LogManager.getLogger(getClass());
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementVisible(By locator, long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator, long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void inputText(By locator, String value, long timeOutInSec) {
        WebElement element = waitForElementVisible(locator, timeOutInSec);
        LOG.info("Input value: {} into locator: {}", value, locator);
        element.sendKeys(value);
    }

    public void inputText(By locator, String value) {
        inputText(locator, value, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void clickBtn(By locator, long timeOutInSec) {
        LOG.info("Click locator: {}", locator);
        WebElement element = waitForElementClickable(locator, timeOutInSec);
        element.click();
    }

    public void clickBtn(By locator) {
        clickBtn(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public String getTextElement(By locator, long timeOutInSec) {
        WebElement element = waitForElementVisible(locator, timeOutInSec);
        return element.getText();
    }

    public String getTextElement(By locator) {
        return getTextElement(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }
}
