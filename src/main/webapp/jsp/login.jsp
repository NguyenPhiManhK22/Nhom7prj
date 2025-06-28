<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
<div class="auth-container">
    <div class="auth-form">
        <h2>Đăng nhập</h2>
        <form action="login" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required autofocus/>
            <label for="matkhau">Mật khẩu:</label>
            <input type="password" id="matkhau" name="matkhau" required/>

            <% if(request.getAttribute("errorMsg") != null) { %>
                <div class="error-msg"><%= request.getAttribute("errorMsg") %></div>
            <% } %>
 
            <button type="submit">Đăng nhập</button>
        </form>
        <p>Bạn chưa có tài khoản? <a href="register">Đăng ký ngay</a></p>
        <a href="sanpham" class="btn-back-home">&larr; Quay lại Trang Chủ</a>
    </div>
</div>
</body>
</html>
