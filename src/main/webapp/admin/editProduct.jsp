<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.SanPham" %>
<%@ page import="dao.SanPhamDAO" %>
<%@ page import="java.util.List" %>

<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Cập Nhật Sản Phẩm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminStyle.css" />
</head>
<body>
    <div class="container">
        <h1>Cập Nhật Sản Phẩm</h1>

        <%
            // Lấy ID sản phẩm từ URL
            int maSanPham = Integer.parseInt(request.getParameter("id"));
            
            // Lấy sản phẩm theo ID từ DAO
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            SanPham product = sanPhamDAO.getSanPhamById(maSanPham);

            if (product != null) {
        %>
        <form action="updateProduct" method="POST">
            <input type="hidden" name="maSanPham" value="<%= product.getMaSanPham() %>" />

            <label for="tenSanPham">Tên sản phẩm:</label>
            <input type="text" id="tenSanPham" name="tenSanPham" value="<%= product.getTenSanPham() %>" required /><br />

            <label for="gia">Giá:</label>
            <input type="number" id="gia" name="gia" value="<%= product.getGia() %>" required /><br />

            <label for="moTa">Mô tả:</label>
            <textarea id="moTa" name="moTa" required><%= product.getMoTa() %></textarea><br />

            <label for="soLuong">Số lượng trong kho:</label>
            <input type="number" id="soLuong" name="soLuong" value="<%= product.getSoLuongTrongKho() %>" required /><br />

            <label for="duongDanAnh">Đường dẫn ảnh:</label>
            <input type="text" id="duongDanAnh" name="duongDanAnh" value="<%= product.getDuongDanAnh() %>" required /><br />

            <label for="maDanhMuc">Danh mục:</label>
            <select name="maDanhMuc" id="maDanhMuc">
                <option value="1" <%= product.getMaDanhMuc() == 1 ? "selected" : "" %>>Điện thoại</option>
                <option value="2" <%= product.getMaDanhMuc() == 2 ? "selected" : "" %>>Laptop</option>
                <!-- Thêm các danh mục khác nếu có -->
            </select><br />

            <button type="submit">Cập nhật sản phẩm</button>
        </form>

        <%
            } else {
        %>
            <p>Sản phẩm không tồn tại.</p>
        <%
            }
        %>

        <div class="back-btn">
            <a href="admin/products" class="btn btn-secondary">Quay lại trang quản lý sản phẩm</a>
        </div>
    </div>
</body>
</html>
