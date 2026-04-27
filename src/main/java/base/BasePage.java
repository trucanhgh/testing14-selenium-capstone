package base;

import constants.TimeOutConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@SuppressWarnings("unused")
public class BasePage {
    protected final Logger LOG = LogManager.getLogger(getClass());
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForVisible(By locator, long timeoutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisible(By locator) {
        return waitForVisible(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public WebElement waitForClickable(By locator, long timeoutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForClickable(By locator) {
        return waitForClickable(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public WebElement waitForPresent(By locator, long timeoutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForInvisible(By locator, long timeoutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitForUrlContains(String partialUrl, long timeoutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec))
                .until(ExpectedConditions.urlContains(partialUrl));
    }

    public boolean waitForTitleContains(String partialTitle, long timeoutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec))
                .until(ExpectedConditions.titleContains(partialTitle));
    }

    public boolean waitForTextContains(By locator, String partialText, long timeoutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec))
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, partialText));
    }

    public boolean waitForAttributeContains(By locator, String attribute, String expectedValue, long timeoutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec))
                .until(ExpectedConditions.attributeContains(locator, attribute, expectedValue));
    }

    public boolean waitForPageReady(long timeoutInSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSec))
                .until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState")));
    }

    public void click(By locator, long timeoutInSec) {
        LOG.info("Click locator: {}", locator);
        waitForClickable(locator, timeoutInSec).click();
    }

    public void click(By locator) {
        click(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public boolean clickIfDisplayed(By locator, long timeoutInSec) {
        if (isDisplayed(locator, timeoutInSec)) {
            click(locator, timeoutInSec);
            return true;
        }
        return false;
    }

    public boolean clickIfDisplayed(By locator) {
        return clickIfDisplayed(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void scrollAndClick(By locator, long timeoutInSec) {
        scrollToElement(locator, timeoutInSec);
        click(locator, timeoutInSec);
    }

    public void scrollAndClick(By locator) {
        scrollAndClick(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void type(By locator, String value, long timeoutInSec) {
        WebElement element = waitForVisible(locator, timeoutInSec);
        LOG.info("Type value into locator: {}", locator);
        element.clear();
        element.sendKeys(value);
    }

    public void type(By locator, String value) {
        type(locator, value, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void clear(By locator, long timeoutInSec) {
        LOG.info("Clear locator: {}", locator);
        waitForVisible(locator, timeoutInSec).clear();
    }

    public void clear(By locator) {
        clear(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void clearAndType(By locator, String value, long timeoutInSec) {
        WebElement element = waitForVisible(locator, timeoutInSec);
        LOG.info("Clear and type into locator: {}", locator);
        element.clear();
        element.sendKeys(value);
    }

    public void clearAndType(By locator, String value) {
        clearAndType(locator, value, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void pressEnter(By locator, long timeoutInSec) {
        waitForVisible(locator, timeoutInSec).sendKeys(Keys.ENTER);
    }

    public void pressEnter(By locator) {
        pressEnter(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public String getText(By locator, long timeoutInSec) {
        return waitForVisible(locator, timeoutInSec).getText();
    }

    public String getText(By locator) {
        return getText(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public String getAttribute(By locator, String attributeName, long timeoutInSec) {
        return waitForVisible(locator, timeoutInSec).getAttribute(attributeName);
    }

    public String getAttribute(By locator, String attributeName) {
        return getAttribute(locator, attributeName, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public boolean isDisplayed(By locator, long timeoutInSec) {
        try {
            return waitForVisible(locator, timeoutInSec).isDisplayed();
        } catch (Exception e) {
            LOG.warn("Element not visible for locator: {}", locator);
            return false;
        }
    }

    public boolean isDisplayed(By locator) {
        return isDisplayed(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public boolean isPresent(By locator, long timeoutInSec) {
        try {
            waitForPresent(locator, timeoutInSec);
            return true;
        } catch (Exception e) {
            LOG.warn("Element not present for locator: {}", locator);
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

    public void scrollToElement(By locator, long timeoutInSec) {
        WebElement element = waitForPresent(locator, timeoutInSec);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }

    public void scrollToElement(By locator) {
        scrollToElement(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void hover(By locator, long timeoutInSec) {
        new Actions(driver).moveToElement(waitForVisible(locator, timeoutInSec)).perform();
    }

    public void hover(By locator) {
        hover(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void selectByVisibleText(By locator, String text, long timeoutInSec) {
        new Select(waitForVisible(locator, timeoutInSec)).selectByVisibleText(text);
    }

    public void selectByVisibleText(By locator, String text) {
        selectByVisibleText(locator, text, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    // Legacy aliases: keep temporary compatibility for old page objects.
    @Deprecated
    public void inputText(By locator, String value, long timeoutInSec) {
        type(locator, value, timeoutInSec);
    }

    @Deprecated
    public void inputText(By locator, String value) {
        type(locator, value);
    }

    @Deprecated
    public void clickBtn(By locator, long timeoutInSec) {
        click(locator, timeoutInSec);
    }

    @Deprecated
    public void clickBtn(By locator) {
        click(locator);
    }

    @Deprecated
    public WebElement waitForElementVisible(By locator, long timeoutInSec) {
        return waitForVisible(locator, timeoutInSec);
    }

    @Deprecated
    public WebElement waitForElementClickable(By locator, long timeoutInSec) {
        return waitForClickable(locator, timeoutInSec);
    }

    @Deprecated
    public String getElementText(By locator, long timeoutInSec) {
        return getText(locator, timeoutInSec);
    }

    @Deprecated
    public String getElementText(By locator) {
        return getText(locator);
    }

    @Deprecated
    public boolean isElementDisplayed(By locator, long timeoutInSec) {
        return isDisplayed(locator, timeoutInSec);
    }

    @Deprecated
    public boolean isElementDisplayed(By locator) {
        return isDisplayed(locator);
    }
}
