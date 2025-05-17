<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng ký</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<div class="form-container">
    <form action="RegisterServlet" method="post" class="form-box">
        <h2>Đăng ký</h2>

        <div class="form-group">
            <label for="hoTen">Họ tên:</label>
            <input type="text" name="hoTen" id="hoTen" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>
        </div>

        <div class="form-group">
            <label for="matKhau">Mật khẩu:</label>
            <input type="password" name="matKhau" id="matKhau" required>
        </div>

        <div class="form-group">
            <label for="soDienThoai">Số điện thoại:</label>
            <input type="text" name="soDienThoai" id="soDienThoai" required>
        </div>

        <div class="form-group">
            <label for="diaChi">Địa chỉ:</label>
            <input type="text" name="diaChi" id="diaChi" required>
        </div>

        <button type="submit" class="btn">Đăng ký</button>

        <p class="form-footer">Đã có tài khoản? <a href="login.jsp">Đăng nhập</a></p>
    </form>
</div>

</body>
</html>
