<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.NguoiDung" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tin Công Nghệ</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<header class="top-header">
    <div class="header-container">
        <div class="logo">
            <a href="index"><img src="${pageContext.request.contextPath}/images/logo.png" alt="TechShop Logo" /></a>
        </div>

        <div class="search-bar">
            <input type="text" placeholder="Bạn đang tìm kiếm sản phẩm công nghệ gì..." />
            <button><i class="fas fa-search"></i></button>
        </div>

        <div class="header-icons">
            <a href="Hethongcuahang.jsp"><i class="fas fa-map-marker-alt"></i><span>Hệ thống cửa hàng</span></a>
            <%
                NguoiDung userLogin = (NguoiDung) session.getAttribute("userLogin");
                if (userLogin != null) {
            %>
                <span style="color: white; margin-right: 12px;">Xin chào, <%= userLogin.getHoTen() %>!</span>
                <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
            <%
                } else {
            %>
                <a href="<%= request.getContextPath() %>/login"><i class="fas fa-user"></i><span>Đăng nhập</span></a>
            <%
                }
            %>
            <a href="giohang"><i class="fas fa-shopping-cart"></i><span>Giỏ hàng</span></a>
        </div>
    </div>
</header>

<nav class="main-nav">
    <ul>
        <li><a href="<%= request.getContextPath() %>/index"><i class="fa fa-home"></i>TRANG CHỦ</a></li>
        <li><a href="<%= request.getContextPath() %>/sanpham">SẢN PHẨM</a></li>
        <li><a href="tintuc.jsp"> TIN CÔNG NGHỆ <i class="fas fa-bolt"></i></a></li>
        <li><a href="<%= request.getContextPath() %>/donhang"> ĐƠN HÀNG </a></li>
    </ul>
</nav>

<div class="container cart-container">
    <h2 class="cart-header">Tin Công Nghệ Mới Nhất</h2>
    <div class="news-item">
        <img src="images/tin1.jpg" alt="Tin tức 1" style="width:250px;">
        <h3>iPhone 16 chính thức ra mắt với chip A19 và camera AI</h3>
        <p>Apple đã giới thiệu dòng iPhone 16 với công nghệ AI và cải tiến lớn về camera ban đêm.</p>
    </div>
    <div class="news-item">
        <img src="images/tin2.jpg" alt="Tin tức 2" style="width:250px;">
        <h3>Laptop gaming 2025 – Chiến mọi tựa game</h3>
        <p>Các hãng như ASUS, MSI, Acer trình làng dòng laptop RTX 5090 mới, hiệu năng vượt trội.</p>
    </div>
</div>

</body>
</html>
