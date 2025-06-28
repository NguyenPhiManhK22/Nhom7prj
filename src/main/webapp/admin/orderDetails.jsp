<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.DonHangDAO" %>
<%@ page import="model.DonHang" %>
<%@ page import="model.SanPham" %>
<%@ page import="java.util.List" %>
<%
    // Lấy mã đơn hàng từ tham số
    int maDonHang = Integer.parseInt(request.getParameter("id"));
    
    // Lấy thông tin đơn hàng
    DonHangDAO donHangDAO = new DonHangDAO();
    DonHang donHang = donHangDAO.getDonHangById(maDonHang);
    
    // Lấy các sản phẩm trong đơn hàng
    List<SanPham> products = donHangDAO.getProductsByOrderId(maDonHang);
%>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Chi Tiết Đơn Hàng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/orderDetail.css" />
</head>
<body>

<div class="container">
    <h2>Chi Tiết Đơn Hàng #<%= donHang.getMaDonHang() %></h2>

    <div class="order-info">
        <h3>Thông Tin Đơn Hàng</h3>
        <p><strong>Mã Người Dùng:</strong> <%= donHang.getMaNguoiDung() %></p>
        <p><strong>Tổng Tiền:</strong> <%= String.format("%,.0f", donHang.getTongTien()) %> VNĐ</p>
        <p><strong>Trạng Thái:</strong> <%= donHang.getTrangThai() %></p>
    </div>

    <h3>Sản Phẩm Trong Đơn Hàng</h3>
    <table>
        <thead>
            <tr>
                <th>Tên Sản Phẩm</th>
                <th>Số Lượng</th>
                <th>Giá</th>
                <th>Tổng</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (SanPham product : products) {
            %>
            <tr>
                <td><%= product.getTenSanPham() %></td>
                <td><%= product.getSoLuongTrongKho() %></td>
                <td><%= String.format("%,.0f", product.getGia()) %> VNĐ</td>
                <td><%= String.format("%,.0f", product.getGia() * product.getSoLuongTrongKho()) %> VNĐ</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <a href="<%= request.getContextPath() %>/admin/orders" class="btn btn-primary">Quay lại </a>
</div>

</body>
</html>
