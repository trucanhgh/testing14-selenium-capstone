package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends CommonPage {

	// ================= LOCATORS =================
	private final By byProfileHeader = By.xpath("//div[@class='titleCourse']");
	private final By byProfileTabBar = By.xpath("//div[@class='tab']");
	private final By byPersonalInfoTab = By.xpath("//button[@class='tabLink active']");
	private final By byCourseTab = By.xpath("//button[@class='tabLink']");
	private final By byLeftBar = By.xpath("//div[@class='infoLeft']");
	private final By byPersonalInfoSection = By.xpath("//section[@class='userInfo']");
	private final By bySkillsSection = By.xpath("//div[@class='userInfoBot']");
	private final By byEditButton = By.xpath("//button[@data-toggle='modal']");
	private final By byProfileAvatar = By.xpath("//div[@class='infoLeft']//img");

	// Locator dùng để lấy Data đối chiếu (Lưu ý: Bạn hãy check lại XPath này với DOM thực tế của dự án nhé)
	private final By byDisplayName = By.xpath("//section[@class='userInfo']//h3");
	private final By byDisplayEmail = By.xpath("//p[contains(text(),'Email')]/span");
	private final By byDisplayPhone = By.xpath("//p[contains(text(),'Số điện thoại')]/span");

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

	/**
	 * Mở Edit Modal và khởi tạo luôn đối tượng Modal tiếp theo.
	 * Áp dụng Fluent Page Object (Ví dụ: profilePage.openEditProfileModal().fillForm(...))
	 */
	public EditProfileModal openEditProfileModal() {
		click(byEditButton);
		EditProfileModal modal = new EditProfileModal(driver);
		modal.waitForModal(); // Chờ modal load xong rồi mới trả về
		return modal;
	}

	public CourseTabSection getCourseTabSection() {
		return new CourseTabSection(driver);
	}

	// ================= STATE & WAITS (KIỂM TRA TRẠNG THÁI) =================
	public void waitForPageLoaded() {
		waitForVisible(byProfileHeader, TimeOutConstant.TIME_OUT_MEDIUM);
		waitForVisible(byProfileTabBar, TimeOutConstant.TIME_OUT_MEDIUM);
		waitForPageReady(TimeOutConstant.TIME_OUT_MEDIUM);
	}

	/**
	 * Hàm check tổng thể trang Profile đã load xong các phần quan trọng
	 */
	public boolean isProfilePageLoaded() {
		return isDisplayed(byProfileHeader, TimeOutConstant.TIME_OUT_MEDIUM)
				&& isDisplayed(byPersonalInfoSection, 0)
				&& isDisplayed(byEditButton, 0);
	}

	// --- Các hàm kiểm tra lẻ (Giữ lại để bạn dùng cho các assert chi tiết) ---
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