package pages;

import base.BasePage;
import components.NavbarComponent;
// import components.FooterComponent; // Mở comment nếu bạn có dùng
import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage {
    private final NavbarComponent navbarComponent;
    // private final FooterComponent footerComponent;

    // Locator cho thông báo thành công (SweetAlert)
    private final By bySuccessPopupTitle = By.xpath("//div[@class='swal-title' and text()='Cập nhật thành công']");

    public CommonPage(WebDriver driver) {
        super(driver);
        this.navbarComponent = new NavbarComponent(driver);
        // this.footerComponent = new FooterComponent(driver);
    }

    public NavbarComponent getNavbarComponent() {
        return navbarComponent;
    }

    // Method kiểm tra UI Popup thành công xuất hiện
    public boolean isSuccessPopupDisplayed() {
        return isDisplayed(bySuccessPopupTitle, TimeOutConstant.TIME_OUT_MEDIUM);
    }
}