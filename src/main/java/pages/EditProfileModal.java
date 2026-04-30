package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfileModal extends CommonPage {

	private final By byModalTitle = By.xpath("//h5[@class='modal-title']");
	private final By byFullNameInput = By.xpath("//input[@name='hoTen']");
	private final By byPasswordInput = By.xpath("//input[@name='matKhau']");
	private final By byEmailInput = By.xpath("//input[@name='email']");
	private final By byPhoneInput = By.xpath("//input[@name='soDT']");
	private final By bySubmitButton = By.xpath("//button[@class='btnSubmit']");
	private final By byCloseButton = By.xpath("//button[@class='btnSubmit btnClose']");
	private final By byDismissIcon = By.xpath("//button[@class='close']");

	// Locator động cho Error Message
	private final String dynamicErrorXpath = "//div[@class='errorMessage'][preceding-sibling::input[1][@name='%s']]";

	public EditProfileModal(WebDriver driver) {
		super(driver);
	}

	// --- Action Methods ---

	public void fillForm(String fullName, String password, String email, String phone) {
		clearAndType(byFullNameInput, fullName);
		clearAndType(byPasswordInput, password);
		clearAndType(byEmailInput, email);
		clearAndType(byPhoneInput, phone);
	}

	public void submit() { click(bySubmitButton); }
	public void closeWithButton() { click(byCloseButton); }
	public void closeWithIcon() { click(byDismissIcon); }

	// --- Validation Methods (Gom nhóm) ---

	// Kiểm tra hiển thị lỗi theo tên field (hoTen, matKhau, email, soDT)
	public boolean isFieldErrorDisplayed(String fieldName) {
		By errorLocator = By.xpath(String.format(dynamicErrorXpath, fieldName));
		return isDisplayed(errorLocator, TimeOutConstant.TIME_OUT_DEFAULT);
	}

	// Lấy nội dung lỗi theo tên field
	public String getFieldErrorMessage(String fieldName) {
		By errorLocator = By.xpath(String.format(dynamicErrorXpath, fieldName));
		return getText(errorLocator);
	}

	// --- State Methods ---

	// Đợi modal hiển thị đầy đủ (Dùng khi gọi từ ProfilePage)
	public void waitForModal() {
		waitForVisible(byModalTitle, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public boolean isModalDisplayed() {
		return isDisplayed(byModalTitle, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public boolean isFieldsDisplayed() {
		return isDisplayed(byFullNameInput, 0) && isDisplayed(byPasswordInput, 0)
				&& isDisplayed(byEmailInput, 0) && isDisplayed(byPhoneInput, 0);
	}
}