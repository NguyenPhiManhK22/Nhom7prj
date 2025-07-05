<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.ChiTietDonHang" %>
<%@ page import="model.NguoiDung" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết đơn hàng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
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

<div class="cart-container">
    <div class="cart-header">Chi tiết đơn hàng <%= request.getAttribute("maDonHang") %></div>

<%
    List<ChiTietDonHang> list = (List<ChiTietDonHang>) request.getAttribute("chiTietList");
    if (list != null && !list.isEmpty()) {
%>
    <table class="cart-table">
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá bán</th>
        </tr>
        <% for (ChiTietDonHang ct : list) { %>
        <tr>
            <td><%= ct.getMaSanPham() %></td>
            <td><%= ct.getTenSanPham() %></td>
            <td><%= ct.getSoLuong() %></td>
            <td><%= String.format("%,.0f", ct.getGiaBan()) %> đ</td>
        </tr>
        <% } %>
    </table>
<% } else { %>
    <p>Không có sản phẩm nào trong đơn hàng này.</p>
<% } %>

<a href="<%= request.getContextPath() %>/donhang">← Quay lại đơn hàng</a>
</div>
</body>
</html>
