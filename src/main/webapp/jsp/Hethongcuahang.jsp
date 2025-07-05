<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.NguoiDung" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hệ thống cửa hàng</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/hethongcuahang.css" />
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
            <a href="<%= request.getContextPath() %>/giohang"><i class="fas fa-shopping-cart"></i><span>Giỏ hàng</span></a>
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
    <h2 class="cart-header">Hệ thống cửa hàng của HawkStore</h2>
    <div class="store">
        <img src="../images/cn-hanoi.jpg" alt="Cửa hàng Hà Nội" style="width:250px;" >
        <p><strong>HawkStore Hà Nội:</strong> 123 Cầu Giấy, Q. Cầu Giấy, Hà Nội</p>
    </div>
    <div class="store">
        <img src="../images/cn-hcm.jpg" alt="Cửa hàng TP.HCM" style="width:250px;" >
        <p><strong>HawkStore TP.HCM:</strong> 456 Quận 1, TP. Hồ Chí Minh</p>
    </div>
</div>

</body>
</html>
