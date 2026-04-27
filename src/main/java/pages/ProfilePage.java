package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends CommonPage {

	// TODO: Replace placeholders with stable locators from the real DOM / devtools.
	private final By byProfileHeader = By.xpath("//*[contains(normalize-space(),'THÔNG TIN CÁ NHÂN') or contains(normalize-space(),'Thông tin cá nhân')]");
	private final By byStudentHeader = By.xpath("//*[contains(normalize-space(),'THÔNG TIN HỌC VIÊN') or contains(normalize-space(),'Thông tin học viên')]");
	private final By byPersonalInfoTab = By.xpath("//*[normalize-space()='Thông tin cá nhân']");
	private final By byCourseTab = By.xpath("//*[normalize-space()='Khóa học']");
	private final By bySidebar = By.xpath("//*[contains(@class,'sidebar') or contains(@class,'profile') or contains(@class,'left')]");
	private final By byPersonalInfoSection = By.xpath("//*[contains(normalize-space(),'Thông tin cá nhân') and (contains(@class,'card') or contains(@class,'section') or contains(@class,'info'))]");
	private final By bySkillsSection = By.xpath("//*[contains(normalize-space(),'KỸ NĂNG CỦA TÔI') or contains(normalize-space(),'Kỹ năng của tôi')]");
	private final By byEditButton = By.xpath("//*[normalize-space()='CẬP NHẬT' or normalize-space()='Cập nhật']");
	private final By byProfileAvatar = By.xpath("//*[contains(@class,'avatar') or contains(@alt,'avatar')]");

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public void waitForPageLoaded() {
		waitForVisible(byProfileHeader, TimeOutConstant.TIME_OUT_MEDIUM);
		waitForVisible(byStudentHeader, TimeOutConstant.TIME_OUT_MEDIUM);
		waitForPageReady(TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public boolean isProfileOverviewDisplayed() {
		return isDisplayed(byProfileHeader, TimeOutConstant.TIME_OUT_MEDIUM)
				&& isDisplayed(byStudentHeader, TimeOutConstant.TIME_OUT_MEDIUM)
				&& isDisplayed(bySidebar, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public boolean isSidebarDisplayed() {
		return isDisplayed(bySidebar, TimeOutConstant.TIME_OUT_MEDIUM);
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

	public void openPersonalInfoTab() {
		click(byPersonalInfoTab);
	}

	public void openCourseTab() {
		click(byCourseTab);
	}

	public void openEditProfileModal() {
		click(byEditButton);
	}

	public void clickProfileAvatar() {
		click(byProfileAvatar);
	}

	public EditProfileModal getEditProfileModal() {
		return new EditProfileModal(driver);
	}

	public CourseTabSection getCourseTabSection() {
		return new CourseTabSection(driver);
	}

	public By getByProfileHeader() {
		return byProfileHeader;
	}

	public By getByStudentHeader() {
		return byStudentHeader;
	}
}
