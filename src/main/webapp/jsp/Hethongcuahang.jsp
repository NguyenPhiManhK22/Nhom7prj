<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hệ thống cửa hàng</title>
    <link rel="stylesheet" href="../css/hethongcuahang.css">
    <link rel="stylesheet" href="../css/styl.css">
</head>
<body>
    <header class="top-header">
        <div class="header-container">
            <div class="logo">
                <img src="../images/logo.png" alt="Logo" />
            </div>

            <div class="search-bar">
                <input type="text" placeholder="Bạn đang tìm kiếm sản phẩm công nghệ gì..." />
                <button><i class="fas fa-search"></i></button>
            </div>

            <div class="header-icons">
                <a href="hethongcuahang"><i class="fas fa-map-marker-alt"></i><span>Hệ thống cửa hàng</span></a>
                <a href="login.jsp"><i class="fas fa-user"></i><span>Đăng nhập</span></a>
                <a href="giohang.jsp"><i class="fas fa-shopping-cart"></i><span>Giỏ hàng</span></a>
            </div>
        </div>
    </header>

    <nav class="main-nav">
        <ul>
            <li><a href="index"><i class="fa fa-home"></i>TRANG CHỦ</a></li>  
            <li><a href="sanpham">SẢN PHẨM</a></li>    
            <li><a href="#">KHUYẾN MÃI<i class="fas fa-bolt"></i></a></li>     
            <li><a href="#">TIN CÔNG NGHỆ</a></li>
        </ul>
    </nav>

    <div class="store-container">
        <h1>Hệ thống cửa hàng Teach </h1>

        <div class="store">
            <h2>Chi nhánh Hà Nội</h2>
            <p><strong>Địa chỉ:</strong> 123 Cầu Giấy, Quận Cầu Giấy, Hà Nội</p>
            <p><strong>Điện thoại:</strong> 024-1234-5678</p>
            <p><strong>Giờ mở cửa:</strong> 8h00 - 21h00 (Thứ 2 - Chủ nhật)</p>
            <div class="store-image">
                <img src="../images/cn-hanoi.jpg" alt="Chi nhánh Hà Nội">
                <a href="https://cellphones.com.vn/dia-chi-cua-hang/ha-noi" target="_blank" class="store-link">Xem cửa hàng</a>
            </div>
        </div>s

        <div class="store">
            <h2>Chi nhánh TP.HCM</h2>
            <p><strong>Địa chỉ:</strong> 456 Nguyễn Trãi, Quận 5, TP. HCM</p>
            <p><strong>Điện thoại:</strong> 028-9876-5432</p>
            <p><strong>Giờ mở cửa:</strong> 8h00 - 21h00 (Thứ 2 - Chủ nhật)</p>
            <div class="store-image">
                <img src="../images/cn-hcm.jpg" alt="Chi nhánh TP.HCM">
                <a href="https://goo.gl/maps/YYYYYY" target="_blank" class="store-link">Xem cửa hàng</a>
            </div>
        </div>
    </div>
</body>
</html>
