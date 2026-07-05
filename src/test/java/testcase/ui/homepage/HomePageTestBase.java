package testcase.ui.homepage;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.HomePage;

import java.util.HashMap;
import java.util.Map;

public class HomePageTestBase extends BaseTest {

    protected HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void openHomePage() {
        openBaseUrl();          // mở trang chủ
        waitForPageReady();     // đợi load
        homePage = new HomePage(getDriver());
    }
    private static final Map<String, String> INSTRUCTOR_ROLES = new HashMap<>();

    static {
        INSTRUCTOR_ROLES.put("IcarDi MenBor", "Chuyên gia ngôn ngữ");
        INSTRUCTOR_ROLES.put("Bladin Slaham", "Chuyên gia hệ thống máy tính");
        INSTRUCTOR_ROLES.put("Chris Andersen", "Chuyên gia lĩnh vực Full Skill");
        INSTRUCTOR_ROLES.put("VueLo Gadi", "Chuyên gia lĩnh vực Phân tích");
        INSTRUCTOR_ROLES.put("Hoàng Nam", "Chuyên gia lĩnh vực PHP");
        INSTRUCTOR_ROLES.put("David Ngô Savani", "Chuyên gia lĩnh vực Front End");
        INSTRUCTOR_ROLES.put("Big DadMoon", "Chuyên gia lĩnh vực lập trình");
    }


    public static String getExpectedInstructorRole(String instructorName) {
        if (!INSTRUCTOR_ROLES.containsKey(instructorName)) {
            throw new IllegalArgumentException("Không tìm thấy giảng viên trong HomepageData: " + instructorName);
        }
        return INSTRUCTOR_ROLES.get(instructorName);
    }

    @DataProvider(name = "introductionBlocks")
    public static Object[][] getIntroductionBlocks() { // BẮT BUỘC phải có chữ static ở đây bạn nhé!
        return new Object[][]{
                {"Khóa học", "TC_15.1"},
                {"Lộ trình phù hợp", "TC_15.2"},
                {"Hệ thống học tập", "TC_15.3"},
                {"Giảng viên", "TC_15.4"},
                {"Chứng nhận", "TC_15.5"}
        };
    }

}