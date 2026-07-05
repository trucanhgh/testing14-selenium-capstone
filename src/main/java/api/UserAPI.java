package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserAPI {
    private static final String BASE_URL = "https://elearningnew.cybersoft.edu.vn/api";
    private static final String TOKEN_CYBERSOFT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5Mb3AiOiJUZXN0aW5nIDE0IiwiSGV0SGFuU3RyaW5nIjoiMTUvMTAvMjAyNiIsIkhldEhhblRpbWUiOiIxNzkyMDIyNDAwMDAwIiwibmJmIjoxNzY3ODkxNjAwLCJleHAiOjE3OTIxNzAwMDB9.DLVjgmwvBK8rzcWWgQA7dYOQuJZ55Vm5MThmUNcx8As";

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

    public static Response login(String taiKhoan, String matKhau) {
        Map<String, String> body = new HashMap<>();
        body.put("taiKhoan", taiKhoan);
        body.put("matKhau", matKhau);

        return RestAssured.given()
                .header("tokencybersoft", TOKEN_CYBERSOFT)
                .contentType(ContentType.JSON)
                .body(body)
                .post(BASE_URL + "/QuanLyNguoiDung/DangNhap");
    }
}