<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.SanPham" %>
<%@ page import="dao.SanPhamDAO" %>

<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Thêm Sản Phẩm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminStyle.css" />
</head>
<body>
    <div class="container">
        <h1>Thêm Sản Phẩm Mới</h1>
       			<form action="addProduct" method="POST">
    <label for="tenSanPham">Tên sản phẩm:</label>
    <input type="text" id="tenSanPham" name="tenSanPham" required /><br />
    
    <label for="gia">Giá:</label>
    <input type="text" id="gia" name="gia" required /><br />
    
    <label for="moTa">Mô tả:</label>
    <textarea id="moTa" name="moTa" required></textarea><br />
    
    <label for="soLuong">Số lượng trong kho:</label>
    <input type="number" id="soLuong" name="soLuong" required /><br />
    
    <label for="maDanhMuc">Danh mục:</label>
    <select name="maDanhMuc" id="maDanhMuc">
        <option value="1">Điện thoại</option>
        <option value="2">Laptop</option>
        <!-- Các danh mục khác -->
    </select><br />

    <label for="duongDanAnh">Đường dẫn ảnh:</label>
    <input type="text" id="duongDanAnh" name="duongDanAnh" required /><br />
    
    <button type="submit">Thêm sản phẩm</button>
</form>
			<div class="back-to-dashboard">
        <a href="<%= request.getContextPath() %>/admin/dashboard" class="btn btn-secondary">Quay lại </a>
    </div>
    </div>
    
</body>
</html>
