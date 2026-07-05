package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends CommonPage {

	// ================= LOCATORS =================
	private final By byProfileHeader = By.xpath("//div[@class='titleCourse']");
	private final By byProfileTabBar = By.xpath("//div[@class='tab']");
	private final By byPersonalInfoTab = By.xpath("//button[contains(@class, 'tabLink') and contains(normalize-space(), 'Thông tin cá nhân')]");
	private final By byCourseTab = By.xpath("//button[contains(@class, 'tabLink') and contains(normalize-space(), 'Khóa học')]");
	private final By byLeftBar = By.xpath("//div[@class='infoLeft']");
	private final By byPersonalInfoSection = By.xpath("//section[@class='userInfo']");
	private final By bySkillsSection = By.xpath("//div[@class='userInfoBot']");
	private final By byEditButton = By.xpath("//button[@data-toggle='modal']");
	private final By byProfileAvatar = By.xpath("//div[@class='infoLeft']//img");

	// Khai báo chính xác locator cho popup SweetAlert
	private final By successPopupTitle = By.xpath("//div[@class='swal-title' and text()='Cập nhật thành công']");
	private final By emailAlreadyExistPopupTitle = By.xpath("//div[@class='swal-title' and text()='Email đã tồn tại!']");

	// ================= LOCATORS TRONG PROFILEPAGE.JAVA =================

	// 1. Tên hiển thị
	private final By byDisplayName = By.xpath("//section[@class='userInfo']//p[contains(normalize-space(), 'Họ và tên')]//span");

	// 2. Email hiển thị
	private final By byDisplayEmail = By.xpath("//section[@class='userInfo']//p[contains(normalize-space(), 'Email')]//span");

	// 3. Số điện thoại hiển thị
	private final By byDisplayPhone = By.xpath("//section[@class='userInfo']//p[contains(normalize-space(), 'Số điện thoại')]//span");

	// ================= CONSTRUCTOR =================
	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	// ================= DATA GETTERS (LẤY THÔNG TIN) =================
	public String getDisplayedName() {
		return getText(byDisplayName);
	}

	public String getDisplayedEmail() {
		return getText(byDisplayEmail);
	}

	public String getDisplayedPhone() {
		return getText(byDisplayPhone);
	}

	// ================= ACTIONS (ĐIỀU HƯỚNG & THAO TÁC) =================
	public void openPersonalInfoTab() {
		click(byPersonalInfoTab);
	}

	public void openCourseTab() {
		click(byCourseTab);
	}

	public void clickProfileAvatar() {
		click(byProfileAvatar);
	}

	public EditProfileModal openEditProfileModal() {
		click(byEditButton);
		EditProfileModal modal = new EditProfileModal(driver);
		modal.waitForModal();
		return modal;
	}

	public CourseTabSection getCourseTabSection() {
		return new CourseTabSection(driver);
	}

	// ================= STATE & WAITS (KIỂM TRA TRẠNG THÁI) =================

	/**
	 * BỔ SUNG HÀM: Kiểm tra hiển thị Popup SweetAlert thành công
	 * Sử dụng hàm isDisplayed có truyền timeout để chờ popup render xong hiệu ứng ẩn/hiển thị
	 */
	public boolean isSuccessPopupDisplayed() {
		return isDisplayed(successPopupTitle, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public	boolean isEmailAlreadyExistPopupDisplayed() {
		return isDisplayed(emailAlreadyExistPopupTitle, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public void waitForPageLoaded() {
		waitForVisible(byProfileHeader, TimeOutConstant.TIME_OUT_MEDIUM);
		waitForVisible(byProfileTabBar, TimeOutConstant.TIME_OUT_MEDIUM);
		waitForPageReady(TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public boolean isProfilePageLoaded() {
		return isDisplayed(byProfileHeader, TimeOutConstant.TIME_OUT_MEDIUM)
				&& isDisplayed(byPersonalInfoSection, 0)
				&& isDisplayed(byEditButton, 0);
	}

	public boolean isProfileOverviewDisplayed() {
		return isDisplayed(byProfileHeader, TimeOutConstant.TIME_OUT_MEDIUM)
				&& isDisplayed(byProfileTabBar, TimeOutConstant.TIME_OUT_MEDIUM)
				&& isDisplayed(byLeftBar, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public boolean isSidebarDisplayed() {
		return isDisplayed(byLeftBar, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public boolean isPersonalInfoTabDisplayed() {
		return isDisplayed(byPersonalInfoTab, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public boolean isCourseTabDisplayed() {
		return isDisplayed(byCourseTab, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public boolean isPersonalInfoSectionDisplayed() {
		return isDisplayed(byPersonalInfoSection, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public boolean isSkillsSectionDisplayed() {
		return isDisplayed(bySkillsSection, TimeOutConstant.TIME_OUT_MEDIUM);
	}
}