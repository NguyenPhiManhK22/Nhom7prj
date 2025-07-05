<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.DonHang" %>

<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Sửa Đơn Hàng</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
    
</head>
<body>

<div class="container cart-container">
    <h2 class="cart-header">Sửa Đơn Hàng</h2>

    <%
        DonHang donHang = (DonHang) request.getAttribute("donHang");

        if (donHang == null) {
    %>
        <p style="color:red;">Không tìm thấy đơn hàng!</p>
    <%
        } else {
    %>

    <form action="<%= request.getContextPath() %>/admin/orders/edit" method="post">
        <input type="hidden" name="id" value="<%= donHang.getMaDonHang() %>" />

        <table class="cart-table">
            <tr>
                <td><label for="trangThai">Trạng thái:</label></td>
                <td>
                    <select name="trangThai" id="trangThai">
                        <option value="cho_xu_ly" <%= donHang.getTrangThai().equals("cho_xu_ly") ? "selected" : "" %>>Chờ xử lý</option>
                        <option value="dang_van_chuyen" <%= donHang.getTrangThai().equals("dang_van_chuyen") ? "selected" : "" %>>Đang vận chuyển</option>
                        <option value="da_giao" <%= donHang.getTrangThai().equals("da_giao") ? "selected" : "" %>>Đã giao</option>
                        <option value="da_huy" <%= donHang.getTrangThai().equals("da_huy") ? "selected" : "" %>>Đã hủy</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td><label for="tongTien">Tổng tiền:</label></td>
                <td>
                     <input type="hidden" name="tongTien" id="tongTienHidden" value="<%= donHang.getTongTien() %>" />
					 <p><strong>Tổng tiền:</strong> <%= String.format("%,.0f", donHang.getTongTien()) %> VNĐ</p>
                </td>
            </tr>

            <tr>
                <td colspan="2" >
                    <button type="submit">Cập nhật</button>
                    <a href="<%= request.getContextPath() %>/admin/orders" class="btn btn-primary">Quay lại</a>
                </td>
            </tr>
        </table>
    </form>

    <%
        }
    %>
</div>

</body>
</html>
