<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.SanPham" %>
<%@ page import="model.NguoiDung" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>HawkStore</title>
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
    		<form action="jsp/timkiem.jsp" method="get">
        		<input type="text" name="keyword" placeholder="Bạn đang tìm kiếm sản phẩm công nghệ gì..." required />
        		<button type="submit"><i class="fas fa-search"></i></button>
    		</form>
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

            <a href="giohang"><i class="fas fa-shopping-cart"></i><span>Giỏ hàng</span></a>
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

<div class="container">
    <h1 >Chào mừng đến với HawkStore</h1>
    <h3>Khám phá các sản phẩm công nghệ mới nhất từ điện thoại, laptop đến phụ kiện hiện đại!</h3>
</div>

<div class="products-wrapper">
    <div class="product-card">
    	<img src="images/laptop1.jpg" alt="Macbook">
    	<h3>Macbook</h3>
    	<p>MacBook là dòng máy tính xách tay Macintosh được Apple Inc. thiết kế, sản xuất và bán từ tháng 5 năm 2006 đến tháng 2 năm 2012.Đồng thời MacBook là dòng laptop rất nổi tiếng và hầu như ai cũng biết đến bởi thiết kế đẹp, hiệu năng cao và sử dụng hệ điều hành macOS mượt mà. Những chiếc MacBook khá nhẹ và mỏng, điều này khiến người dùng cảm thấy yên tâm hơn khi sử dụng sản phẩm. Bạn có thể dễ dàng mang theo mà không cảm thấy quá nặng</p>
    	<a href="sanpham" class="btn">Xem Chi Tiết</a>
	</div>
    
    <div class="product-card">
    	<img src="images/asus.jpg" alt="Asus">
    	<h3>Laptop Asus</h3>
    	<p>ASUS là một thương hiệu máy tính nổi tiếng của Đài Loan, được thành lập vào năm 1989.Asus cũng là một thương hiệu uy tín,sản phẩm luôn chất lượng và các dòng sản phẩm điều dựa trên nhu cầu thực tế của người dùng.Đây là một trong những thương hiệu laptop đáng tin cậy và đáng mua nhất hiện nay.Các dòng sản phẩm laptop Asus thích hợp với các bạn trẻ như học sinh,sinh viên hoặc nhân viên văn phòng nhất bởi sự thiết kế năng động trẻ trung,hoạt bát và năng động.</p>
    	<a href="sanpham" class="btn">Xem Chi Tiết</a>
	</div>
	
	<div class="product-card">
    	<img src="images/lenovo.jpg" alt="lenovo">
    	<h3>Laptop lenovo</h3>
    	<p>Lenovo là một trong những thương hiệu máy tính lớn nhất thế giới, có trụ sở chính tại Bắc Kinh (Trung Quốc) và Morrisville (Hoa Kỳ). Được thành lập vào năm 1984, Lenovo đã trở thành một tập đoàn công nghệ toàn cầu nổi tiếng, đặc biệt sau khi mua lại bộ phận máy tính cá nhân của IBM năm 2005 (bao gồm cả dòng ThinkPad).
			Máy tính Lenovo được đánh giá cao nhờ độ bền bỉ, hiệu năng ổn định và thiết kế đa dạng, đáp ứng nhiều nhu cầu sử dụng từ học tập, văn phòng cho đến chơi game và thiết kế đồ họa. Các dòng sản phẩm nổi bật như ThinkPad, IdeaPad, Legion và Yoga đều mang đến những trải nghiệm khác nhau, phù hợp cho từng đối tượng người dùng. Lenovo luôn không ngừng đổi mới công nghệ, tích hợp nhiều tính năng hiện đại như màn hình cảm ứng, pin lâu, tản nhiệt hiệu quả và bảo mật nâng cao, giúp người dùng yên tâm trong công việc và giải trí.</p>
    	<a href="sanpham" class="btn">Xem Chi Tiết</a>
	</div>
	
	<div class="product-card">
    	<img src="images/delll.jpg" alt="dell">
    	<h3>Laptop Dell</h3>
    	<p>Dell là một tập đoàn công nghệ đa quốc gia có trụ sở tại Round Rock, Texas, Hoa Kỳ, được thành lập vào năm 1984 bởi Michael Dell. Với hơn 30 năm phát triển, Dell đã trở thành một trong những nhà sản xuất máy tính cá nhân lớn nhất thế giới, nổi bật với chất lượng sản phẩm cao, độ bền tốt và dịch vụ hậu mãi đáng tin cậy.
			Máy tính Dell được ưa chuộng nhờ thiết kế chắc chắn, hiệu năng ổn định và phân khúc sản phẩm đa dạng, đáp ứng nhiều nhu cầu từ cá nhân đến doanh nghiệp, từ phổ thông đến chuyên nghiệp. </p>
    	<a href="sanpham" class="btn">Xem Chi Tiết</a>
    </div>
    
	<div class="product-card">
    	<img src="images/dt iphone.jpg" alt="Iphone">
    	<h3>iPhone</h3>
    	<p>iPhone là dòng điện thoại thông minh cao cấp do Apple Inc. (Hoa Kỳ) phát triển và sản xuất. Kể từ khi ra mắt lần đầu vào năm 2007, iPhone đã mở ra kỷ nguyên mới cho ngành công nghệ di động, với thiết kế tinh tế, giao diện cảm ứng trực quan và hiệu năng vượt trội.
			iPhone nổi bật nhờ sự kết hợp chặt chẽ giữa phần cứng và phần mềm, sử dụng hệ điều hành iOS độc quyền, mang lại trải nghiệm mượt mà, ổn định và bảo mật cao. Với mỗi phiên bản mới, Apple đều nâng cấp mạnh về hiệu suất, camera, màn hình và thời lượng pin, khiến iPhone trở thành lựa chọn hàng đầu cho cả người dùng phổ thông và chuyên nghiệp.</p>
    	<a href="sanpham" class="btn">Xem Chi Tiết</a>    	
	</div>
	
	<div class="product-card">
    	<img src="images/samsung.jpg" alt="samsung">
    	<h3>SamSung</h3>
    	<p>Samsung là một tập đoàn công nghệ hàng đầu thế giới có trụ sở tại Hàn Quốc, được thành lập vào năm 1938. Trong lĩnh vực điện thoại di động, Samsung là nhà sản xuất smartphone lớn nhất thế giới tính theo thị phần trong nhiều năm liền. Hãng nổi bật với việc không ngừng đổi mới thiết kế, công nghệ và trải nghiệm người dùng.
			Dòng điện thoại Samsung sử dụng hệ điều hành Android (tùy biến với giao diện One UI riêng của Samsung), được đánh giá cao về sự thân thiện, hiện đại và khả năng tùy biến linh hoạt. Với nhiều phân khúc từ giá rẻ đến cao cấp, Samsung đáp ứng hầu hết mọi nhu cầu của người dùng.</p>
    	<a href="sanpham" class="btn">Xem Chi Tiết</a>    	
	</div>
	
	<div class="product-card">
    	<img src="images/oppo.jpg" alt="oppo">
    	<h3>OPPO</h3>
    	<p>OPPO là một thương hiệu công nghệ đến từ Trung Quốc, thuộc tập đoàn BBK Electronics (cùng "nhà" với vivo, realme, OnePlus). Ra mắt lần đầu vào năm 2004, OPPO hiện đã trở thành một trong những hãng sản xuất smartphone lớn nhất thế giới, đặc biệt nổi bật ở khu vực châu Á, trong đó có Việt Nam.
			OPPO nổi tiếng nhờ thiết kế thời trang, camera chụp ảnh đẹp, và tập trung mạnh vào trải nghiệm người dùng. Trong những năm gần đây, hãng cũng đẩy mạnh các công nghệ tiên tiến như sạc siêu nhanh VOOC, màn hình tràn viền, camera ẩn dưới màn hình, và cả AI xử lý hình ảnh</p>
    	<a href="sanpham" class="btn">Xem Chi Tiết</a>    	
	</div>
	
	
	
	
	
	
</div>

<footer>
   <p> &copy; 2025 Website Bán Sản Phẩm Công Nghệ. All rights reserved.</p>
</footer>

</body>
</html>
