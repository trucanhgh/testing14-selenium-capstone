package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;



public class HomePage extends CommonPage {

    // ================= BANNER =================

    private final By byBannerText = By.xpath("//div[@class='sloganContainer']/parent::div");
    private final By byVlearningText = By.xpath("//h1[contains(.,'Vlearning')]");
    private final By byStartBtn = By.xpath("//button[text()='Bắt đâu nào']");
    private final By byBannerImg = By.xpath("//div[img[@class='sliderMainImg']]");

    // ================= GIỚI THIỆU =================
    private final By byIntroductionSection= By.xpath("//div[contains(@class,'infoCourseHome')]");
    private final By byFoItem = By.xpath("//div[contains(@class,'infoItemHome')]//h3");
    private final By byTitle = By.xpath("//div[contains(@class,'infoItemContent')]/h3");
    private final By byDescription = By.xpath("//div[contains(@class,'infoItemContent')]/p");
    private final By byListItem = By.xpath("//div[contains(@class,'infoItemContent')]//li/span");

    // ================= DANH SÁCH KHÓA HỌC ==================
    private final By byPopularCourse = By.xpath("//*[contains(text(),'Khóa học phổ biến')]");
    private final By byCategoryTitle = By.xpath("//*[contains(text(),'Khóa học tham khảo')]");
    private final By byFrontEndReactCourse = By.xpath("//*[contains(text(),'Khóa học Front End React Js')]");
    private final By byCourseCard = By.xpath("//div[contains(@class,'cardGlobalRes')]");
    private final By byCardSale = By.xpath("//div[contains(@class,'cardSale')]");
    private final By bySticker = By.xpath("//span[contains(@class,'stikerCard')]");
    private final By byCardBody = By.xpath("//div[contains(@class,'cardBodyGlobal')]");
    private final By byPrice = By.xpath("//div/p[sup[text()='đ']]");
    private final By byTeacherName = By.xpath("//div[contains(@class,'cardFooter')]");
    private final By byTitleMaker = By.xpath("//div[contains(@class,'titleMaker')]");
    private final By byCourseImage = By.xpath("//a[contains(@class,'cardGlobal')]/img");
    private final By byTeacherAvatar = By.xpath("//div[contains(@class,'titleMaker')]//img");
    private final By byClickCourseCard = By.xpath("//a[contains(@href,'/chitiet')]");
    private final By byCourseDetail = By.xpath("//div[contains(@class,'detailCouresContent')]");
    // =================== HOVER CARD =================
    private final By byHoverCard = By.xpath("//a[contains(@class,'cardGlobal')]");
    private final By bySubCardHeader = By.xpath("//div[contains(@class,'subCardHead')]");
    private final By byCourseTitle = By.xpath("//div[contains(@class,'subCard')]/h6");
    private final By byCourseDescription = By.xpath("//p[contains(@class,'colorCardTitle')]");
    private final By byCardIcon = By.xpath("//div[contains(@class,'cardIcon')]");// Thông tin thời gian, level...
    private final By byViewDetailBtn = By.xpath("//button[contains(@class,'btnSubCard')]");
    private final By byViewDetailLink = By.xpath("//a[contains(@href,'/chitiet')]");

    //  ================= SỐ LIỆU THỐNG KÊ =================
    private final By byBoxNumberContainer = By.xpath("//div[contains(@class,'boxNumberContainer')]");
    private final By byBoxNumber = By.xpath("//div[contains(@class,'boxNumber')]");
    private final By byStudentIcon = By.xpath("//img[contains(@src,'003-students')]");
    private final By byTimetableIcon = By.xpath("//img[contains(@src,'001-timetable')]");
    private final By byHourIcon = By.xpath("//img[contains(@src,'002-hourglass')]");
    private final By byTeacherIcon = By.xpath("//img[contains(@src,'004-teacher')]");
    private final By byNumber = By.xpath("//div[contains(@class,'textNumber')]/span");
    private final By byTitleSL = By.xpath("//p[contains(@class,'textNumberTitle')]");
    private final By byStudentNumber = By.xpath("//p[normalize-space()='Học viên']/preceding-sibling::div[@class='textNumber']/span");
    private final By byCourseNumber = By.xpath("//p[normalize-space()='Khóa học']/preceding-sibling::div[@class='textNumber']/span");
    private final By byHourNumber = By.xpath("//p[normalize-space()='Giờ học']/preceding-sibling::div[@class='textNumber']/span");
    private final By byTeacherNumber = By.xpath("//p[normalize-space()='Giảng viên']/preceding-sibling::div[@class='textNumber']/span");

    // ================= GIẢNG VIÊN HÀNG ĐẦU =================
    private final By byInstructorContainer = By.xpath("//div[contains(@class,'instrutorContainer')]");
    private final By byTopInstructorTitle = By.xpath("//a[normalize-space()='Giảng viên hàng đầu']");
    private final By byHoverInstructorCard = By.cssSelector("div.instrutorContent");// Parent: Mỗi card giảng viên khi hover
    private final By byInstructorCard = By.xpath("//div[contains(@class,'instrutorContent')]");// Parent: Mỗi card giảng viên
    private final By byInstructorName = By.xpath("//div[contains(@class,'instrutorContent')]/h6");// Tên "Giảng viên"
    private final By byInstructorImage = By.xpath("//div[contains(@class,'instrutorContent')]/img");// Ảnh giảng viên
    private final By byInstructorRole = By.xpath("//div[contains(@class,'textReviewRole')]");// Vai trò
    private final By byReviewStar = By.xpath("//p[contains(@class,'reviewMentor')]");// Đánh giá sao
    private final By byRating = By.xpath("//p[contains(@class,'reviewMentor')]//span[contains(@class,'textStar')]");// Điểm đánh giá
    private final By byReviewCount = By.xpath("//span[contains(@class,'textReviewBot')]");// Số lượng đánh giá
    private final By byPrevButton = By.xpath("//label[contains(@class,'labelDotLeft')]");// Nút chuyển trái
    private final By byNextButton = By.xpath("//label[contains(@class,'labelDotRight')]");// Nút chuyển phải

    //================== ĐÁNH GIÁ HỌC VIÊN =================
    private final By byReviewSection = By.xpath("//div[contains(@class,'review')]");
    private final By byReviewStudent = By.xpath("//div[contains(@class,'reviewStudent')]");
    private final By byStudentImage = By.xpath("//div[contains(@class,'reviewImg')]//img");
    private final By byQuote = By.xpath("//blockquote[contains(@class,'textQoute')]/q");
    private final By byStudentName = By.xpath("//div[contains(@class,'quoteRight')]/p");
    private final By byStudentTitle = By.xpath("//div[contains(@class,'quoteRight')]/span");


    public HomePage(WebDriver driver) {

        super(driver);}

    // ================= BANNER =================

    public boolean isBannerTextDisplayed() {
        return isBannerTextDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isBannerTextDisplayed(long timeoutInSec) {
        return isDisplayed(byBannerText, timeoutInSec);}

    public boolean isVlearningTextDisplayed() {
        return isVlearningTextDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isVlearningTextDisplayed(long timeoutInSec) {
        return isDisplayed(byVlearningText, timeoutInSec);}

    public boolean isStartButtonDisplayed() {
        return isStartButtonDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isStartButtonDisplayed(long timeoutInSec) {
        return isDisplayed(byStartBtn, timeoutInSec);}

    public void clickStartButton() {
        clickStartButton(TimeOutConstant.TIME_OUT_DEFAULT); }
    public void clickStartButton(long timeoutInSec) {
        clickBtn(byStartBtn, timeoutInSec); }

    public boolean isBannerImageDisplayed() {
        return isBannerImageDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isBannerImageDisplayed(long timeoutInSec) {
        return isDisplayed(byBannerImg, timeoutInSec);}

    public void resizeBrowser(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));}


    // ================= GIỚI THIỆU =================

    public boolean isIntroductionSectionDisplayed() {
        return isIntroductionSectionDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isIntroductionSectionDisplayed(long timeOutInSec) {
        return isDisplayed(byIntroductionSection, timeOutInSec);}

    public boolean isIntroductionBlockDisplayed(String blockName) {
        return isIntroductionBlockDisplayed(blockName, TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isIntroductionBlockDisplayed(String blockName, long timeOutInSec) {
        By locator = By.xpath("//div[contains(@class,'infoItemHome')]" + "[.//h3[normalize-space()='" + blockName + "']]");
        return isDisplayed(locator, timeOutInSec);}

    public void hoverIntroductionBlock(String blockName) {
        By locator = By.xpath("//div[contains(@class,'infoItemHome')]" + "[.//h3[normalize-space()='" + blockName + "']]");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();}

    public boolean isTitleDisplayed(String title) {
        return isTitleDisplayed(title, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public boolean isTitleDisplayed(String title, long timeoutInSec) {
        waitForElementVisible(byTitle, timeoutInSec);
        List<WebElement> titles = driver.findElements(byTitle);
        for (WebElement element : titles) {
            if (element.getText().trim().equalsIgnoreCase(title)) {
                return true;}
        }return false;}

    public boolean isDescriptionDisplayed() {
        return isDescriptionDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isDescriptionDisplayed(long timeOutInSec) {
        return isDisplayed(byDescription, timeOutInSec);}

    public boolean isListItemDisplayed() {
        return isListItemDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isListItemDisplayed(long timeOutInSec) {
        return isDisplayed(byListItem, timeOutInSec);}

    public boolean isFoItemDisplayed(String itemText) {
        return isFoItemDisplayed(itemText, TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isFoItemDisplayed(String itemText, long timeOutInSec) {
        return isDisplayed(byFoItem, timeOutInSec);}


    // ================= DANH SÁCH KHÓA HỌC ==================

    public boolean isPopularCourseDisplayed() {
        return isPopularCourseDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isPopularCourseDisplayed(long timeOutInSec) {
        return isDisplayed(byPopularCourse, timeOutInSec);}

    public boolean isCategoryTitleDisplayed() {
        return isCategoryTitleDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isCategoryTitleDisplayed(long timeOutInSec) {
        return isDisplayed(byCategoryTitle, timeOutInSec);}

    public boolean isFrontEndReactCourseDisplayed() {
        return isFrontEndReactCourseDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isFrontEndReactCourseDisplayed(long timeOutInSec) {
        return isDisplayed(byFrontEndReactCourse, timeOutInSec);}

    public boolean isCourseCardDisplayed() {
        return isCourseCardDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isCourseCardDisplayed(long timeOutInSec) {
        return isDisplayed(byCourseCard, timeOutInSec);}

    public boolean isCardSaleDisplayed() {
        return isCardSaleDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isCardSaleDisplayed(long timeOutInSec) {
        return isDisplayed(byCardSale, timeOutInSec);}

    public boolean isStickerDisplayed() {
        return isStickerDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isStickerDisplayed(long timeOutInSec) {
        return isDisplayed(bySticker, timeOutInSec);}

    public boolean isCardBodyDisplayed() {
        return isCardBodyDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isCardBodyDisplayed(long timeOutInSec) {
        return isDisplayed(byCardBody, timeOutInSec);}

    public boolean isTeacherNameDisplayed() {
        return isTeacherNameDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isTeacherNameDisplayed(long timeOutInSec) {
        return isDisplayed(byTeacherName, timeOutInSec);}

    public boolean isTitleMakerDisplayed() {
        return isTitleMakerDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isTitleMakerDisplayed(long timeOutInSec) {
        return isDisplayed(byTitleMaker, timeOutInSec);}

    public boolean isCourseImageDisplayed() {
        return isCourseImageDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isCourseImageDisplayed(long timeOutInSec) {
        return isDisplayed(byCourseImage, timeOutInSec);}

    public boolean isTeacherAvatarDisplayed() {
        return isTeacherAvatarDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isTeacherAvatarDisplayed(long timeOutInSec) {
        return isDisplayed(byTeacherAvatar, timeOutInSec);}

    public void clickCourseCard() {
        clickCourseCard(TimeOutConstant.TIME_OUT_DEFAULT);}
    public void clickCourseCard(long timeOutInSec) {
        clickBtn(byClickCourseCard, timeOutInSec);}

    public boolean isCourseDetailDisplayed() {
        return isCourseDetailDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isCourseDetailDisplayed(long timeOutInSec) {
        return isDisplayed(byCourseDetail, timeOutInSec);}

    public boolean isPricesDisplayed() {

        waitForElementVisible(byPrice, TimeOutConstant.TIME_OUT_DEFAULT);
        List<WebElement> prices = driver.findElements(byPrice);
        for (WebElement price : prices) {
            if (!price.isDisplayed()) {
                return false;}
        }return true;
    }

    // =================== HOVER CARD =================

    public boolean isHoverCardDisplayed() {
        return isHoverCardDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isHoverCardDisplayed(long timeOutInSec) {
        return isDisplayed(byHoverCard, timeOutInSec);}

    public boolean isSubCardHeaderDisplayed() {
        return isSubCardHeaderDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isSubCardHeaderDisplayed(long timeOutInSec) {
        return isDisplayed(bySubCardHeader, timeOutInSec);}

    public boolean isCourseTitleDisplayed() {
        return isCourseTitleDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isCourseTitleDisplayed(long timeOutInSec) {
        return isDisplayed(byCourseTitle, timeOutInSec);}

    public boolean isCourseDescriptionDisplayed() {
        return isCourseDescriptionDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isCourseDescriptionDisplayed(long timeOutInSec) {
        return isDisplayed(byCourseDescription, timeOutInSec);}

    public boolean isCardIconDisplayed() {
        return isCardIconDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isCardIconDisplayed(long timeOutInSec) {
        return isDisplayed(byCardIcon, timeOutInSec);}

    public boolean isViewDetailButtonDisplayed() {
        return isViewDetailButtonDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isViewDetailButtonDisplayed(long timeOutInSec) {
        return isDisplayed(byViewDetailBtn, timeOutInSec);}

    public boolean isViewDetailLinkDisplayed() {
        return isViewDetailLinkDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isViewDetailLinkDisplayed(long timeOutInSec) {
        return isDisplayed(byViewDetailLink, timeOutInSec);}

    public void hoverCourseCard() {
        Actions actions = new Actions(driver);}


    // ================= SỐ LIỆU THỐNG KÊ =================

    public boolean isBoxNumberContainerDisplayed() {
        return isBoxNumberContainerDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isBoxNumberContainerDisplayed(long timeoutInSec) {
        return isDisplayed(byBoxNumberContainer, timeoutInSec);}

    public boolean isBoxNumberDisplayed() {
        return isBoxNumberDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isBoxNumberDisplayed(long timeoutInSec) {
        return isDisplayed(byBoxNumber, timeoutInSec);}

    public boolean isStudentIconDisplayed() {
        return isStudentIconDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isStudentIconDisplayed(long timeOutInSec) {
        return isDisplayed(byStudentIcon, timeOutInSec);}

    public boolean isTimetableIconDisplayed() {
        return isTimetableIconDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isTimetableIconDisplayed(long timeOutInSec) {
        return isDisplayed(byTimetableIcon, timeOutInSec);}

    public boolean isHourIconDisplayed() {
        return isHourIconDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isHourIconDisplayed(long timeOutInSec) {
        return isDisplayed(byHourIcon, timeOutInSec);}

    public boolean isTeacherIconDisplayed() {
        return isTeacherIconDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isTeacherIconDisplayed(long timeOutInSec) {
        return isDisplayed(byTeacherIcon, timeOutInSec);}

    public boolean isNumberDisplayed() {
        return isNumberDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isNumberDisplayed(long timeoutInSec) {
        return isDisplayed(byNumber, timeoutInSec);}

    public boolean isTitleSLDisplayed(String title) {
        return isTitleSLDisplayed(title, TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isTitleSLDisplayed(String title, long timeOutInSec) {
        By locator = By.xpath("//p[contains(@class,'textNumberTitle')][normalize-space()='" + title + "']");
        return isDisplayed(locator, timeOutInSec);}

    public boolean isStudentNumberDisplayed() {
        return isStudentNumberDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isStudentNumberDisplayed(long timeOutInSec) {
        return isDisplayed(byStudentNumber, timeOutInSec);}

    public boolean isCourseNumberDisplayed() {
        return isCourseNumberDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isCourseNumberDisplayed(long timeOutInSec) {
        return isDisplayed(byCourseNumber, timeOutInSec);}

    public boolean isHourNumberDisplayed() {
        return isHourNumberDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isHourNumberDisplayed(long timeOutInSec) {
        return isDisplayed(byHourNumber, timeOutInSec);}

    public boolean isTeacherNumberDisplayed() {
        return isTeacherNumberDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isTeacherNumberDisplayed(long timeOutInSec) {
        return isDisplayed(byTeacherNumber, timeOutInSec);}

// ================= GIẢNG VIÊN HÀNG ĐẦU =================

    public boolean isInstructorContainerDisplayed() {
        return isInstructorContainerDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isInstructorContainerDisplayed(long timeoutInSec) {
        return isDisplayed(byInstructorContainer, timeoutInSec);}

    public boolean isTopInstructorTitleDisplayed() {
        return isTopInstructorTitleDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isTopInstructorTitleDisplayed(long timeOutInSec) {
        return isDisplayed(byTopInstructorTitle, timeOutInSec);}

    public void hoverInstructorCard() {
        WebElement element = driver.findElement(byHoverInstructorCard);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


    public boolean isInstructorNameDisplayed(String instructorName) {
        return isInstructorNameDisplayed(instructorName, TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isInstructorNameDisplayed(String instructorName, long timeOutInSec) {
        By locator = By.xpath("//div[contains(@class,'instrutorContent')]//h6[normalize-space()='" + instructorName + "']");
        return isDisplayed(locator, timeOutInSec);}

    public boolean isInstructorImageDisplayed(String instructorName) {
        return isInstructorImageDisplayed(instructorName, TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isInstructorImageDisplayed(String instructorName, long timeOutInSec) {
        By locator = By.xpath("//div[contains(@class,'instrutorContent')]" + "[.//h6[normalize-space()='" + instructorName + "']]//img");
        return isDisplayed(locator, timeOutInSec);}

    public String getExpectedInstructorRole(String instructorName) {
        // Tìm đến đúng element chứa vai trò của giảng viên dựa theo tên
        By locator = By.xpath("//div[contains(@class,'instrutorContent')][.//h6[normalize-space()='" + instructorName + "']]//div[contains(@class,'textReviewRole')]");

        // Đợi element hiển thị, lấy text và cắt bỏ khoảng trắng thừa
        waitForElementVisible(locator, constants.TimeOutConstant.TIME_OUT_DEFAULT);
        return driver.findElement(locator).getText().trim();
    }


    public boolean isReviewStarDisplayed(String instructorName) {
        return isReviewStarDisplayed(instructorName, TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isReviewStarDisplayed(String instructorName, long timeOutInSec) {
        By locator = By.xpath("//div[contains(@class,'instrutorContent')]" + "[.//h6[normalize-space()='" + instructorName + "']]" + "//p[contains(@class,'reviewMentor')]//i");
        return isDisplayed(locator, timeOutInSec);}

    public boolean isRatingDisplayed(String instructorName) {
        return isRatingDisplayed(instructorName, TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isRatingDisplayed(String instructorName, long timeOutInSec) {
        By locator = By.xpath("//div[contains(@class,'instrutorContent')]" + "[.//h6[normalize-space()='" + instructorName + "']]" + "//p[contains(@class,'reviewMentor')]");
        return isDisplayed(locator, timeOutInSec);}

    public boolean isReviewCountDisplayed() {
        return isReviewCountDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public boolean isReviewCountDisplayed(long timeOutInSec) {
        return isDisplayed(byReviewCount, timeOutInSec);
    }


    public boolean isPrevButtonDisplayed() {
        return isPrevButtonDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isPrevButtonDisplayed(long timeoutInSec) {
        return isDisplayed(byPrevButton, timeoutInSec);}

    public boolean isNextButtonDisplayed() {
        return isNextButtonDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isNextButtonDisplayed(long timeoutInSec) {
        return isDisplayed(byNextButton, timeoutInSec);}

    public boolean isInstructorDetailDisplayed() {
        return isInstructorDetailDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isInstructorDetailDisplayed(long timeoutInSec) {
        return isDisplayed(byInstructorCard, timeoutInSec);}

    public void clickInstructorCardDisplayed() {
        clickInstructorCardDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public void clickInstructorCardDisplayed(long timeoutInSec) {
        clickBtn(byInstructorCard, timeoutInSec);}

    public boolean isInstructorhoverDisplayed() {
        return isInstructorhoverDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);}
    public boolean isInstructorhoverDisplayed(long timeOutInSec) {
        return isDisplayed(byHoverInstructorCard, timeOutInSec);}

// ================= ĐÁNH GIÁ HỌC VIÊN =================

    public boolean isReviewSectionDisplayed() {
        return isReviewSectionDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public boolean isReviewSectionDisplayed(long timeoutInSec) {return isDisplayed(byReviewSection, timeoutInSec); }

    public boolean isReviewStudentDisplayed() {
        return isReviewStudentDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public boolean isReviewStudentDisplayed(long timeoutInSec) {return isDisplayed(byReviewStudent, timeoutInSec);}

    public boolean isStudentImageDisplayed() {
        return isStudentImageDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public boolean isStudentImageDisplayed(long timeoutInSec) {return isDisplayed(byStudentImage, timeoutInSec);}

    public boolean isQuoteDisplayed() {
        return isQuoteDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public boolean isQuoteDisplayed(long timeoutInSec) {
        return isDisplayed(byQuote, timeoutInSec);
    }

    public boolean isStudentNameDisplayed() {
        return isStudentNameDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public boolean isStudentNameDisplayed(long timeoutInSec) {
        return isDisplayed(byStudentName, timeoutInSec);
    }

    public boolean isStudentTitleDisplayed() {
        return isStudentTitleDisplayed(TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public boolean isStudentTitleDisplayed(long timeoutInSec) {return isDisplayed(byStudentTitle, timeoutInSec);
    }
}

