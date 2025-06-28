<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.GioHangDAO" %>
<%@ page import="model.GioHang" %>
<%@ page import="dao.SanPhamDAO" %>
<%@ page import="model.SanPham" %>
<%@ page import="model.NguoiDung" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Giỏ Hàng - Thanh Toán</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/giohang.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body>

<!-- Header -->
<header class="top-header">
    <div class="header-container">
        <div class="logo">
            <a href="index"><img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo" /></a>
        </div>

        <div class="search-bar">
            <input type="text" placeholder="Bạn đang tìm kiếm sản phẩm công nghệ gì..." />
            <button><i class="fas fa-search"></i></button>
        </div>

        <div class="header-icons">
            <a href="hethongcuahang"><i class="fas fa-map-marker-alt"></i><span>Hệ thống cửa hàng</span></a>

            <% 
                session = request.getSession(false); // Không tạo session mới
                NguoiDung userLogin = null;
                if (session != null) {
                    userLogin = (NguoiDung) session.getAttribute("userLogin");
                }

                if (userLogin != null) {
            %>
                <!-- Nếu người dùng đã đăng nhập -->
                <span style="color: white; margin-right: 12px;">Xin chào, <%= userLogin.getHoTen() %>!</span>
                <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
            <%
                } else {
            %>
                <!-- Nếu người dùng chưa đăng nhập -->
                <a href="login"><i class="fas fa-user"></i><span>Đăng nhập</span></a>
            <%
                }
            %>

            <!-- Giỏ hàng -->
            <a href="giohang"><i class="fas fa-shopping-cart"></i><span>Giỏ hàng</span></a>
        </div>
    </div>
</header>

<!-- Navigation -->
<nav class="main-nav">
    <ul>
        <li><a href="index"><i class="fa fa-home"></i>TRANG CHỦ</a></li>
        <li><a href="sanpham">SẢN PHẨM</a></li>
        <li><a href="#"> TIN CÔNG NGHỆ <i class="fas fa-bolt"></i></a></li>
        <li><a href="#"> ĐƠN HÀNG </a></li>
        
    </ul>
</nav>

<!-- Giỏ hàng thanh toán -->
<div class="cart-container">
    <h2 class="cart-header">Giỏ Hàng Của Bạn - Thanh Toán</h2>

    <%
        if (userLogin == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        GioHangDAO gioHangDAO = new GioHangDAO();
        List<GioHang> cart = gioHangDAO.getCartByUser(userLogin.getMaNguoiDung());

        if (cart != null && !cart.isEmpty()) {
    %>

    <table class="cart-table">
        <tr>
            <th>Sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá</th>
            <th>Tổng</th>
        </tr>

        <%
            double total = 0;
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            for (GioHang item : cart) {
                SanPham sanPham = sanPhamDAO.getSanPhamById(item.getMaSanPham());
                if (sanPham != null) {
                    double totalPrice = sanPham.getGia() * item.getSoLuong();
                    total += totalPrice;
        %>
        <tr>
            <td><%= sanPham.getTenSanPham() %></td>
            <td><%= item.getSoLuong() %></td>
            <td><%= String.format("%,.0f", sanPham.getGia()) %> VNĐ</td>
            <td><%= String.format("%,.0f", totalPrice) %> VNĐ</td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <p>Tổng cộng: <%= String.format("%,.0f", total) %> VNĐ</p>

<form action="thanhtoan" method="post">
    <label for="phuongThucThanhToan">Chọn phương thức thanh toán:</label>
    <select name="phuongThucThanhToan" id="phuongThucThanhToan">
        <option value="tien_mat">Tiền mặt</option>
        <option value="chuyen_khoan">Chuyển khoản</option>
        <option value="vi_dien_tu">Ví điện tử</option>
    </select>

    <button type="submit">Xác nhận thanh toán</button>
</form>

    <% } else { %>
        <p>Giỏ hàng của bạn trống.</p>
    <% } %>

</div>

</body>
</html>
