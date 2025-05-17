<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng - NoBi Tech</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<header>
    <h1>Chào mừng đến với NoBi Tech</h1>
    <nav>
        <a href="index.jsp">Trang chủ</a>
        <a href="product-list.jsp">Sản phẩm</a>
        <a href="cart.jsp" class="active">Giỏ hàng</a>
        <a href="login.jsp">Đăng nhập</a>
        <a href="register.jsp" class="btn btn-success">Đăng ký</a>
    </nav>
</header>

<div class="container">
    <h2>Giỏ hàng của bạn</h2>
    <table class="cart-table">
        <thead>
            <tr>
                <th>Sản phẩm</th>
                <th>Số lượng</th>
                <th>Giá</th>
                <th>Tổng cộng</th>
                <th>Xóa</th>
            </tr>
        </thead>
        <tbody>
            <!-- Giả sử bạn đã có dữ liệu giỏ hàng -->
            <tr>
                <td>Laptop ABC</td>
                <td><input type="number" value="1" min="1"></td>
                <td>12,000,000 VND</td>
                <td>12,000,000 VND</td>
                <td><button>Xóa</button></td>
            </tr>
            <tr>
                <td>Smartphone XYZ</td>
                <td><input type="number" value="1" min="1"></td>
                <td>8,000,000 VND</td>
                <td>8,000,000 VND</td>
                <td><button>Xóa</button></td>
            </tr>
        </tbody>
    </table>

    <div class="cart-total">
        <p>Tổng giá trị giỏ hàng: 20,000,000 VND</p>
        <button class="btn btn-primary">Thanh toán</button>
    </div>
</div>

<footer>
    © 2025 NoBi Tech. All rights reserved.
</footer>

</body>
</html>
