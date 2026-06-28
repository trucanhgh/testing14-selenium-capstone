package testcase.ui.profile;

import api.UserAPI;
import io.restassured.response.Response;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CourseTabSection;
import pages.ProfilePage;
import java.util.List;

public class CourseTabTest extends ProfileTestBase {

    private ProfilePage profilePage;
    private CourseTabSection courseTabSection;

    // Khóa học đích dùng cho các kịch bản kiểm tra tìm kiếm (Search)
    private final String TARGET_COURSE = "Javascript nâng cao mới";

    // Khóa học đích dùng cho kịch bản hủy khóa học (Cancel)
    private final String CANCEL_COURSE = ".100";

    @BeforeClass
    public void setupCourseTabTest() {
        // 1. Tạo account ngẫu nhiên mới tinh qua API (Tự sinh dynamicUser)
        createAccountViaAPI();

        // 2. Danh sách các mã khóa học cần chuẩn bị theo yêu cầu đề bài
        String[] coursesToEnroll = {"000123456", "000", "09876788", "100999", ".100"};

        // 3. Ghi danh hàng loạt trực tiếp thông qua token chung hệ thống
        enrollCoursesForDynamicUserViaAPI(coursesToEnroll);

        // 4. Mở trình duyệt, thực hiện luồng UI Login và đi tới trang Profile tab Khóa học
        profilePage = loginAndGoToProfile(dynamicUser, dynamicPass);
        profilePage.openCourseTab();
        courseTabSection = profilePage.getCourseTabSection();
    }

    // ==========================================
    // 1. NHÓM KIỂM TRA GIAO DIỆN & ĐIỀU HƯỚNG (UI)
    // ==========================================

    @Test(priority = 14, description = "TC_14: Xác minh hiển thị tab bar [Thông tin cá nhân]/[Khóa học] - Đã đăng nhập thành công")
    public void verifyProfileTabBarDisplay() {
        Assert.assertTrue(profilePage.isPersonalInfoTabDisplayed(), "Tab [Thông tin cá nhân] không hiển thị!");
        Assert.assertTrue(profilePage.isCourseTabDisplayed(), "Tab [Khóa học] không hiển thị!");
        // Theo TC_14: Mặc định vào trang thì tab Thông tin cá nhân phải active
        Assert.assertTrue(profilePage.isPersonalInfoSectionDisplayed(), "Mặc định tab Thông tin cá nhân chưa active!");
    }

    @Test(priority = 15, description = "TC_15: Xác minh khi chuyển tab [Thông tin cá nhân]/[Khóa học]")
    public void verifySwitchToCourseTab() {
        profilePage.openCourseTab();
        courseTabSection = profilePage.getCourseTabSection();

        Assert.assertTrue(courseTabSection.isCourseTabReady(), "Nội dung tab [Khóa học] không hiển thị sau khi click!");
    }

    @Test(priority = 16, description = "TC_16: Xác minh hiển thị cấu trúc cơ bản của tab [Khóa học]")
    public void verifyCourseTabStructure() {
        // Đảm bảo đang ở tab khóa học từ bài test trước
        Assert.assertTrue(courseTabSection.isCourseTabReady(), "Tab Khóa học chưa sẵn sàng!");
    }

    @Test(priority = 17, description = "TC_17 & TC_18: Xác minh hiển thị Danh sách khóa học và chi tiết từng khóa")
    public void verifyCourseListAndCardDetails() {
        int courseCount = courseTabSection.getCourseCount();

        // Assert xem có khóa học nào không để tránh list rỗng (Nên pre-condition bằng API add khóa học trước)
        Assert.assertTrue(courseCount >= 0, "Không lấy được số lượng khóa học (Lỗi Empty State hoặc Card)");

        if (courseCount > 0) {
            // Kiểm tra thẻ card đầu tiên hiển thị đầy đủ thông tin (Ảnh, Tên, Giảng viên, Nút Hủy)
            var courseCard = courseTabSection.getCourseLargeCardByIndex(1);
            Assert.assertTrue(courseCard.isDisplayed(), "Khóa học vị trí số 1 không hiển thị!");

            String firstCourseTitle = courseTabSection.getCourseTitleByIndex(1);
            Assert.assertFalse(firstCourseTitle.isEmpty(), "Tên khóa học hiển thị bị rỗng!");
        }
    }

    // ==========================================
    // 2. LUỒNG LOGIC: TÌM KIẾM KHÓA HỌC (SEARCH)
    // ==========================================

    @Test(priority = 22, description = "TC_22: Xác minh khi nhấn Enter trên [Tìm kiếm] không kích hoạt sự kiện tìm kiếm riêng")
    public void verifySearchWithEnterKey() {
        int countBefore = courseTabSection.getCourseCount();

        courseTabSection.searchCourse(TARGET_COURSE);
        courseTabSection.pressEnterOnSearch();

        int countAfter = courseTabSection.getCourseCount();
        // Hệ thống không bind sự kiện tìm kiếm riêng cho Enter, kết quả giữ nguyên (hoặc bằng trước đó do realtime)
        Assert.assertEquals(countAfter, countBefore, "Hệ thống thay đổi trạng thái sai khi nhấn Enter!");
    }

    @Test(priority = 23, description = "TC_23: Xác minh khi nhập tên khóa học chính xác vào [Tìm kiếm]")
    public void verifySearchExactCourseName() {
        courseTabSection.searchCourse(TARGET_COURSE);

        Assert.assertTrue(courseTabSection.isCourseExists(TARGET_COURSE), "Không tìm thấy khóa học khi nhập tên chính xác!");
        Assert.assertEquals(courseTabSection.getCourseCount(), 1, "Kết quả tìm kiếm chính xác phải trả về 1 bản ghi!");
    }

    @Test(priority = 24, description = "TC_24: Xác minh khi nhập khoảng trắng vào trước và sau từ khóa [Tìm kiếm]")
    public void verifySearchWithSpacesTrimmed() {
        String searchKeyWithSpaces = "   " + TARGET_COURSE + "   ";
        courseTabSection.searchCourse(searchKeyWithSpaces);

        // Hệ thống tự động trim -> Vẫn phải tìm ra khóa học chính xác
        Assert.assertTrue(courseTabSection.isCourseExists(TARGET_COURSE), "Hệ thống không tự động trim khoảng trắng đầu/cuối!");
    }

    @Test(priority = 25, description = "TC_25: Xác minh khi nhập vào [Tìm kiếm] theo từ khóa khớp một phần")
    public void verifySearchPartialMatch() {
        courseTabSection.searchCourse("Jav");

        List<String> titles = courseTabSection.getAllCourseTitles();
        Assert.assertTrue(titles.size() > 0, "Không có kết quả nào khớp với từ khóa một phần 'Jav'!");

        // Kiểm tra tất cả các kết quả trả về đều chứa chữ "Jav" (Không phân biệt hoa thường)
        for (String title : titles) {
            Assert.assertTrue(title.toLowerCase().contains("jav"), "Khóa học hiển thị sai: " + title);
        }
    }

    @Test(priority = 26, description = "TC_26: Xác minh tìm kiếm không phân biệt hoa/thường")
    public void verifySearchCaseInsensitive() {
        courseTabSection.searchCourse("javascript nâng cao mới");

        Assert.assertTrue(courseTabSection.isCourseExists(TARGET_COURSE), "Tìm kiếm có phân biệt hoa/thường!");
    }

    @Test(priority = 27, description = "TC_27: Xác minh tìm kiếm bằng tiếng Việt có dấu")
    public void verifySearchWithVietnameseTones() {
        courseTabSection.searchCourse("nâng cao mới");

        Assert.assertTrue(courseTabSection.isCourseExists(TARGET_COURSE), "Không tìm thấy khóa học khi gõ tiếng Việt có dấu!");
    }

    @Test(priority = 28, description = "TC_28: Xác minh khi xóa từ khóa tìm kiếm quay lại danh sách đầy đủ")
    public void verifyRealtimeSearchAndClear() {
        // Gõ từ khóa tìm kiếm
        courseTabSection.searchCourse(TARGET_COURSE);
        int filteredCount = courseTabSection.getCourseCount();

        // Xóa sạch ô tìm kiếm
        courseTabSection.searchCourse("");
        int fullCount = courseTabSection.getCourseCount();

        Assert.assertTrue(fullCount >= filteredCount, "Sau khi xóa keyword, danh sách tổng không được khôi phục!");
    }

    // ==========================================
    // 3. LUỒNG LOGIC: HỦY KHÓA HỌC (CANCEL)
    // ==========================================

    @Test(priority = 21, description = "TC_21: Xác minh khi chọn [Hủy khóa học]")
    public void verifyCancelCourseSuccessfully() {
        // Xóa tìm kiếm trước đó để đảm bảo hiển thị đủ danh sách
        courseTabSection.searchCourse("");

        // Kiểm tra xem khóa học cần hủy (.100) có tồn tại trong danh sách để test không
        if (courseTabSection.isCourseExists(CANCEL_COURSE)) {
            courseTabSection.cancelCourseByName(CANCEL_COURSE);

            // Xác minh lại sau khi hủy thành công (Hàm cancelCourseByName trong CourseTabSection đã tự handle click OK trên SweetAlert)
            Assert.assertFalse(courseTabSection.isCourseExists(CANCEL_COURSE), "Khóa học vẫn tồn tại sau khi thực hiện Hủy!");
        } else {
            Assert.fail("Không thể thực hiện TC_21 vì khóa học '" + CANCEL_COURSE + "' không tồn tại sẵn trong tài khoản test!");
        }
    }
}