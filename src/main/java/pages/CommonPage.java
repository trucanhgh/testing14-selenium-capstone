package pages;

import base.BasePage;
import components.FooterComponent;
import components.NavbarComponent;
import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage {
    private final NavbarComponent navbarComponent;
    private final FooterComponent footerComponent;

    public CommonPage(WebDriver driver) {
        super(driver);
        this.navbarComponent = new NavbarComponent(driver);
        this.footerComponent = new FooterComponent(driver);
    }

    public NavbarComponent getNavbarComponent() {
        return navbarComponent;
    }

    public FooterComponent getFooterComponent() {
        return footerComponent;
    }
}
