<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.NguoiDung" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Thanh Toán Thành Công</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/thanhtoan.css" />
</head>
<header class="top-header">
    <div class="header-container">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo" />
        </div>

        <div class="search-bar">
            <input type="text" placeholder="Bạn đang tìm kiếm sản phẩm công nghệ gì..." />
            <button><i class="fas fa-search"></i></button>
        </div>

        <div class="header-icons">
            <a href="jsp/Hethongcuahang.jsp"><i class="fas fa-map-marker-alt"></i><span>Hệ thống cửa hàng</span></a>

            <%
                NguoiDung userLogin = (NguoiDung) session.getAttribute("userLogin");
                if (userLogin != null) {
            %>
                <span style="color: white; margin-right: 12px;">Xin chào, <%= userLogin.getHoTen() %>!</span>
                <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
            <%
                } else {
            %>
                <a href="login"><i class="fas fa-user"></i><span>Đăng nhập</span></a>
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
        <li><a href="jsp/tintuc.jsp"> TIN CÔNG NGHỆ <i class="fas fa-bolt"></i></a></li>
        <li><a href="<%= request.getContextPath() %>/donhang"> ĐƠN HÀNG </a></li>
    </ul>
</nav>
<body>
    <div class="payment-container">
    <h2>Cảm ơn Quý Khách</h2>
    <p>Cảm ơn bạn đã đặt mặt hàng của chúng tôi. Chúng tôi sẽ xử lý đơn hàng của bạn sớm nhất có thể.</p>
    <a href="thanhtoan.jsp">Quay lại </a>
</div>
</body>
</html>
