<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Sản phẩm - Chim Ưng Tech</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

    <!-- HEADER -->
    <header>
        <h1>NoBi Tech</h1>
        <nav>
            <a href="index.jsp">Trang chủ</a>
            <a href="product-list.jsp">Sản phẩm</a>
            <a href="cart.jsp">Giỏ hàng</a>
            <a href="login.jsp" class="btn">Đăng nhập</a>
            <a href="register.jsp" class="btn btn-success">Đăng ký</a>
        </nav>
    </header>

    <!-- NỘI DUNG CHÍNH -->
    <div class="container">
        <h2>Danh sách sản phẩm</h2>

        <div class="product-list">
            <div class="product-card">
                <img src="../images/laptop1.jpg" alt="Laptop Gaming">
                <div class="info">
                    <h3>Laptop Gaming ABC</h3>
                    <p>Hiệu suất cao, thiết kế mạnh mẽ</p>
                    <div class="price">25.000.000₫</div>
                    <a href="cart.jsp" class="btn">Thêm vào giỏ</a>
                </div>
            </div>

            <div class="product-card">
                <img src="../images/phone1.jpg" alt="Smartphone">
                <div class="info">
                    <h3>Smartphone XYZ</h3>
                    <p>Camera đỉnh cao, pin siêu bền</p>
                    <div class="price">12.500.000₫</div>
                    <a href="cart.jsp" class="btn">Thêm vào giỏ</a>
                </div>
            </div>

            <!-- Thêm sản phẩm khác -->
        </div>
    </div>

    <!-- FOOTER -->
    <footer>
        © 2025 NoBi Tech. All rights reserved.
    </footer>

</body>
</html>
