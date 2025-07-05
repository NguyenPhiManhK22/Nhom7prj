<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.SanPham" %>
<%@ page import="dao.SanPhamDAO" %>
<%@ page import="model.NguoiDung" %>

<%
    String keyword = request.getParameter("keyword");
    List<SanPham> ketQua = null;
    if (keyword != null && !keyword.trim().isEmpty()) {
        SanPhamDAO dao = new SanPhamDAO();
        ketQua = dao.timKiemSanPham(keyword);
    }
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm kiếm</title>
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
            <form action="timkiem" method="get">
                <input type="text" name="keyword" placeholder="Bạn đang tìm kiếm sản phẩm công nghệ gì..." />
                <button type="submit"><i class="fas fa-search"></i></button>
            </form>
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
        <li><a href="tintuc">TIN CÔNG NGHỆ</a></li>
        <li><a href="donhang">ĐƠN HÀNG</a></li>
    </ul>
</nav>

<div class="container">
    <h2>Kết quả tìm kiếm cho từ khóa: <%= keyword != null ? keyword : "" %></h2>

    <%
        if (ketQua != null && !ketQua.isEmpty()) {
            for (SanPham sp : ketQua) {
    %>
        <div class="product-item">
            <img src="../images<%= sp.getDuongDanAnh() %>" alt="<%= sp.getTenSanPham() %>" style="width: 200px;">
            <h3><%= sp.getTenSanPham() %></h3>
            <p><%= String.format("%,.0f", sp.getGia()) %> VNĐ</p>
        </div>
    <%
            }
        } else {
    %>
        <p>Không tìm thấy sản phẩm nào phù hợp.</p>
    <%
        }
    %>
</div>

</body>
</html>