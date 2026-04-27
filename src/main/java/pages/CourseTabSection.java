package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CourseTabSection extends CommonPage {

	// TODO: Replace placeholders with stable locators from the real DOM / devtools.
	private final By bySearchInput = By.xpath("//input[contains(@placeholder,'Tìm kiếm') or contains(@placeholder,'Search')]");
	private final By byCourseList = By.xpath("//*[contains(@class,'course') or contains(@class,'list')]");
	private final By byEmptyState = By.xpath("//*[contains(normalize-space(),'Không có') or contains(normalize-space(),'No course')]");
	private final By byCourseCard = By.xpath("//*[contains(@class,'course') and (contains(@class,'card') or contains(@class,'item'))]");
	private final By byCancelCourseButton = By.xpath("//*[normalize-space()='HỦY KHÓA HỌC' or normalize-space()='Hủy khóa học']");

	public CourseTabSection(WebDriver driver) {
		super(driver);
	}

	public boolean isCourseTabReady() {
		return isDisplayed(bySearchInput, TimeOutConstant.TIME_OUT_MEDIUM)
				&& (isDisplayed(byCourseList, TimeOutConstant.TIME_OUT_MEDIUM) || isDisplayed(byEmptyState, TimeOutConstant.TIME_OUT_MEDIUM));
	}

	public void searchCourse(String keyword) {
		clearAndType(bySearchInput, keyword);
	}

	public void pressEnterOnSearch() {
		waitForVisible(bySearchInput, TimeOutConstant.TIME_OUT_DEFAULT).sendKeys(org.openqa.selenium.Keys.ENTER);
	}

	public int getCourseCardCount() {
		return getElementCount(byCourseCard);
	}

	public boolean isCourseListDisplayed() {
		return isDisplayed(byCourseList, TimeOutConstant.TIME_OUT_MEDIUM) || isDisplayed(byEmptyState, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	public void cancelFirstCourse() {
		click(byCancelCourseButton);
	}

	public By getBySearchInput() {
		return bySearchInput;
	}
}
