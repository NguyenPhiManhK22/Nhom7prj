<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.SanPham" %>
<%@ page import="model.NguoiDung" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Thanh Toán Chuyển Khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/chuyenkhoan.css" />
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

            <a href="<%= request.getContextPath() %>/giohang"><i class="fas fa-shopping-cart"></i><span>Giỏ hàng</span></a>><i class="fas fa-shopping-cart"></i><span>Giỏ hàng</span></a>
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
        <h2>Thanh Toán Chuyển Khoản</h2>
        <p>Vui lòng quét mã QR dưới đây để thực hiện thanh toán chuyển khoản:</p>
        <img src="${pageContext.request.contextPath}/images/qr_code.png" alt="QR Code for Transfer" />
        <p><strong>Thông tin tài khoản ngân hàng:</strong><br />
        Ngân hàng MBBANK, Số tài khoản: 313160804</p>
        
        <div class="payment-actions">
            <!-- Nút Hoàn Thành Thanh Toán -->
            <a href="thanhtoanthanhcong.jsp">
    			<button type="submit">Thanh toán</button>
			</a>
            
            <!-- Nút Quay lại trang chủ -->
            <a href="<%= request.getContextPath() %>/index" class="btn-back-home">Quay lại trang chủ</a>
        </div>
    </div>
</body>
</html>
