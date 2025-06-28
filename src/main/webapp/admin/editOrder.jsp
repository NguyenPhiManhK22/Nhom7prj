<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.DonHang" %>
<%@ page import="dao.DonHangDAO" %>

<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Sửa Đơn Hàng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/orderDetail.css" />
</head>
<body>

<div class="container">
    <h2>Sửa Đơn Hàng</h2>

    <%
        // Lấy đối tượng donHang từ request
        DonHang donHang = (DonHang) request.getAttribute("donHang");

        // Kiểm tra nếu donHang là null, in thông báo lỗi
        if (donHang == null) {
            out.print("Không tìm thấy đơn hàng!");
        } else {
    %>

    <form action="edit" method="post">
        <input type="hidden" name="id" value="<%= donHang.getMaDonHang() %>" />

        <div>
            <label for="trangThai">Trạng thái:</label>
            <select name="trangThai" id="trangThai">
                <option value="cho_xu_ly" <%= donHang.getTrangThai().equals("cho_xu_ly") ? "selected" : "" %>>Chờ xử lý</option>
                <option value="dang_van_chuyen" <%= donHang.getTrangThai().equals("dang_van_chuyen") ? "selected" : "" %>>Đang vận chuyển</option>
                <option value="da_giao" <%= donHang.getTrangThai().equals("da_giao") ? "selected" : "" %>>Đã giao</option>
                <option value="da_huy" <%= donHang.getTrangThai().equals("da_huy") ? "selected" : "" %>>Đã hủy</option>
            </select>
        </div>

        <div>
            <label for="tongTien">Tổng tiền:</label>
            <input type="text" name="tongTien" id="tongTien" value="<%= donHang.getTongTien() %>" />
        </div>

        <div>
            <button type="submit">Cập nhật</button>
            <a href="<%= request.getContextPath() %>/admin/orders">Quay lại</a>
        </div>
    </form>

    <%
        }
    %>

</div>

</body>
</html>
