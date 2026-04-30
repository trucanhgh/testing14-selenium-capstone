package components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class NavbarComponent extends BasePage {
    private final By byLogo = By.xpath("//*[@class=\"textLogo active\"]");
    private final By bySearchInput = By.xpath("//*[@class=\"searchForm\"]");
    private final By byCategoryMenu = By.xpath("//*[@class=\"courseCate\"]");
    private final By byCoursesMenu = By.xpath("(//li//a[@href=\"/khoahoc\" and text()=\"Khóa học\"]) [1]");
    private final By byBlogMenu = By.xpath("(//li//a[@href=\"/blog\" and text()=\"Blog\"]) [1]");
    private final By byEventMenu = By.xpath("(//li//a[@href=\"/sukien\" and text()=\"Sự kiện\"]) [1]");
    private final By byInfoMenu = By.xpath("(//li//a[@href=\"/thongtin\" and text()=\"Thông tin\"]) [1]");
    private final By byAvatar = By.xpath("//img[@class=\"avatar\"]");
    private final By byProfileLink = By.xpath("//a[@href=\"/thongtincanhan\"]");
    private final By byLoginLink = By.xpath("//button[@class='btnGlobal']");

    public void clickLoginLink() {
        click(byLoginLink);
    }
    private final By byLogoutLink = By.xpath("//span[@class=\"logout\"]");

    public NavbarComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isNavbarDisplayed() {
        return isDisplayed(byLogo) || isDisplayed(byAvatar);
    }

    public boolean isLogoDisplayed() {
        return isDisplayed(byLogo);
    }

    public boolean isSearchDisplayed() {
        return isDisplayed(bySearchInput);
    }

    public boolean isCategoryMenuDisplayed() {
        return isDisplayed(byCategoryMenu);
    }

    public boolean isCoursesMenuDisplayed() {
        return isDisplayed(byCoursesMenu);
    }

    public boolean isBlogMenuDisplayed() {
        return isDisplayed(byBlogMenu);
    }

    public boolean isEventMenuDisplayed() {
        return isDisplayed(byEventMenu);
    }

    public boolean isInfoMenuDisplayed() {
        return isDisplayed(byInfoMenu);
    }

    public boolean isAvatarDisplayed() {
        return isDisplayed(byAvatar);
    }

    public void clickAvatar() {
        click(byAvatar);
    }

    public void openProfileLink() {
        click(byProfileLink);
    }

    public void logout() {
        click(byLogoutLink);
    }

    public void search(String keyword) {
        clearAndType(bySearchInput, keyword);
    }

    public void openCoursesMenu() {
        click(byCoursesMenu);
    }

    public void openBlogMenu() {
        click(byBlogMenu);
    }

    public void openEventMenu() {
        click(byEventMenu);
    }

    public By getByAvatar() {
        return byAvatar;
    }
}
