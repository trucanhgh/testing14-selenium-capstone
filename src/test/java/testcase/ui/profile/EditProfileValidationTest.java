package testcase.ui.profile;

import api.UserAPI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EditProfileModal;
import pages.ProfilePage;
import testdata.ProfileData;

public class EditProfileValidationTest extends ProfileTestBase {

    private ProfilePage profilePage;
    private EditProfileModal editProfileModal;

    @BeforeClass
    public void setupDataAndLogin() {
        // 1. Tạo account qua API
        createAccountViaAPI();

        // 2. Login và đi thẳng đến trang Profile (Chỉ chạy 1 lần duy nhất)
        profilePage = loginAndGoToProfile(dynamicUser, dynamicPass);

        // 3. Mở sẵn Modal để chuẩn bị cho test đầu tiên
        editProfileModal  = profilePage.openEditProfileModal();
    }

    // ==========================================
    // 1. KIỂM TRA UI & ĐÓNG MODAL
    // ==========================================
    @Test(priority = 1, description = "Xác minh hiển thị UI cơ bản và chức năng đóng của Modal")
    public void verifyEditProfileModalUIAndCloseFunction() {
        Assert.assertTrue(editProfileModal.isModalDisplayed(), "Modal không hiển thị!");
        Assert.assertTrue(editProfileModal.isFieldsDisplayed(), "Thiếu input fields!");

        editProfileModal.closeWithIcon();
        Assert.assertTrue(profilePage.isProfilePageLoaded(), "Modal không đóng lại!");
        editProfileModal = profilePage.openEditProfileModal();
    }

    // ==========================================
    // 2. NHÓM DATA-DRIVEN CHO VALIDATION FORM
    // Dữ liệu lấy từ file ProfileData.java
    // ==========================================
    @Test(priority = 2, dataProvider = "fullNameInvalidData", dataProviderClass = ProfileData.class)
    public void verifyFullNameValidation(String fullName, String expectedMsg, String desc) {
        editProfileModal.fillForm(fullName, dynamicPass, dynamicEmail, dynamicPhone);
        Assert.assertTrue(editProfileModal.isFieldErrorDisplayed("hoTen"), "Không hiển thị lỗi cho: " + desc);
        Assert.assertEquals(editProfileModal.getFieldErrorMessage("hoTen"), expectedMsg);
    }

    @Test(priority = 3, dataProvider = "passwordInvalidData", dataProviderClass = ProfileData.class)
    public void verifyPasswordValidation(String password, String expectedMsg, String desc) {
        try {
            editProfileModal.fillForm("Valid Name", password, dynamicEmail, dynamicPhone);
            Assert.assertTrue(editProfileModal.isFieldErrorDisplayed("matKhau"), "Không hiển thị lỗi cho: " + desc);
            Assert.assertEquals(editProfileModal.getFieldErrorMessage("matKhau"), expectedMsg);
        } finally {
            // Luôn tắt modal cũ đi và mở lại modal mới để làm sạch trạng thái cho row data tiếp theo
            editProfileModal.closeWithIcon();
            editProfileModal = profilePage.openEditProfileModal();
        }
    }

    @Test(priority = 4, dataProvider = "emailInvalidData", dataProviderClass = ProfileData.class)
    public void verifyEmailValidation(String email, String expectedMsg, String desc) {
        editProfileModal.fillForm("Valid Name", dynamicPass, email, dynamicPhone);
        Assert.assertTrue(editProfileModal.isFieldErrorDisplayed("email"), "Không hiển thị lỗi cho: " + desc);
        Assert.assertEquals(editProfileModal.getFieldErrorMessage("email"), expectedMsg);
    }

    @Test(priority = 5, dataProvider = "phoneInvalidData", dataProviderClass = ProfileData.class)
    public void verifyPhoneValidation(String phone, String expectedMsg, String desc) {
        editProfileModal.fillForm("Valid Name", dynamicPass, dynamicEmail, phone);
        Assert.assertTrue(editProfileModal.isFieldErrorDisplayed("soDT"), "Không hiển thị lỗi cho: " + desc);
        Assert.assertEquals(editProfileModal.getFieldErrorMessage("soDT"), expectedMsg);
    }

    // ==========================================
    // 3. LUỒNG LOGIC: TRÙNG EMAIL & CẬP NHẬT THÀNH CÔNG
    // ==========================================
    @Test(priority = 6, description = "Xác minh báo lỗi khi nhập Email đã liên kết với tài khoản khác")
    public void verifyEmailAlreadyExists() {
        editProfileModal.fillForm("New Name", dynamicPass, existingSystemEmail, dynamicPhone);
        editProfileModal.submit();

        Assert.assertTrue(profilePage.isEmailAlreadyExistPopupDisplayed(), "Không hiện Popup email đã tồn tại!");
        editProfileModal.waitForInvisible(By.className("swal-overlay"), 5);
    }

    @Test(priority = 7, description = "Cập nhật thành công với dữ liệu mới và hợp lệ")
    public void verifyUpdateProfileSuccessfully() {
        // Chuẩn hóa chuỗi (bỏ khoảng trắng thừa cuối câu) để tránh lỗi lệch data khi Assert tên hiển thị
        String updatedName = "Trúc Anh";
        String updatedEmail = "updated_" + System.currentTimeMillis() + "@test.com";

        // Thực hiện điền và gửi form
        editProfileModal.fillForm(updatedName, "Abcd123@", updatedEmail, "0931887209");
        editProfileModal.submit();

        // Kiểm tra hiển thị Popup SweetAlert thành công (Hàm đã được định nghĩa ở ProfilePage)
        Assert.assertTrue(profilePage.isSuccessPopupDisplayed(), "Không hiện Popup cập nhật thành công!");

        // (Tuỳ chọn thêm nếu cần) Nếu trang web bắt buộc bấm "OK" trên popup thành công để reload/đóng, bạn thêm dòng click tại đây:
        // profilePage.clickOkOnSuccessPopup();

        // Kiểm tra tên mới đã được hiển thị cập nhật chính xác trên trang Profile
        Assert.assertEquals(profilePage.getDisplayedName(), updatedName, "Tên hiển thị chưa cập nhật chính xác!");
    }
}