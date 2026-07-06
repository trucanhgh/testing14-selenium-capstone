package pages;

import constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CourseTabSection extends CommonPage {

	private final By bySearchInput = By.xpath("//div[@class='findCourseNet']//input[@class='searchForm']");
	private final By byCourseList = By.xpath("//section[@class='myCourseInfo']");
	private final By byEmptyState = By.xpath("//*[contains(normalize-space(),'Không có') or contains(normalize-space(),'No course')]");
	private final By byCourseCard = By.xpath("//div[@class='myCourseItem']");
	private final By byFirstCourseName = By.xpath("//div[@class='myCourseItem']//h6[1]");

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
		waitForVisible(bySearchInput).sendKeys(Keys.ENTER);
	}

	public int getCourseCount() {
		if (isDisplayed(byEmptyState, 2)) {
			return 0;
		}
		return driver.findElements(byCourseCard).size();
	}

	public List<String> getAllCourseTitles() {
		List<String> titles = new ArrayList<>();
		int count = getCourseCount();
		for (int i = 1; i <= count; i++) {
			titles.add(getCourseTitleByIndex(i));
		}
		return titles;
	}

	public boolean isCourseExists(String courseName) {
		return getAllCourseTitles().stream()
				.anyMatch(title -> title.trim().equalsIgnoreCase(courseName.trim()));
	}

	public String getCourseTitleByIndex(int courseIndex) {
		By titleLocator = By.xpath(String.format("(//div[@class='myCourseItem']//h6)[%d]", courseIndex));
		return getText(titleLocator);
	}

	public WebElement getCourseLargeCardByIndex(int courseIndex) {
		By courseCardLocator = By.xpath(String.format("(//div[@class='myCourseItem'])[%d]", courseIndex));
		return waitForVisible(courseCardLocator);
	}

	public void cancelCourseByName(String courseName) {
		String xpathCancelBtn = String.format(
				"//div[contains(@class, 'myCourseItem') and .//h6[contains(normalize-space(), '%s')]]//button[contains(@class, 'btnGlobal')]",
				courseName
		);
		By byCancelBtn = By.xpath(xpathCancelBtn);

		// Thực hiện cuộn và click vào nút hủy
		scrollAndClick(byCancelBtn);

		// Tự động kiểm tra và xử lý SweetAlert popup nếu xuất hiện
		By byConfirmSwalBtn = By.xpath("//button[contains(@class, 'swal-button--confirm') or text()='OK' or contains(text(), 'Xác nhận')]");
		if (isDisplayed(byConfirmSwalBtn, TimeOutConstant.TIME_OUT_MEDIUM)) {
			click(byConfirmSwalBtn);
		}
	}
}