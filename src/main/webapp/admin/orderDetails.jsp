<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.DonHangDAO, dao.ChiTietDonHangDAO, dao.SanPhamDAO" %>
<%@ page import="model.DonHang, model.ChiTietDonHang, model.SanPham" %>
<%@ page import="java.util.List" %>

<%
    int maDonHang = Integer.parseInt(request.getParameter("id"));

    DonHangDAO donHangDAO = new DonHangDAO();
    DonHang donHang = donHangDAO.getDonHangById(maDonHang);

    ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
    List<ChiTietDonHang> listChiTiet = ctdhDAO.getChiTietByDonHang(maDonHang);

    SanPhamDAO spDAO = new SanPhamDAO();
%>

<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi Tiết Đơn Hàng</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/orderDetail.css" />
</head>
<body>

<div class="container cart-container">
    <h2 class="cart-header">Chi Tiết Đơn Hàng #<%= donHang.getMaDonHang() %></h2>

    <div class="order-info">
        <p><strong>Mã Người Dùng:</strong> <%= donHang.getMaNguoiDung() %></p>
        <p><strong>Tổng Tiền:</strong> <%= String.format("%,.0f", donHang.getTongTien()) %> VNĐ</p>
        <p><strong>Trạng Thái:</strong> <%= donHang.getTrangThai() %></p>
    </div>

    <h3>Sản Phẩm Trong Đơn Hàng</h3>
    <table class="cart-table">
        <thead>
            <tr>
                <th>Tên Sản Phẩm</th>
                <th>Số Lượng</th>
                <th>Giá Bán</th>
                <th>Tổng</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (ChiTietDonHang ct : listChiTiet) {
                SanPham sp = spDAO.getSanPhamById(ct.getMaSanPham());
        %>
            <tr>
                <td><%= sp.getTenSanPham() %></td>
                <td><%= ct.getSoLuong() %></td>
                <td><%= String.format("%,.0f", ct.getGiaBan()) %> VNĐ</td>
                <td><%= String.format("%,.0f", ct.getGiaBan() * ct.getSoLuong()) %> VNĐ</td>
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
