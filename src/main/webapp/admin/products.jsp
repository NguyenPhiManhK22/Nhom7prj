<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.SanPham" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <meta charset="UTF-8" />
    <title>Quản Lý Sản Phẩm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminStyle.css" />
</head>
<body>

<div class="container">
    <h1>Quản Lý Sản Phẩm</h1>

    <div class="add-product-btn">
        <a href="addProduct.jsp" class="btn btn-primary">Thêm Sản Phẩm</a>
    </div>

    <table class="product-table">
        <thead>
            <tr>
                <th>Mã Sản Phẩm</th>
                <th>Tên Sản Phẩm</th>
                <th>Giá</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Giả sử danh sách sản phẩm đã được truyền vào
                List<SanPham> products = (List<SanPham>) request.getAttribute("products");
                for (SanPham product : products) {
            %>
            <tr>
                <td><%= product.getMaSanPham() %></td>
                <td><%= product.getTenSanPham() %></td>
                <td><%= String.format("%,.0f", product.getGia()) %> VNĐ</td>
                <td>
                    <a href="editProduct.jsp?id=<%= product.getMaSanPham() %>" class="btn btn-warning">Sửa</a>
                    <a href="#" class="btn btn-danger" onclick="confirmDelete(<%= product.getMaSanPham() %>)">Xóa</a>
					<script type="text/javascript">
  					  function confirmDelete(productId) {
     					    var result = confirm("Bạn có chắc chắn muốn xóa sản phẩm này không?");
    				    	if (result) {
          					  window.location.href = "deleteProduct?id=" + productId;
     				  		}
  						}
					</script>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    
     <div class="back-to-dashboard">
        <a href="<%= request.getContextPath() %>/admin/dashboard" class="btn btn-secondary">Quay lại </a>
    </div>
</div>

</body>
</html>