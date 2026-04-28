package components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
public class FooterComponent extends BasePage {
    private final By byFooter = By.xpath("//*[@class=\"footerPages\"]");
    private final By byFooterLogo = By.xpath("//*[@class=\"mr-5 textLogo\"]");
    private final By byContactInfo = By.xpath("(//*[@class=\"menuFooter\"])[1]");
    private final By byCopyright = By.xpath("//*[@class=\"textCardTitle\"]");

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
