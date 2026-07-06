package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserAPI {
    private static final String BASE_URL = "https://elearningnew.cybersoft.edu.vn/api";
    private static final String TOKEN_CYBERSOFT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5Mb3AiOiJUZXN0aW5nIDE0IiwiSGV0SGFuU3RyaW5nIjoiMTUvMTAvMjAyNiIsIkhldEhhblRpbWUiOiIxNzkyMDIyNDAwMDAwIiwibmJmIjoxNzY3ODkxNjAwLCJleHAiOjE3OTIxNzAwMDB9.DLVjgmwvBK8rzcWWgQA7dYOQuJZ55Vm5MThmUNcx8As";

    /**
     * Đăng ký tài khoản User mới
     */
    public static Response registerUser(String taiKhoan, String matKhau, String hoTen, String email, String soDT, String maNhom) {
        Map<String, String> body = new HashMap<>();
        body.put("taiKhoan", taiKhoan);
        body.put("matKhau", matKhau);
        body.put("hoTen", hoTen);
        body.put("email", email);
        body.put("soDT", soDT);
        body.put("maNhom", maNhom);

        return RestAssured.given()
                .header("tokencybersoft", TOKEN_CYBERSOFT)
                .contentType(ContentType.JSON)
                .body(body)
                .post(BASE_URL + "/QuanLyNguoiDung/DangKy");
    }

    /**
     * Đăng nhập tài khoản để lấy mã Access Token
     */
    public static Response loginUser(String taiKhoan, String matKhau) {
        Map<String, String> body = new HashMap<>();
        body.put("taiKhoan", taiKhoan);
        body.put("matKhau", matKhau);

        return RestAssured.given()
                .header("tokencybersoft", TOKEN_CYBERSOFT)
                .contentType(ContentType.JSON)
                .body(body)
                .post(BASE_URL + "/QuanLyNguoiDung/DangNhap");
    }

    /**
     * Tự động Ghi danh (Đăng ký) một khóa học cho tài khoản chỉ định để làm Setup Data cho UI Testing
     *
     * @param maKhoaHoc Mã khóa học cần ghi danh (ví dụ: ".100" hoặc "Javascript nâng cao mới")
     * @param taiKhoan  Tên tài khoản người dùng thực hiện test (ví dụ: "trucanh")
     * @param userToken Access Token (Bearer) nhận được sau khi gọi hàm loginUser thành công
     */

    public static Response enrollCourseViaAPI(String maKhoaHoc, String taiKhoan, String userToken) {
        Map<String, String> body = new HashMap<>();
        body.put("maKhoaHoc", maKhoaHoc);
        body.put("taiKhoan", taiKhoan);

        return RestAssured.given()
                .header("tokencybersoft", TOKEN_CYBERSOFT) // Token hệ thống định danh dự án
                .header("Authorization", "Bearer " + userToken) // Token đăng nhập của user (Xóa lỗi 401)
                .contentType(ContentType.JSON)
                .body(body)
                .post(BASE_URL + "/QuanLyKhoaHoc/DangKyKhoaHoc");
    }
}