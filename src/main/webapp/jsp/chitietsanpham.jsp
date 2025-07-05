<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.SanPham" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Chi Tiết Sản Phẩm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styl.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product-detail.css" />
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
            <a href="login.jsp"><i class="fas fa-user"></i><span>Đăng nhập</span></a>
            <a href="giohang.jsp"><i class="fas fa-shopping-cart"></i><span>Giỏ hàng</span></a>
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
<%
    SanPham sp = (SanPham) request.getAttribute("sanPham");
    if(sp == null) {
%>
    <p style="color:red; padding: 20px;">Không tìm thấy sản phẩm.</p>
<%
    } else {
%>
    <div class="product-detail">
        <img src="<%=request.getContextPath() + "/" + sp.getDuongDanAnh()%>" alt="<%=sp.getTenSanPham()%>" />
        <div class="product-info">
            <h2><%=sp.getTenSanPham()%></h2>
            <p><strong>Giá:</strong> <%=String.format("%,.0f", sp.getGia())%> VNĐ</p>
            <p><strong>Mô tả:</strong> <%=sp.getMoTa()%></p>
            <p><strong>Số lượng trong kho:</strong> <%=sp.getSoLuongTrongKho()%></p>
            <!-- Thêm các thông tin khác nếu cần -->
        </div>
    </div>
<%
    }
%>
</body>
</html>
