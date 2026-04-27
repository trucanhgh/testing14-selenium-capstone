package base;

import constants.TimeOutConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@SuppressWarnings("unused")
public class BasePage {
    protected final Logger LOG = LogManager.getLogger(getClass());
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForVisible(By locator, long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator, long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForPresent(By locator, long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForInvisible(By locator, long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void click(By locator, long timeOutInSec) {
        LOG.info("Click locator: {}", locator);
        WebElement element = waitForClickable(locator, timeOutInSec);
        element.click();
    }

    public void click(By locator) {
        click(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void type(By locator, String value, long timeOutInSec) {
        WebElement element = waitForVisible(locator, timeOutInSec);
        LOG.info("Type value: {} into locator: {}", value, locator);
        element.clear();
        element.sendKeys(value);
    }

    public void type(By locator, String value) {
        type(locator, value, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void clear(By locator, long timeOutInSec) {
        WebElement element = waitForVisible(locator, timeOutInSec);
        LOG.info("Clear locator: {}", locator);
        element.clear();
    }

    public void clear(By locator) {
        clear(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void clearAndType(By locator, String value, long timeOutInSec) {
        WebElement element = waitForVisible(locator, timeOutInSec);
        LOG.info("Clear and type value: {} into locator: {}", value, locator);
        element.clear();
        element.sendKeys(value);
    }

    public void clearAndType(By locator, String value) {
        clearAndType(locator, value, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public String getText(By locator, long timeOutInSec) {
        WebElement element = waitForVisible(locator, timeOutInSec);
        return element.getText();
    }

    public String getText(By locator) {
        return getText(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public boolean isDisplayed(By locator, long timeOutInSec) {
        try {
            WebElement element = waitForVisible(locator, timeOutInSec);
            return element.isDisplayed();
        } catch (Exception e) {
            LOG.warn("Element not found or not visible for locator: {}", locator);
            return false;
        }
    }

    public boolean isDisplayed(By locator) {
        return isDisplayed(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public boolean isPresent(By locator, long timeOutInSec) {
        try {
            waitForPresent(locator, timeOutInSec);
            return true;
        } catch (Exception e) {
            LOG.warn("Element not found for locator: {}", locator);
            return false;
        }
    }

    public boolean isPresent(By locator) {
        return isPresent(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public int getElementCount(By locator) {
        return getElements(locator).size();
    }

    public void scrollToElement(By locator, long timeOutInSec) {
        WebElement element = waitForPresent(locator, timeOutInSec);
        LOG.info("Scroll to element locator: {}", locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }

    public void scrollToElement(By locator) {
        scrollToElement(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void scrollToTop() {
        LOG.info("Scroll to top");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToBottom() {
        LOG.info("Scroll to bottom");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void selectByVisibleText(By locator, String text, long timeOutInSec) {
        WebElement element = waitForVisible(locator, timeOutInSec);
        LOG.info("Select text: {} from locator: {}", text, locator);
        new Select(element).selectByVisibleText(text);
    }

    public void selectByVisibleText(By locator, String text) {
        selectByVisibleText(locator, text, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void inputText(By locator, String value, long timeOutInSec) {
        type(locator, value, timeOutInSec);
    }

    public void inputText(By locator, String value) {
        type(locator, value);
    }

    public void clickBtn(By locator, long timeOutInSec) {
        click(locator, timeOutInSec);
    }

    public void clickBtn(By locator) {
        click(locator);
    }

    public WebElement waitForElementVisible(By locator, long timeOutInSec) {
        return waitForVisible(locator, timeOutInSec);
    }

    public WebElement waitForElementClickable(By locator, long timeOutInSec) {
        return waitForClickable(locator, timeOutInSec);
    }

    public String getElementText(By locator, long timeOutInSec) {
        return getText(locator, timeOutInSec);
    }

    public String getElementText(By locator) {
        return getText(locator);
    }

    public boolean isElementDispayed(By locator, long timeOutInSec) {
        return isDisplayed(locator, timeOutInSec);
    }

    public boolean isElementDisplayed(By locator, long timeOutInSec) {
        return isDisplayed(locator, timeOutInSec);
    }

    public boolean isElementDisplayed(By locator) {
        return isDisplayed(locator);
    }

    public void refreshPage() {
        LOG.info("Refresh page");
        driver.navigate().refresh();
    }

    public void goBack() {
        LOG.info("Navigate back");
        driver.navigate().back();
    }

    public void goForward() {
        LOG.info("Navigate forward");
        driver.navigate().forward();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean waitForUrlContains(String partialUrl, long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public boolean waitForTitleContains(String partialTitle, long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        return wait.until(ExpectedConditions.titleContains(partialTitle));
    }

    public boolean waitForPageReady(long timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        return wait.until(webDriver -> {
            Object readyState = ((JavascriptExecutor) webDriver).executeScript("return document.readyState");
            return "complete".equals(readyState);
        });
    }
}
