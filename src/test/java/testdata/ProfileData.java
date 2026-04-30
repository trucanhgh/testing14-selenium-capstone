package testdata;

import org.testng.annotations.DataProvider;

public class ProfileData {

    @DataProvider(name = "fullNameInvalidData")
    public static Object[][] getFullNameInvalidData() {
        return new Object[][]{
                {"", "Tên không được để trống", "Để trống Họ Tên"},
                {"#@!", "Chỉ nhập kí tự chữ", "Chứa ký tự đặc biệt"},
                {"123", "Chỉ nhập kí tự chữ", "Chứa ký tự số"},
                {"   ", "Tên không được để trống", "Chỉ nhập dấu cách"}
        };
    }

    @DataProvider(name = "passwordInvalidData")
    public static Object[][] getPasswordInvalidData() {
        return new Object[][]{
                {"", "Mật khẩu không được để trống", "Để trống Mật khẩu"},
                {"Abc123@", "Mật khẩu phải ít nhất 8 tự gồm chữ hoa, chữ thường, số, và kí tự đặc biệt", "Nhập 7 ký tự"},
                {"12345678@", "Mật khẩu phải ít nhất 8 tự gồm chữ hoa, chữ thường, số, và kí tự đặc biệt", "Thiếu chữ"},
                {"Abcdefgh@", "Mật khẩu phải ít nhất 8 tự gồm chữ hoa, chữ thường, số, và kí tự đặc biệt", "Thiếu số"},
                {"Abcd1234", "Mật khẩu phải ít nhất 8 tự gồm chữ hoa, chữ thường, số, và kí tự đặc biệt", "Thiếu KT đặc biệt"},
                {"abcd1234@", "Mật khẩu phải ít nhất 8 tự gồm chữ hoa, chữ thường, số, và kí tự đặc biệt", "Thiếu in hoa"},
                {"ABCD1234@", "Mật khẩu phải ít nhất 8 tự gồm chữ hoa, chữ thường, số, và kí tự đặc biệt", "Thiếu in thường"}
        };
    }

    @DataProvider(name = "emailInvalidData")
    public static Object[][] getEmailInvalidData() {
        return new Object[][]{
                {"", "Email không được để trống", "Để trống Email"},
                {"abcgmail.com", "Email không hợp lệ", "Thiếu @"},
                {"abc@gmailcom", "Email không hợp lệ", "Thiếu dấu chấm"},
                {"ab c@gmail.com", "Email không hợp lệ", "Chứa khoảng trắng"},
                {"abc#@gmail.com", "Email không hợp lệ", "Chứa ký tự đặc biệt"}
        };
    }

    @DataProvider(name = "phoneInvalidData")
    public static Object[][] getPhoneInvalidData() {
        return new Object[][]{
                {"", "Số điện thoại không được để trống", "Để trống SĐT"},
                {"11234567890", "Số điện thoại chưa đúng định đạng", "Không bắt đầu bằng 0"},
                {"012345678", "Số điện thoại chưa đúng định đạng", "Chỉ có 9 số"},
                {"012345678901", "Số điện thoại chưa đúng định đạng", "Có tới 12 số"}
        };
    }
}