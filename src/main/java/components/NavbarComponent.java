package components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class NavbarComponent extends BasePage {
    // TODO: Replace placeholders with stable locators from the real DOM.
    private final By byLogo = By.xpath("//nav//*[contains(@class,'logo') or contains(@alt,'logo')]");
    private final By bySearchInput = By.xpath("//nav//input[@type='search' or contains(@placeholder,'Search') or contains(@placeholder,'Tìm kiếm')]");
    private final By byCategoryMenu = By.xpath("//nav//*[normalize-space()='Danh mục' or normalize-space()='Category']");
    private final By byCoursesMenu = By.xpath("//nav//*[normalize-space()='Khóa học' or normalize-space()='Courses']");
    private final By byBlogMenu = By.xpath("//nav//*[normalize-space()='Blog']");
    private final By byEventMenu = By.xpath("//nav//*[normalize-space()='Sự kiện' or normalize-space()='Events']");
    private final By byInfoMenu = By.xpath("//nav//*[normalize-space()='Thông tin' or normalize-space()='Info']");
    private final By byAvatar = By.xpath("//nav//*[@role='button' or contains(@class,'avatar') or contains(@alt,'avatar')]");
    private final By byProfileLink = By.xpath("//*[normalize-space()='Thông tin cá nhân' or normalize-space()='Profile']");
    private final By byLogoutLink = By.xpath("//*[normalize-space()='Đăng xuất' or normalize-space()='Logout']");

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
