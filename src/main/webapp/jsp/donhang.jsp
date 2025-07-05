<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.DonHang" %>
<%@ page import="model.NguoiDung" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đơn hàng của tôi</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
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
<div class="cart-container">
    <div class="cart-header">Đơn hàng của tôi</div>

    <%
        List<DonHang> list = (List<DonHang>) request.getAttribute("donhangList");
        if (list != null && !list.isEmpty()) {
    %>
    <table class="cart-table">
        <tr>
            <th>Mã đơn hàng</th>
            <th>Ngày tạo</th>
            <th>Tổng tiền</th>
            <th>Trạng thái</th>
            <th>Chi tiết</th>
        </tr>
        <% for (DonHang dh : list) { %>
        <tr>
            <td><%= dh.getMaDonHang() %></td>
            <td><%= dh.getNgayTao() %></td>
            <td><%= String.format("%,.0f", dh.getTongTien()) %> vnđ</td>
            <td>
			    <%  String trangThai = dh.getTrangThai();
        			String hienThiTrangThai = "";
        			if ("dang_van_chuyen".equals(trangThai)) {
            			hienThiTrangThai = "Đang vận chuyển";
        			} else if ("cho_xu_ly".equals(trangThai)) {
            			hienThiTrangThai = "Chờ xử lý";
        			} else if ("da_giao".equals(trangThai)) {
            			hienThiTrangThai = "Đã giao";
        			} else if ("da_huy".equals(trangThai)) {
           				hienThiTrangThai = "Đã huỷ";
        			} else {
            			hienThiTrangThai = "Không xác định";
        			}
   				 %>
    				<%= hienThiTrangThai %>
</td>
            <td>
            <a href="chitietdonhang?maDonHang=<%= dh.getMaDonHang() %>">Xem</a> 
        </td>
        </tr>
        <% } %>
    </table>
    <% } else { %>
        <p>Chưa có đơn hàng nào.</p>
    <% } %>
</div>
</body>
</html>
