package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfileModal extends CommonPage {

	// TODO: Replace placeholders with stable locators from the real DOM / devtools.
	private final By byModalTitle = By.xpath("//*[contains(normalize-space(),'Chỉnh sửa thông tin cá nhân')]");
	private final By byFullNameInput = By.xpath("//input[@name='hoTen' or @id='hoTen' or contains(@placeholder,'Họ và tên')]");
	private final By byPasswordInput = By.xpath("//input[@name='matKhau' or @type='password']");
	private final By byEmailInput = By.xpath("//input[@name='email' or contains(@placeholder,'Email')]");
	private final By byPhoneInput = By.xpath("//input[@name='soDT' or contains(@placeholder,'Số điện thoại')]");
	private final By bySubmitButton = By.xpath("//*[normalize-space()='Hoàn thành']");
	private final By byCloseButton = By.xpath("//*[normalize-space()='Đóng']");
	private final By byDismissIcon = By.xpath("//*[@aria-label='Close' or normalize-space()='×' or normalize-space()='X']");

	public EditProfileModal(WebDriver driver) {
		super(driver);
	}

	public boolean isModalDisplayed() {
		return isDisplayed(byModalTitle, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public void waitForModal() {
		waitForVisible(byModalTitle, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public void fillFullName(String fullName) {
		clearAndType(byFullNameInput, fullName);
	}

	public void fillPassword(String password) {
		clearAndType(byPasswordInput, password);
	}

	public void fillEmail(String email) {
		clearAndType(byEmailInput, email);
	}

	public void fillPhone(String phone) {
		clearAndType(byPhoneInput, phone);
	}

	public void fillForm(String fullName, String password, String email, String phone) {
		fillFullName(fullName);
		fillPassword(password);
		fillEmail(email);
		fillPhone(phone);
	}

	public void submit() {
		click(bySubmitButton);
	}

	public void closeWithButton() {
		click(byCloseButton);
	}

	public void closeWithIcon() {
		click(byDismissIcon);
	}

	public boolean isSubmitButtonDisplayed() {
		return isDisplayed(bySubmitButton, TimeOutConstant.TIME_OUT_DEFAULT);
	}

	public boolean isCloseButtonDisplayed() {
		return isDisplayed(byCloseButton, TimeOutConstant.TIME_OUT_DEFAULT);
	}

	public boolean isFieldsDisplayed() {
		return isDisplayed(byFullNameInput, TimeOutConstant.TIME_OUT_DEFAULT)
				&& isDisplayed(byPasswordInput, TimeOutConstant.TIME_OUT_DEFAULT)
				&& isDisplayed(byEmailInput, TimeOutConstant.TIME_OUT_DEFAULT)
				&& isDisplayed(byPhoneInput, TimeOutConstant.TIME_OUT_DEFAULT);
	}

	public By getByFullNameInput() {
		return byFullNameInput;
	}
}
