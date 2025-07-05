<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.DonHang" %>
<%@ page import="model.NguoiDung" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Quản Lý Đơn Hàng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminStyle.css" />
</head>
<body>

<div class="container">
    <h1>Quản Lý Đơn Hàng</h1>

    <table class="order-table">
        <thead>
            <tr>
                <th>Mã Đơn Hàng</th>
                <th>Mã Người Mua</th>
                <th>Tổng Tiền</th>
                <th>Trạng Thái</th>
                <th>Ngày Tạo</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Giả sử danh sách đơn hàng đã được truyền vào
                List<DonHang> orders = (List<DonHang>) request.getAttribute("orders");
                for (DonHang order : orders) {
            %>
            <tr>
                <td><%= order.getMaDonHang() %></td>
                <td><%= order.getMaNguoiDung() %></td>
                <td><%= String.format("%,.0f", order.getTongTien()) %> VNĐ</td>
                <td><%= order.getTrangThai() %></td>
                <td><%= order.getNgayTao() %></td>
                <td>
                <a href="orderDetails.jsp?id=<%= order.getMaDonHang() %>" class="btn btn-info">Chi tiết</a>
                <a href="<%= request.getContextPath() %>/admin/orders/edit?id=<%= order.getMaDonHang() %>" class="btn btn-warning" >Sửa</a>
                
            </td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>

    </table>
     <div class="back-to-dashboard">
        <a href="<%= request.getContextPath() %>/admin/dashboard" class="btn btn-secondary">Quay lại </a>
    </div>
</div>

</body>
</html>