# Selenium Capstone - Xây dựng Automation Testing Framework cho Website Bán Khóa Học Online
## Links

- Website: `https://demo2.cybersoft.edu.vn/`
- Thư mục lưu file manual TC (Excel): `manual-testcases/`

## Công nghệ sử dụng

- `Java`: ngôn ngữ chính để viết framework và test script.
- `Selenium WebDriver`: tự động hóa thao tác trên trình duyệt.
- `TestNG`: tổ chức test case, suite XML, annotation, assert.
- `Gradle`: quản lý dependency và build project.
- `ExtentReports`: sinh báo cáo test trực quan.
- `Log4j2`: ghi log trong quá trình chạy test.
- `Git/GitHub`: quản lý source code, branch và pull request.

## Clone dự án

```terminal
git clone https://github.com/trucanhgh/testing14-selenium-capstone.git
cd testing14-selenium-capstone
```

## Hướng Dẫn Chạy Test Suites

Bạn có thể kích hoạt chạy kiểm thử thông qua TestNG XML Suites bằng 2 cách:

### Cách 1: Chạy trực tiếp từ IDE (IntelliJ IDEA)
1. Mở thư mục dự án trên IntelliJ.
2. Điều hướng theo cây thư mục: `src` -> `test` -> `resources` -> `suites`.
3. Nhấp chuột phải vào file suite tương ứng với phần việc của mình (Ví dụ: `profile-suite.xml`, `blog-suite.xml`, `homepage-suite.xml` hoặc `full-suite.xml`).
4. Chọn **Run '<tên_file>.xml'** để bắt đầu quá trình thực thi.

### Cách 2: Chạy bằng dòng lệnh (Terminal / Gradle wrapper)
Sử dụng dòng lệnh dưới đây từ Terminal của dự án để thực thi suite mong muốn:
```terminal
./gradlew test -Psuite=<tên_suite_không_gồm_đuôi_xml>
```
Ví dụ chạy suite của Profile: 
```terminal
./gradlew test -Psuite=profile-suite
```
