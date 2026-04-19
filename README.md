# Selenium Capstone - Website Bán Khóa Học Online

## Website demo test

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

Clone repo:

```terminal
git clone https://github.com/trucanhgh/testing14-selenium-capstone.git
cd testing14-selenium-capstone
```

## Quy trình làm việc với nhánh riêng

Mỗi thành viên làm việc trên 1 nhánh riêng theo đúng tên của mình, không commit trực tiếp vào nhánh main.

1) Cập nhật code mới nhất từ nhánh chính

```terminal
git checkout main
git pull origin main
```

2) Tạo nhánh cá nhân theo tên

```terminal
git checkout -b <yourname>
```

Ví dụ:

```terminal
git checkout -b trucanh
```

3) Commit thay đổi

```terminal
git add .
git commit -m "feat(<module>): mô tả ngắn gọn thay đổi"
```

4) Đẩy nhánh lên remote

```terminal
git push -u origin <yourname>
```

5) Tạo Pull Request vào `main` để review trước khi merge.
- Đẩy nhánh cá nhân lên remote:
- Vào GitHub của repository -> Pull requests -> New pull request. 
- Chọn:
   base: main
   compare: nhánh cá nhân
- Điền tiêu đề và mô tả PR
- Bấm Create pull request. 

## Cách đặt commit message cơ bản

Nên dùng format ngắn gọn:

`<type>(<scope>): <mô tả>`

Trong đó:
- `type`: loại thay đổi
- `scope`: module/phần ảnh hưởng (có thể bỏ qua nếu không cần)
- `mô tả`: viết ngắn, rõ ý, bắt đầu bằng động từ

Các` `type` hay dùng:
- `feat`: thêm tính năng/testcase mới
- `fix`: sửa lỗi
- `docs`: cập nhật tài liệu (README, guideline...)
- `test`: thêm/sửa test

Ví dụ commit message:
- `feat(user-profile): thêm testcase cập nhật email`
- `fix(login): sửa locator nút đăng nhập`
- `docs(readme): cập nhật quy trình làm việc theo nhánh`
- `test(payment): bổ sung smoke test thanh toán`
- 
## Các file chính thành viên sẽ làm việc

Framework/core (thường ít sửa, chỉ sửa khi cần mở rộng):
- `src/main/java/base/BaseTest.java`: setup/teardown, chọn browser, khởi tạo report.
- `src/main/java/base/BasePage.java`: các hàm dùng chung (click, input, wait, getText).
- `src/main/java/driver/DriverManagerFactory.java`: map browser -> driver manager.
- `src/main/java/listeners/TestListener.java`: xử lý log/screenshot khi test fail.
- `src/main/java/report/ExtentReportManager.java`: quản lý Extent report.

Nơi thành viên sẽ code module của mình:
- `src/main/java/pages/`: tạo page object theo module.
- `src/main/java/components/`: tạo component tái sử dụng (menu, table, modal...).
- `src/test/java/testcase/`: viết test class cho module.
- `src/test/resources/regression-test.xml`: quản lý danh sách class test để chạy.

## Quy ước team để tránh conflict

- Mỗi người chỉ sửa vào package/module của mình.
- Đặt tên class rõ ràng theo module.
- Commit nhỏ, message rõ ràng, dễ review.
- Trước khi tạo PR, đảm bảo cập nhật lại nhánh từ `main` để hạn chế conflict.
