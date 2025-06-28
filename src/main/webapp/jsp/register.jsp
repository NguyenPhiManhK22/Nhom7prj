<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Đăng ký</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
<div class="auth-container">
    <div class="auth-form">
    <h2>Đăng ký tài khoản</h2>
    <form action="register" method="post">
        <label for="hoten">Họ tên:</label><br/>
        <input type="text" id="hoten" name="hoten" required/><br/><br/>
        
        <label for="email">Email:</label><br/>
        <input type="email" id="email" name="email" required/><br/><br/>
        
        <label for="matkhau">Mật khẩu:</label><br/>
        <input type="password" id="matkhau" name="matkhau" required/><br/><br/>
        
        <label for="sdt">Số điện thoại:</label><br/>
        <input type="text" id="sdt" name="sdt"/><br/><br/>
        
        <label for="diachi">Địa chỉ:</label><br/>
        <textarea id="diachi" name="diachi" rows="3"></textarea><br/><br/>
        
        <button type="submit">Đăng ký</button>
    </form>
    <p>Đã có tài khoản? <a href="login">Đăng nhập</a></p>
    <p style="color:red;">
        <%= request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "" %>
    </p>
</div>
</div>
</body>
</html>
