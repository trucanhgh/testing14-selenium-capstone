package testcase.ui.profile;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CourseTabSection;
import pages.ProfilePage;
@SuppressWarnings("unused")
public class CourseTabTest extends ProfileTestBase {
    // UI group: TC_14 -> TC_28
    @Test(description = "Course tab should display search and course list skeleton", enabled = false)
    public void verifyCourseTabShowsSearchAndList() {
        ProfilePage profilePage = openProfilePage();
        profilePage.openCourseTab();
        CourseTabSection courseTabSection = profilePage.getCourseTabSection();
        Assert.assertTrue(courseTabSection.isCourseTabReady(), "TODO: confirm course tab locators");
    }
    @Test(description = "Course search skeleton using keyword", enabled = false)
    public void verifyCourseSearchSkeleton() {
        ProfilePage profilePage = openProfilePage();
        profilePage.openCourseTab();
        CourseTabSection courseTabSection = profilePage.getCourseTabSection();
        courseTabSection.searchCourse("Javascript");
        Assert.assertTrue(courseTabSection.isCourseListDisplayed(), "TODO: confirm course list locator");
    }
}
