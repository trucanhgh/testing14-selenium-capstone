## Quy trình làm việc với nhánh riêng

Mỗi thành viên làm việc trên 1 nhánh riêng theo đúng tên của mình, không commit trực tiếp vào nhánh main.

1) Cập nhật code mới nhất từ nhánh chính

```terminal
git checkout main
git pull origin main

2) Tạo nhánh cá nhân theo tên

```terminal
git checkout -b <yourname>
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

Các `type` hay dùng:
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
- `src/test/resources/suites`: quản lý danh sách class test để chạy.

## Quy ước team để tránh conflict

- Mỗi người chỉ sửa vào package/module của mình.
- Đặt tên class rõ ràng theo module.
- Commit nhỏ, message rõ ràng, dễ review.
- Trước khi tạo PR, đảm bảo cập nhật lại nhánh từ `main` để hạn chế conflict.
