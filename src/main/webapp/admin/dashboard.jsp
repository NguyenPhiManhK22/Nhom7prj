<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.NguoiDung" %>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Trang Quản Trị - Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminStyle.css" />
</head>
<body>

<header class="top-header">
    <div class="header-container">
        <div class="logo">
            <a href="dashboard"><img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo" /></a>
        </div>

        <div class="header-icons">
            

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

            
        </div>
    </div>
</header>



<div class="dashboard-container">
    <h1>Chào mừng đến với Trang Quản Trị</h1>

    <div class="dashboard-stats">
        <div class="stat-item">
            <h3>Tổng Sản Phẩm</h3>
            <p><%= request.getAttribute("totalProducts") %></p>
        </div>
        <div class="stat-item">
            <h3>Tổng Đơn Hàng</h3>
            <p><%= request.getAttribute("totalOrders") %></p>
        </div>
        <div class="stat-item">
            <h3>Tổng Người Dùng</h3>
            <p><%= request.getAttribute("totalUsers") %></p>
        </div>
    </div>

    <div class="actions">
        <a href="products" class="btn btn-primary">Quản lý Sản Phẩm</a>
        <a href="orders" class="btn btn-primary">Quản lý Đơn Hàng</a>
        <a href="users" class="btn btn-primary">Quản lý Người Dùng</a>
    </div>
</div>

</body>
</html>