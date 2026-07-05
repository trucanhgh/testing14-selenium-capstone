package pages;


import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import constants.TimeOutConstant;


public class BlogPage extends CommonPage {
    private final By byBlogHeader = By.xpath("//div[@class='titleCourse']//h3");
    private final By byAllBlogTitles = By.xpath("//div[@class='cardBlogContent']//h6");
    private final By byAllBlogImages = By.xpath("//div[@class='imgCardBlog']//img");
    private final By byAllAuthorNames = By.xpath("//div[@class='timeBlogCourse']//p/span");
    private final By byAllLikeCounts = By.xpath("//div[@class='reviewBlog']/span[.//i[@class='far fa-thumbs-up']]");
    private final By byAllCommentCounts = By.xpath("//div[@class='reviewBlog']/span[.//i[@class='far fa-comment']]");
    private final By byAllViewCounts = By.xpath("//div[@class='reviewBlog']/span[.//i[@class='fas fa-eye']]");
    private final By byAllBlogDescs = By.xpath("//div[@class='cardBlogContent']//p[@class='colorCardTitle']");
    private final By byAllBtnCardBlog = By.xpath("//button[contains(@class,'btnCardBlog')]");
    private final By byLoadMoreBtn_B = By.xpath("//div[@class='blogCourseContainer']//button[not(contains(@class,'btnCardBlog'))]");
    private final By bySuggestedTopicsTitle = By.xpath("(//div[@class='blogRightBox']//h6)[1]");
    private final By byAllTopicLinks = By.xpath("//div[@class='blogRightBox']/ul/li/a");
    private final By bySuggestedPostsTitle = By.xpath("(//div[@class='blogRightBox']//h6)[2]");
    private final By byAllSuggestedTitles = By.xpath("//div[@class='postBlog']//h6");
    private final By byAllSuggestedDescs = By.xpath("//div[@class='postBlog']//p[@class='colorCardTitle']");
    private final By byAllSuggestedAuthors = By.xpath("//div[@class='postBlog']//span[@class='colorCardTitle']");


    public BlogPage(WebDriver driver) {
        super(driver);
    }


    public void waitForBlogPageLoaded() {
        // Thay vì dùng waitForPresent tự chế, hãy dùng cấu trúc chính thống từ BasePage của bạn
        waitForVisible(this.byBlogHeader, TimeOutConstant.TIME_OUT_LONG);
        waitForVisible(this.byAllBlogTitles, TimeOutConstant.TIME_OUT_LONG);
    }


    public void waitForMoreBlogCards(int previousCount, long timeoutInSec) {
        new WebDriverWait(this.driver, Duration.ofSeconds(timeoutInSec))
                .until(d -> getAllBlogTitles().size() > previousCount);
    }


    public void waitForUrlChange(String previousUrl, long timeoutInSec) {
        new WebDriverWait(this.driver, Duration.ofSeconds(timeoutInSec))
                .until(ExpectedConditions.not(ExpectedConditions.urlToBe(previousUrl)));
    }


    // TỐI ƯU: getCard nên đại diện cho toàn bộ khung của một bài viết (bao gồm cả ảnh và chữ)
    private WebElement getCard(int index) {
        return this.driver.findElement(By.xpath("(//div[contains(@class,'cardBlog')])[" + index + "]"));
    }


    private WebElement getPostBlog(int index) {
        return this.driver.findElement(By.xpath("(//div[@class='postBlog'])[" + index + "]"));
    }


    public String getBlogHeaderText() {
        return this.driver.findElement(this.byBlogHeader).getText();
    }


    public List<WebElement> getAllBlogTitles() {
        return this.driver.findElements(this.byAllBlogTitles);
    }


    public String getBlogTitleOfCard(int index) {
        return this.getCard(index).findElement(By.xpath(".//div[@class='cardBlogContent']//h6")).getText();
    }


    public List<WebElement> getAllBlogImages() {
        return this.driver.findElements(this.byAllBlogImages);
    }


    public boolean isBlogImageDisplayed(int index) {
        return this.getCard(index).findElement(By.xpath(".//div[@class='imgCardBlog']//img")).isDisplayed();
    }


    public String getBlogImageSrc(int index) {
        return this.getCard(index).findElement(By.xpath(".//div[@class='imgCardBlog']//img")).getAttribute("src");
    }


    public List<WebElement> getAllAuthors() {
        return this.driver.findElements(this.byAllAuthorNames);
    }


    public String getAuthorOfCard(int index) {
        return this.getCard(index).findElement(By.xpath(".//div[@class='timeBlogCourse']//p/span")).getText();
    }


    public String getLikeOfCard(int index) {
        return this.getCard(index).findElement(By.xpath(".//div[@class='reviewBlog']/span[.//i[contains(@class,'fa-thumbs-up')]]")).getText().trim();
    }


    public String getCommentOfCard(int index) {
        return this.getCard(index).findElement(By.xpath(".//div[@class='reviewBlog']/span[.//i[contains(@class,'fa-comment')]]")).getText().trim();
    }


    public String getViewOfCard(int index) {
        return this.getCard(index).findElement(By.xpath(".//div[@class='reviewBlog']/span[.//i[contains(@class,'fa-eye')]]")).getText().trim();
    }


    public List<WebElement> getAllDescriptions() {
        return this.driver.findElements(this.byAllBlogDescs);
    }


    public String getDescriptionOfCard(int index) {
        return this.getCard(index).findElement(By.xpath(".//p[@class='colorCardTitle']")).getText();
    }


    public void clickViewMoreOfCard(int index) {
        this.getCard(index).findElement(By.xpath(".//button[contains(@class,'btnCardBlog')]")).click();
    }


    public void clickLoadMoreAndWaitForMoreCards() {
        int previousCount = getAllBlogTitles().size();
        scrollAndClick(this.byLoadMoreBtn_B);
        waitForMoreBlogCards(previousCount, TimeOutConstant.TIME_OUT_LONG);
    }


    public String getSuggestedTopicsTitleText() {
        return this.driver.findElement(this.bySuggestedTopicsTitle).getText();
    }


    public List<WebElement> getAllTopicLinks() {
        return this.driver.findElements(this.byAllTopicLinks);
    }


    public void clickTopicByName(String name) {
        this.driver.findElement(By.xpath("//div[@class='blogRightBox']/ul/li/a[contains(normalize-space(),'" + name + "')]")).click();
    }


    public void clickTopicByNameAndWait(String name) {
        String previousUrl = getCurrentUrl();
        clickTopicByName(name);
        waitForUrlChange(previousUrl, TimeOutConstant.TIME_OUT_LONG);
    }


    public String getTopicHrefByName(String name) {
        return this.driver.findElement(By.xpath("//div[@class='blogRightBox']/ul/li/a[contains(normalize-space(),'" + name + "')]")).getAttribute("href");
    }


    public String getSuggestedPostsTitleText() {
        return this.driver.findElement(this.bySuggestedPostsTitle).getText();
    }


    public List<WebElement> getAllSuggestedTitles() {
        return this.driver.findElements(this.byAllSuggestedTitles);
    }


    public String getSuggestedTitleOfPost(int index) {
        return this.getPostBlog(index).findElement(By.tagName("h6")).getText();
    }


    public String getSuggestedDescOfPost(int index) {
        return this.getPostBlog(index).findElement(By.xpath(".//p[@class='colorCardTitle']")).getText();
    }


    public String getSuggestedAuthorOfPost(int index) {
        return this.getPostBlog(index).findElement(By.xpath(".//span[@class='colorCardTitle']")).getText();
    }
}

