package components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class FooterComponent extends BasePage {
    // TODO: Replace placeholders with stable locators from the real DOM.
    private final By byFooter = By.xpath("//footer");
    private final By byFooterLogo = By.xpath("//footer//*[contains(@class,'logo') or contains(@alt,'logo')]");
    private final By byContactInfo = By.xpath("//footer//*[contains(normalize-space(),'Liên hệ') or contains(normalize-space(),'Contact')]");
    private final By byCopyright = By.xpath("//footer//*[contains(normalize-space(),'Copyright') or contains(normalize-space(),'Bản quyền')]");

    public FooterComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isFooterDisplayed() {
        return isDisplayed(byFooter);
    }

    public boolean isFooterLogoDisplayed() {
        return isDisplayed(byFooterLogo);
    }

    public boolean isContactInfoDisplayed() {
        return isDisplayed(byContactInfo);
    }

    public boolean isCopyrightDisplayed() {
        return isDisplayed(byCopyright);
    }

    public boolean isFooterFullyDisplayed() {
        return isFooterDisplayed() && isFooterLogoDisplayed() && isContactInfoDisplayed() && isCopyrightDisplayed();
    }
}
