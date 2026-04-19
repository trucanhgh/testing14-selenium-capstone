package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SamplePage extends CommonPage {
    private final By byPageTitle = By.tagName("h1");

    public SamplePage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getTextElement(byPageTitle);
    }
}

