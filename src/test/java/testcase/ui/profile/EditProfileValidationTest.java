package testcase.ui.profile;

import api.UserAPI;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
        editProfileModal = profilePage.openEditProfileModal();
    }
    // ==========================================
    // 1. KIỂM TRA UI & ĐÓNG MODAL
    // ==========================================
    @Test(description = "Xác minh hiển thị UI cơ bản và chức năng đóng của Modal")
    public void verifyEditProfileModalUIAndCloseFunction() {
        Assert.assertTrue(editProfileModal.isModalDisplayed(), "Modal không hiển thị!");
        Assert.assertTrue(editProfileModal.isFieldsDisplayed(), "Thiếu input fields!");

        editProfileModal.closeWithIcon();
        Assert.assertTrue(profilePage.isProfilePageLoaded(), "Modal không đóng lại!");
    }

    // ==========================================
    // 2. NHÓM DATA-DRIVEN CHO VALIDATION FORM
    // Dữ liệu lấy từ file ProfileData.java
    // ==========================================
    @Test(dataProvider = "fullNameInvalidData", dataProviderClass = ProfileData.class)
    public void verifyFullNameValidation(String fullName, String expectedMsg, String desc) {
        editProfileModal.fillForm(fullName, dynamicPass, dynamicEmail, dynamicPhone);
        Assert.assertTrue(editProfileModal.isFieldErrorDisplayed("hoTen"), "Không hiển thị lỗi cho: " + desc);
        Assert.assertEquals(editProfileModal.getFieldErrorMessage("hoTen"), expectedMsg);
    }

    @Test(dataProvider = "passwordInvalidData", dataProviderClass = ProfileData.class)
    public void verifyPasswordValidation(String password, String expectedMsg, String desc) {
        editProfileModal.fillForm("Valid Name", password, dynamicEmail, dynamicPhone);
        Assert.assertTrue(editProfileModal.isFieldErrorDisplayed("matKhau"), "Không hiển thị lỗi cho: " + desc);
        Assert.assertEquals(editProfileModal.getFieldErrorMessage("matKhau"), expectedMsg);
    }

    @Test(dataProvider = "emailInvalidData", dataProviderClass = ProfileData.class)
    public void verifyEmailValidation(String email, String expectedMsg, String desc) {
        editProfileModal.fillForm("Valid Name", dynamicPass, email, dynamicPhone);
        Assert.assertTrue(editProfileModal.isFieldErrorDisplayed("email"), "Không hiển thị lỗi cho: " + desc);
        Assert.assertEquals(editProfileModal.getFieldErrorMessage("email"), expectedMsg);
    }

    @Test(dataProvider = "phoneInvalidData", dataProviderClass = ProfileData.class)
    public void verifyPhoneValidation(String phone, String expectedMsg, String desc) {
        editProfileModal.fillForm("Valid Name", dynamicPass, dynamicEmail, phone);
        Assert.assertTrue(editProfileModal.isFieldErrorDisplayed("soDT"), "Không hiển thị lỗi cho: " + desc);
        Assert.assertEquals(editProfileModal.getFieldErrorMessage("soDT"), expectedMsg);
    }

    // ==========================================
    // 3. LUỒNG LOGIC: TRÙNG EMAIL & CẬP NHẬT THÀNH CÔNG
    // ==========================================
    @Test(description = "Xác minh báo lỗi khi nhập Email đã liên kết với tài khoản khác")
    public void verifyEmailAlreadyExists() {
        editProfileModal.fillForm("New Name", dynamicPass, existingSystemEmail, dynamicPhone);
        editProfileModal.submit();

        Assert.assertTrue(editProfileModal.isFieldErrorDisplayed("email"), "Không hiển thị lỗi trùng Email!");
        Assert.assertEquals(editProfileModal.getFieldErrorMessage("email"), "Email đã tồn tại!");
    }

    @Test(description = "Cập nhật thành công với dữ liệu mới và hợp lệ")
    public void verifyUpdateProfileSuccessfully() {
        String updatedName = "Trúc Anh " + System.currentTimeMillis();
        String updatedEmail = "updated_" + System.currentTimeMillis() + "@test.com";

        editProfileModal.fillForm(updatedName, "Abcd123@", updatedEmail, "0123456789");
        editProfileModal.submit();

        // Kiểm tra hiển thị Popup SweetAlert (bạn đã add vào CommonPage)
        Assert.assertTrue(profilePage.isSuccessPopupDisplayed(), "Không hiện Popup cập nhật thành công!");

        // (Tuỳ chọn) Nếu Web của bạn yêu cầu bấm OK trên Popup để load lại, bạn thêm dòng code thao tác ở đây.
        // Sau khi reload, check tên mới hiển thị trên Profile
        Assert.assertEquals(profilePage.getDisplayedName(), updatedName, "Tên hiển thị chưa cập nhật!");
    }
}