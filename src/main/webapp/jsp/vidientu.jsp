<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.SanPham" %>
<%@ page import="model.NguoiDung" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Thanh Toán Ví Điện Tử</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vidientu.css" />
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
   <div class="payment-container">
        <h2>Thanh Toán Ví Điện Tử</h2>
        <p>Vui lòng nhập thông tin thẻ của bạn để hoàn tất thanh toán:</p>
        <form action="vidientuThanhToan" method="post">
            <label for="soThe">Số Thẻ:</label>
            <input type="text" id="soThe" name="soThe" required /><br />
            <label for="ngayHetHan">Ngày Hết Hạn:</label>
            <input type="month" id="ngayHetHan" name="ngayHetHan" required /><br />
            <label for="cvv">CVV:</label>
            <input type="text" id="cvv" name="cvv" required /><br />           
        </form>
        		<a href="thanhtoanthanhcong.jsp">
    			<button type="submit">Thanh toán</button>
			</a>
        
        <a href="index">Quay lại trang chủ</a>
    </div>
</body>
</html>