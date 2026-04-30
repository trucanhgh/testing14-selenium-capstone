package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CourseTabSection extends CommonPage {

	// Locator constants
	private final By bySearchInput = By.xpath("//div[@class='findCourseNet']//input[@class='searchForm']");
	private final By byCourseList = By.xpath("//section[@class='myCourseInfo']");
	private final By byEmptyState = By.xpath("//*[contains(normalize-space(),'Không có') or contains(normalize-space(),'No course')]");
	private final By byCourseCard = By.xpath("//div[@class='myCourseItem']");

	public CourseTabSection(WebDriver driver) {
		super(driver);
	}

	// Waits for course tab to be ready (search input and course list or empty state)
	public boolean isCourseTabReady() {
		return isDisplayed(bySearchInput, TimeOutConstant.TIME_OUT_MEDIUM)
				&& (isDisplayed(byCourseList, TimeOutConstant.TIME_OUT_MEDIUM) || isDisplayed(byEmptyState, TimeOutConstant.TIME_OUT_MEDIUM));
	}

	// Searches for a course with the given keyword
	public void searchCourse(String keyword) {
		clearAndType(bySearchInput, keyword);
	}

	// Presses ENTER key on search input to execute search
	public void pressEnterOnSearch() {
		pressEnter(bySearchInput);
	}

	// Returns the total count of course cards displayed
	public int getCourseCardCount() {
		return getElementCount(byCourseCard);
	}

	// Checks if course list is displayed or empty state is shown
	public boolean isCourseListDisplayed() {
		return isDisplayed(byCourseList, TimeOutConstant.TIME_OUT_MEDIUM) || isDisplayed(byEmptyState, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	// Checks if empty state message is displayed (no courses)
	public boolean isEmptyStateDisplayed() {
		return isDisplayed(byEmptyState, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	// Cancels a course by its index (1-based: first course = 1)
	public void cancelCourseByIndex(int courseIndex) {
		if (courseIndex < 1) {
			throw new IllegalArgumentException("Course index must be >= 1");
		}
		By cancelButton = getCancelButtonLocatorByIndex(courseIndex);
		click(cancelButton);
		LOG.info("Cancelled course at index: {}", courseIndex);
	}

	// Cancels the first course in the list
	public void cancelFirstCourse() {
		cancelCourseByIndex(1);
	}

	// Cancels a course by its exact name/title
	public void cancelCourseByName(String courseName) {
		if (courseName == null || courseName.trim().isEmpty()) {
			throw new IllegalArgumentException("Course name cannot be empty");
		}
		By cancelButton = getCancelButtonLocatorByName(courseName);
		click(cancelButton);
		LOG.info("Cancelled course: {}", courseName);
	}

	// Gets the title/name of a course by its index (1-based)
	public String getCourseTitleByIndex(int courseIndex) {
		if (courseIndex < 1) {
			throw new IllegalArgumentException("Course index must be >= 1");
		}
		By courseTitle = By.xpath(String.format("(//div[@class='myCourseItem'])[%d]//div[@class='courseTitle']", courseIndex));
		return getText(courseTitle);
	}

	// Gets all course titles/names displayed in the list
	public java.util.List<String> getAllCourseTitles() {
		int courseCount = getCourseCardCount();
		java.util.List<String> titles = new java.util.ArrayList<>();
		for (int i = 1; i <= courseCount; i++) {
			titles.add(getCourseTitleByIndex(i));
		}
		return titles;
	}

	// Checks if a course with the given name exists in the list
	public boolean isCourseExists(String courseName) {
		if (isEmptyStateDisplayed()) {
			return false;
		}
		return getAllCourseTitles().stream()
				.anyMatch(title -> title.equalsIgnoreCase(courseName.trim()));
	}

	// Dynamic locator for cancel button by course index (1-based)
	private By getCancelButtonLocatorByIndex(int courseIndex) {
		return By.xpath(String.format("(//div[@class='myCourseItem'])[%d]//button[text()='Hủy khóa học']", courseIndex));
	}

	// Dynamic locator for cancel button by course name
	private By getCancelButtonLocatorByName(String courseName) {
		return By.xpath(String.format(
				"//div[@class='myCourseItem'][.//div[@class='courseTitle' and contains(text(), '%s')]]//button[text()='Hủy khóa học']",
				courseName));
	}

	// Gets a course card element by its index (1-based)
	public WebElement getCourseLargeCardByIndex(int courseIndex) {
		if (courseIndex < 1) {
			throw new IllegalArgumentException("Course index must be >= 1");
		}
		By courseCardLocator = By.xpath(String.format("(//div[@class='myCourseItem'])[%d]", courseIndex));
		return waitForVisible(courseCardLocator, TimeOutConstant.TIME_OUT_MEDIUM);
	}

	// Returns the original search input locator for direct interaction
	public By getBySearchInput() {
		return bySearchInput;
	}
}
