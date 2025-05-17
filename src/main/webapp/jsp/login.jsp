<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<div class="form-container">
    <form action="LoginServlet" method="post" class="form-box">
        <h2>Đăng nhập</h2>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>
        </div>

        <div class="form-group">
            <label for="password">Mật khẩu:</label>
            <input type="password" name="password" id="password" required>
        </div>

        <button type="submit" class="btn">Đăng nhập</button>

        <p class="form-footer">Chưa có tài khoản? <a href="register.jsp">Đăng ký</a></p>
    </form>
</div>

</body>
</html>
