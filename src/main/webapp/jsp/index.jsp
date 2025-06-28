<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.SanPham" %>
<%@ page import="model.NguoiDung" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>TechShop - Trang chủ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
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
            <a href="hethongcuahang"><i class="fas fa-map-marker-alt"></i><span>Hệ thống cửa hàng</span></a>

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

            <a href="giohang"><i class="fas fa-shopping-cart"></i><span>Giỏ hàng</span></a>
        </div>
    </div>
</header>

<nav class="main-nav">
    <ul>
        <li><a href="index"><i class="fa fa-home"></i>TRANG CHỦ</a></li>
        <li><a href="sanpham">SẢN PHẨM</a></li>
        <li><a href="#"> TIN CÔNG NGHỆ <i class="fas fa-bolt"></i></a></li>
        <li><a href="#">ĐƠN HÀNG</a></li>
    </ul>
</nav>

<div class="container">
    <h1 >Chào mừng đến với TechShop</h1>
    <h3>Khám phá các sản phẩm công nghệ mới nhất từ điện thoại, laptop đến phụ kiện hiện đại!</h3>
</div>

<div class="products-wrapper">
    <%
        List<SanPham> list = (List<SanPham>) request.getAttribute("listSanPham");
        if (list != null && !list.isEmpty()) {
            for (SanPham sp : list) {
    %>
    <div class="product-card">
        <img src="<%=request.getContextPath() + "/" + sp.getDuongDanAnh()%>" alt="<%=sp.getTenSanPham()%>" />
        <h3><%=sp.getTenSanPham()%></h3>
        <p><%=sp.getMoTa()%></p>
        <a href="sanpham?id=<%=sp.getMaSanPham()%>" class="btn">Xem Chi Tiết</a>
    </div>
    <%
            }
        } else {
    %>
    <p>Không có sản phẩm nào</p>
    <%
        }
    %>
    
    <div class="product-card">
    	<img src="images/dell.jpg" alt="Điện thoại B">
    	<h3>Điện thoại Iphone</h3>
    	<p>Phone là dòng điện thoại thông minh được phát triển bởi Apple Inc.,một trong những thương hiệu công nghệ hàng đầu thế giới.Ra mắt lần đầu vào năm 2007,iPhone đã cách mạng hóa ngành công nghiệp điện thoại di động với thiết kế màn hình cảm ứng đa điểm và khả năng tích hợp các tính năng của iPod và internet communicator.Sau đó,iPhone đã không ngừng đổi mới các tính năng.</p>
    	<a href="sanpham" class="btn">Xem Chi Tiết</a>
	</div>
    
</div>

<footer>
   <p> &copy; 2025 Website Bán Sản Phẩm Công Nghệ. All rights reserved.</p>
</footer>

</body>
</html>
