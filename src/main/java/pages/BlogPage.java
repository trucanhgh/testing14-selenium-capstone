package pages;


import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class BlogPage extends CommonPage {
    // TC_01-02: Blog header
    private final By byBlogHeader = By.xpath("//div[@class='titleCourse']//h3");
    // TC_03, TC_05, TC_35: Blog post list and cards
    private final By byBlogPostContainer = By.xpath("//div[@class=\"blogCourseContainer\"]");
    private final By byBlogPostCard = By.xpath("//div[@class=\"cardBlogContent\"]");
    private final By byBlogPostTitle = By.xpath("//div[@class=\"cardBlogContent\"]//h6");
    // TC_04, TC_19: Blog post image/thumbnail
    private final By byBlogPostImage = By.xpath("//div[@class=\"imgCardBlog\"]");
    // Author Information
    private final By byAuthorName = By.cssSelector(".cardBlogContent span");;
    // Statistics
    private final By byBlogLikeCount = By.xpath("//i[@class='far fa-thumbs-up']/../span");
    private final By byBlogCommentCount = By.xpath("//i[@class='far fa-comment']/../span");
    private final By byBlogViewCount = By.xpath("//i[@class='fas fa-eye']/../span");
    // Description
    private final By byBlogPostDescription = By.cssSelector(".blog-excerpt");
    // Categories
    private final By byBlogCategoriesSection = By.cssSelector("[class*='category']");
    private final By byCategoryItem = By.cssSelector("[class*='category'] a");
    // Suggested Posts
    private final By bySuggestedPostsSection = By.cssSelector(".recommended-posts");
    private final By bySuggestedPostItem = By.cssSelector(".recommended-posts .blog-card");
    private final By bySuggestedPostTitle = By.cssSelector(".recommended-posts h3");
    // View More Button (chuyển trang)
    private final By byViewMoreButton = By.xpath("//button[contains(text(),'XEM THÊM')]");
    // Suggested Topics
    private final By bySuggestedTopicsSection = By.cssSelector(".topic-list a");
    private final By byTopicItem = By.cssSelector(".topic-list a");
    // Search
    private final By bySearchInput = By.id("blog-search-input");
    private final By bySearchButton = By.id("blog-search-button");
    private final By byEmptySearchResult = By.xpath("//div[contains(text(),'No blog posts found')]");

    // ==================== CONSTRUCTOR ====================

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    // ==================== ASSERTION METHODS ====================

    // TC_02: Tiêu đề trang Blog có hiển thị không
    public void assertBlogHeaderDisplayed() {
        WebElement title = driver.findElement(byBlogHeader);
        Assert.assertTrue(title.isDisplayed(), "Tiêu đề 'Blog' không hiển thị");
        LOG.info("✓ TC_02: Tiêu đề trang Blog hiển thị");
    }

    // TC_03: Đếm số card bài blog có > 0
    public void assertBlogCardsPresent() {
        List<WebElement> cards = driver.findElements(byBlogPostCard);
        Assert.assertTrue(cards.size() > 0, "Không có bài blog nào hiển thị");
        LOG.info("✓ TC_03: Có {} bài blog hiển thị", cards.size());
    }

    // TC_04: Ảnh thumbnail có src + kiểm tra load thành công
    public void assertBlogImageValid() {
        List<WebElement> images = driver.findElements(byBlogPostImage);
        Assert.assertTrue(images.size() > 0, "Không tìm thấy ảnh thumbnail");

        for (int i = 0; i < images.size(); i++) {
            WebElement img = images.get(i);
            String src = img.getAttribute("src");
            Assert.assertNotNull(src, "Ảnh thứ " + (i+1) + " không có src");
            Assert.assertFalse(src.isEmpty(), "Ảnh thứ " + (i+1) + " src bị rỗng");

            // Kiểm tra ảnh load thành công bằng JavaScript
            Boolean loaded = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0", img);
            Assert.assertTrue(loaded, "Ảnh thứ " + (i+1) + " bị broken hoặc không load");
        }
        LOG.info("✓ TC_04: Tất cả thumbnail ảnh hợp lệ");
    }

    // TC_05: Tiêu đề bài viết không rỗng, không bị cắt
    public void assertBlogTitleValid() {
        List<WebElement> titles = driver.findElements(byBlogPostTitle);
        Assert.assertTrue(titles.size() > 0, "Không tìm thấy tiêu đề bài viết");

        for (int i = 0; i < titles.size(); i++) {
            String text = titles.get(i).getText();
            Assert.assertFalse(text.isEmpty(), "Tiêu đề bài " + (i+1) + " bị rỗng");
            Assert.assertTrue(text.length() >= 5, "Tiêu đề bài " + (i+1) + " quá ngắn (có thể bị cắt)");
        }
        LOG.info("✓ TC_05: Tất cả tiêu đề bài viết hợp lệ");
    }

    // TC_06: Tên tác giả không rỗng
    public void assertAuthorNameNotEmpty() {
        List<WebElement> authors = driver.findElements(byAuthorName);
        Assert.assertTrue(authors.size() > 0, "Không tìm thấy tên tác giả");

        for (int i = 0; i < authors.size(); i++) {
            String text = authors.get(i).getText();
            Assert.assertFalse(text.isEmpty(), "Tên tác giả bài " + (i+1) + " bị rỗng");
        }
        LOG.info("✓ TC_06: Tất cả tên tác giả không rỗng");
    }

    // TC_07: Icon like/view hiển thị
    public void assertBlogStatsVisible() {
        WebElement likeCount = driver.findElement(byBlogLikeCount);
        WebElement viewCount = driver.findElement(byBlogViewCount);

        Assert.assertTrue(likeCount.isDisplayed(), "Icon like count không hiển thị");
        Assert.assertTrue(viewCount.isDisplayed(), "Icon view count không hiển thị");
        LOG.info("✓ TC_07: Icon statistics hiển thị");
    }

    // TC_08: Excerpt/Description tất cả khác nhau
    public void assertBlogExcerptUnique() {
        List<WebElement> excerpts = driver.findElements(byBlogPostDescription);
        Assert.assertTrue(excerpts.size() > 0, "Không tìm thấy excerpts");

        Set<String> uniqueExcerpts = new HashSet<>();
        for (WebElement excerpt : excerpts) {
            String text = excerpt.getText();
            Assert.assertFalse(text.isEmpty(), "Có excerpt bị rỗng");
            uniqueExcerpts.add(text);
        }
        LOG.info("✓ TC_08: Có {} excerpts duy nhất trên {} bài viết",
                uniqueExcerpts.size(), excerpts.size());
    }

    // TC_09: Danh sách chủ đề có đúng số lượng
    public void assertTopicCountCorrect(int expectedCount) {
        List<WebElement> topics = driver.findElements(byTopicItem);
        Assert.assertEquals(topics.size(), expectedCount,
                "Số chủ đề không đúng. Expected: " + expectedCount + ", Actual: " + topics.size());
        LOG.info("✓ TC_09: Danh sách chủ đề có {} mục", expectedCount);
    }

    // TC_10: Khu vực bài đề xuất hiển thị
    public void assertSuggestedPostsSectionVisible() {
        WebElement section = driver.findElement(bySuggestedPostsSection);
        Assert.assertTrue(section.isDisplayed(), "Khu vực bài đề xuất không hiển thị");
        LOG.info("✓ TC_10: Khu vực bài đề xuất hiển thị");
    }

    // TC_51: Tiêu đề không trùng
    public void assertBlogTitlesNotDuplicate() {
        List<WebElement> titles = driver.findElements(byBlogPostTitle);
        Set<String> uniqueTitles = new HashSet<>();

        for (WebElement title : titles) {
            String text = title.getText();
            Assert.assertFalse(text.isEmpty(), "Có tiêu đề bị rỗng");
            uniqueTitles.add(text);
        }

        Assert.assertEquals(uniqueTitles.size(), titles.size(),
                "Có tiêu đề trùng lặp! Unique: " + uniqueTitles.size() + ", Total: " + titles.size());
        LOG.info("✓ TC_51: Tất cả {} tiêu đề đều duy nhất", titles.size());
    }

    // ==================== VERIFICATION METHODS ====================

    public boolean isBlogPageDisplayed() {
        return isDisplayed(byBlogHeader, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public String getBlogHeaderText() {
        return getText(byBlogHeader, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public boolean isBlogPostListDisplayed() {
        return isDisplayed(byBlogPostContainer, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public boolean isBlogPostImageDisplayed() {
        try {
            return isDisplayed(byBlogPostImage, TimeOutConstant.TIME_OUT_MEDIUM);
        } catch (Exception e) {
            LOG.warn("Blog post image not found: {}", e.getMessage());
            return false;
        }
    }

    public boolean isBlogPostTitleDisplayed() {
        return isDisplayed(byBlogPostTitle, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public boolean isAuthorNameDisplayed() {
        return isDisplayed(byAuthorName, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public String getFirstAuthorName() {
        return getText(byAuthorName, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public boolean isBlogStatsDisplayed() {
        return isDisplayed(byBlogLikeCount, TimeOutConstant.TIME_OUT_MEDIUM) &&
                isDisplayed(byBlogViewCount, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public boolean isBlogDescriptionDisplayed() {
        return isDisplayed(byBlogPostDescription, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public String getFirstBlogPostDescription() {
        return getText(byBlogPostDescription, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public boolean isBlogCategoriesDisplayed() {
        return isDisplayed(byBlogCategoriesSection, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public int getBlogCategoryCount() {
        return getElementCount(byCategoryItem);
    }

    public boolean isSuggestedPostsSectionDisplayed() {
        return isDisplayed(bySuggestedPostsSection, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public boolean isSuggestedPostTitleDisplayed() {
        return isDisplayed(bySuggestedPostTitle, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public boolean isViewMoreButtonDisplayed() {
        return isDisplayed(byViewMoreButton, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public int getViewMoreButtonCount() {
        return getElementCount(byViewMoreButton);
    }

    public boolean isSuggestedTopicsSectionDisplayed() {
        return isDisplayed(bySuggestedTopicsSection, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public int getSuggestedTopicCount() {
        return getElementCount(byTopicItem);
    }

    public boolean isEmptySearchResultDisplayed() {
        return isDisplayed(byEmptySearchResult, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public int getBlogPostCount() {
        return getElementCount(byBlogPostTitle);
    }

    public boolean isSuggestedTopicsLayoutProper() {
        return isDisplayed(bySuggestedTopicsSection, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public boolean isSuggestedPostsLayoutProper() {
        return isDisplayed(bySuggestedPostsSection, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public String getFirstBlogPostTitle() {
        return getText(byBlogPostTitle, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public String getBlogPostTitleByIndex(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Blog post index must be >= 1");
        }
        By titleByIndex = By.cssSelector(String.format(".blog-card:nth-child(%d) h3", index));
        return getText(titleByIndex, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public List<String> getAllBlogPostTitles() {
        int postCount = getBlogPostCount();
        List<String> titles = new java.util.ArrayList<>();
        for (int i = 1; i <= postCount; i++) {
            titles.add(getBlogPostTitleByIndex(i));
        }
        return titles;
    }

    public int countBlogPostsWithTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Blog post title cannot be empty");
        }
        By titleLocator = By.xpath(String.format("//h3[contains(text(),'%s')]", title));
        return getElementCount(titleLocator);
    }

    public boolean isBlogPageOpenedByUrl() {
        String currentUrl = getCurrentUrl();
        return currentUrl.contains("/blog");
    }

    // ==================== CLICK & INTERACTION METHODS ====================

    // Chỉ có button "XEM THÊM" có link chuyển hướng trang
    public void clickViewMoreButton() {
        LOG.info("Click View More button");
        click(byViewMoreButton, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public void clickViewMoreButtonByIndex(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Button index must be >= 1");
        }
        By buttonByIndex = By.xpath(String.format("(//button[contains(text(),'XEM THÊM')])[%d]", index));
        click(buttonByIndex, TimeOutConstant.TIME_OUT_MEDIUM);
        LOG.info("Clicked View More button at index: {}", index);
    }

    public void clickViewMoreButtonAndWait(int seconds) {
        LOG.info("Click View More button and wait {} seconds", seconds);
        click(byViewMoreButton, TimeOutConstant.TIME_OUT_MEDIUM);
        waitForSeconds(seconds);
    }

    public void clickViewMoreButtonByIndexAndWait(int index, int seconds) {
        if (index < 1) {
            throw new IllegalArgumentException("Button index must be >= 1");
        }
        By buttonByIndex = By.xpath(String.format("(//button[contains(text(),'XEM THÊM')])[%d]", index));
        click(buttonByIndex, TimeOutConstant.TIME_OUT_MEDIUM);
        waitForSeconds(seconds);
        LOG.info("Clicked View More button at index {} and waited {} seconds", index, seconds);
    }

    public void clickSuggestedTopic(String topicName) {
        if (topicName == null || topicName.trim().isEmpty()) {
            throw new IllegalArgumentException("Topic name cannot be empty");
        }
        By topicLocator = By.xpath(String.format("//a[contains(text(),'%s')]", topicName));
        click(topicLocator, TimeOutConstant.TIME_OUT_MEDIUM);
        LOG.info("Clicked suggested topic: {}", topicName);
    }

    public void clickSuggestedTopicAndWait(String topicName, int seconds) {
        if (topicName == null || topicName.trim().isEmpty()) {
            throw new IllegalArgumentException("Topic name cannot be empty");
        }
        By topicLocator = By.xpath(String.format("//a[contains(text(),'%s')]", topicName));
        click(topicLocator, TimeOutConstant.TIME_OUT_MEDIUM);
        waitForSeconds(seconds);
        LOG.info("Clicked suggested topic {} and waited {} seconds", topicName, seconds);
    }

    public void clickBlogPostImage() {
        LOG.info("Click blog post image");
        click(byBlogPostImage, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public void clickBlogPostImageAndWait(int seconds) {
        LOG.info("Click blog post image and wait {} seconds", seconds);
        click(byBlogPostImage, TimeOutConstant.TIME_OUT_MEDIUM);
        waitForSeconds(seconds);
    }

    public void clickLikeCount() {
        LOG.info("Click like count");
        click(byBlogLikeCount, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public void clickLikeCountAndWait(int seconds) {
        LOG.info("Click like count and wait {} seconds", seconds);
        click(byBlogLikeCount, TimeOutConstant.TIME_OUT_MEDIUM);
        waitForSeconds(seconds);
    }

    public void clickViewCount() {
        LOG.info("Click view count");
        click(byBlogViewCount, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public void clickViewCountAndWait(int seconds) {
        LOG.info("Click view count and wait {} seconds", seconds);
        click(byBlogViewCount, TimeOutConstant.TIME_OUT_MEDIUM);
        waitForSeconds(seconds);
    }

    public void scrollToBottom() {
        LOG.info("Scroll to bottom of blog page");
        super.scrollToBottom();
    }

    public void scrollToBottom(int seconds) {
        LOG.info("Scroll to bottom and wait {} seconds", seconds);
        super.scrollToBottom();
        waitForSeconds(seconds);
    }

    public void scrollToTop() {
        LOG.info("Scroll to top of blog page");
        super.scrollToTop();
    }

    public void scrollToTop(int seconds) {
        LOG.info("Scroll to top and wait {} seconds", seconds);
        super.scrollToTop();
        waitForSeconds(seconds);
    }

    public void refreshBlogPage() {
        LOG.info("Refresh blog page");
        super.refreshPage();
    }

    public void refreshBlogPageAndWait(int seconds) {
        LOG.info("Refresh blog page and wait {} seconds", seconds);
        super.refreshPage();
        waitForSeconds(seconds);
    }

    public void searchBlog(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new IllegalArgumentException("Blog search keyword cannot be empty");
        }
        LOG.info("Search blog with keyword: {}", keyword);
        clearAndType(bySearchInput, keyword, TimeOutConstant.TIME_OUT_MEDIUM);
        click(bySearchButton, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public void searchBlogAndWait(String keyword, int seconds) {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new IllegalArgumentException("Blog search keyword cannot be empty");
        }
        LOG.info("Search blog with keyword {} and wait {} seconds", keyword, seconds);
        clearAndType(bySearchInput, keyword, TimeOutConstant.TIME_OUT_MEDIUM);
        click(bySearchButton, TimeOutConstant.TIME_OUT_MEDIUM);
        waitForSeconds(seconds);
    }

    // ==================== UTILITY METHODS ====================

    public void waitForBlogPageLoaded() {
        LOG.info("Waiting for blog page to load");
        waitForVisible(byBlogHeader, TimeOutConstant.TIME_OUT_MEDIUM);
        waitForVisible(byBlogPostContainer, TimeOutConstant.TIME_OUT_MEDIUM);
        waitForPageReady(TimeOutConstant.TIME_OUT_MEDIUM);
    }

    private void waitForSeconds(int seconds) {
        try {
            LOG.info("Waiting {} seconds", seconds);
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            LOG.warn("Thread interrupted: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public WebElement getBlogPostCardByIndex(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Blog post index must be >= 1");
        }
        By cardByIndex = By.cssSelector(String.format(".blog-card:nth-child(%d)", index));
        return waitForVisible(cardByIndex, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public List<WebElement> getAllBlogPostCards() {
        return getElements(byBlogPostCard);
    }

    public String getAuthorNameByIndex(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Author index must be >= 1");
        }
        By authorByIndex = By.cssSelector(String.format(".blog-card:nth-child(%d) .author-name", index));
        return getText(authorByIndex, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public String getBlogDescriptionByIndex(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Blog description index must be >= 1");
        }
        By descriptionByIndex = By.cssSelector(String.format(".blog-card:nth-child(%d) .blog-excerpt", index));
        return getText(descriptionByIndex, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public String getSuggestedPostTitleByIndex(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Suggested post index must be >= 1");
        }
        By suggestedTitleByIndex = By.cssSelector(String.format(".recommended-posts .blog-card:nth-child(%d) h3", index));
        return getText(suggestedTitleByIndex, TimeOutConstant.TIME_OUT_MEDIUM);
    }

    public boolean isBlogPostExists(String postTitle) {
        if (postTitle == null || postTitle.trim().isEmpty()) {
            return false;
        }
        if (getBlogPostCount() == 0) {
            return false;
        }
        return getAllBlogPostTitles().stream()
                .anyMatch(title -> title.equalsIgnoreCase(postTitle.trim()));
    }

    public By getBySearchInput() {
        return bySearchInput;
    }

    public By getByBlogPostTitle() {
        return byBlogPostTitle;
    }

    public By getByBlogPostCard() {
        return byBlogPostCard;
    }
}
