package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPage {
    private final By byUsername = By.xpath("//form[@class='formLoginUser']//input[@name='taiKhoan']");
    private final By byPassword = By.xpath("//form[@class='formLoginUser']//input[@name='matKhau']");
    private final By byLoginBtn = By.xpath("//button[text()=\"Đăng nhập\" and @type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername(String username) {
        type(byUsername, username);
    }

    public void inputUsername(String username, long timeoutInSeconds) {
        type(byUsername, username, timeoutInSeconds);
    }

    public void inputPassword(String password) {
        type(byPassword, password);
    }

    public void inputPassword(String password, long timeoutInSeconds) {
        type(byPassword, password, timeoutInSeconds);
    }

    public void clickLoginBtn() {
        click(byLoginBtn);
    }

    public void clickLoginBtn(long timeoutInSeconds) {
        click(byLoginBtn, timeoutInSeconds);
    }
}
