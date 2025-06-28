<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.GioHangDAO" %>
<%@ page import="model.GioHang" %>
<%@ page import="model.NguoiDung" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.SanPhamDAO" %>
<%@ page import="model.SanPham" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Giỏ Hàng</title>
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
            <!-- Hệ thống cửa hàng -->
            <a href="hethongcuahang"><i class="fas fa-map-marker-alt"></i><span>Hệ thống cửa hàng</span></a>

            <% 
                // Lấy session và kiểm tra nếu người dùng đã đăng nhập
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

<!-- Giỏ hàng -->
<div class="cart-container">
    <h2 class="cart-header">Giỏ Hàng Của Bạn</h2>

    <%
        // Kiểm tra và lấy giỏ hàng của người dùng
        if (userLogin == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return; // Dừng thực thi nếu người dùng chưa đăng nhập
        }

        // Lấy giỏ hàng của người dùng từ cơ sở dữ liệu
        GioHangDAO gioHangDAO = new GioHangDAO();
        List<GioHang> cart = gioHangDAO.getCartByUser(userLogin.getMaNguoiDung());

        if (cart != null && !cart.isEmpty()) {
    %>

    <form action="updateCart" method="post">
    <table class="cart-table">
        <tr>
            <th>Sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá</th>
            <th>Tổng</th>
            <th>Thao tác</th>
        </tr>

        <%
            double total = 0; // Tổng giá trị giỏ hàng
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            for (GioHang item : cart) {
                SanPham sanPham = sanPhamDAO.getSanPhamById(item.getMaSanPham());
                if (sanPham != null) {
                    // Tính tổng giá trị của từng sản phẩm trong giỏ
                    double totalPrice = sanPham.getGia() * item.getSoLuong();
                    total += totalPrice;
        %>
        <tr>
            <td><%= sanPham.getTenSanPham() %></td>
            <td>
                <input type="number" name="soLuong_<%= item.getMaSanPham() %>" value="<%= item.getSoLuong() %>" min="1" />
            </td>
            <td><%= String.format("%,.0f", sanPham.getGia()) %> VNĐ</td>
            <td><%= String.format("%,.0f", totalPrice) %> VNĐ</td>
            <td>
            <a href="remove?maSanPham=<%= item.getMaSanPham() %>" class="remove-item"><i class="fas fa-trash-alt"></i> Xóa </a>          			 
            <button type="submit" name="update_<%= item.getMaSanPham() %>"  class="update"><i class="fas fa-sync-alt"></i> Cập nhật</button>
            </td>
        </tr>

        <%
                }
            }
        %>
        <tr>
            <td colspan="4" style="text-align: right;">Tổng cộng:</td>
            <td><%= String.format("%,.0f", total) %> VNĐ</td>
        </tr>
    </table>
    
</form>
		<form action="thanhtoan" method="post">
   			<div class="cart-actions">
     			   <button type="submit" class="btn-payment">Thanh toán</button>
    		</div>
		</form>
    <% } else { %>
        <p>Giỏ hàng của bạn trống.</p>
    <% } %>

</div>

</body>
</html>