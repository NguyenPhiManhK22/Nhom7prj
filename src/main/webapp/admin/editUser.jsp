<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.NguoiDung" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Sửa Người Dùng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminStyle.css" />
</head>
<body>

<h2>Sửa Người Dùng</h2>

<%
    NguoiDung user = (NguoiDung) request.getAttribute("user");
    if (user == null) {
%>
    <p>Không tìm thấy người dùng!</p>
<%
    } else {
%>

<form action="editUser" method="post">
    <input type="hidden" name="id" value="<%= user.getMaNguoiDung() %>" />
    
    <div>
        <label for="hoTen">Họ và Tên:</label>
        <input type="text" name="hoTen" id="hoTen" value="<%= user.getHoTen() %>" required />
    </div>

    <div>
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" value="<%= user.getEmail() %>" required />
    </div>

    <div>
        <label for="soDienThoai">Số Điện Thoại:</label>
        <input type="text" name="soDienThoai" id="soDienThoai" value="<%= user.getSoDienThoai() %>" required />
    </div>

    <div>
        <label for="diaChi">Địa Chỉ:</label>
        <input type="text" name="diaChi" id="diaChi" value="<%= user.getDiaChi() %>" required />
    </div>

    <div>
        <label for="vaiTro">Vai Trò:</label>
        <select name="vaiTro" id="vaiTro">
            <option value="khach_hang" <%= user.getVaiTro().equals("khach_hang") ? "selected" : "" %>>Khách Hàng</option>
            <option value="quan_tri" <%= user.getVaiTro().equals("quan_tri") ? "selected" : "" %>>Quản Trị</option>
        </select>
    </div>

    <div>
        <button type="submit">Cập nhật</button>
        <a href="<%= request.getContextPath() %>/admin/users" class="btn btn-secondary">Quay lại</a>
    </div>
</form>

<%
    }
%>

</body>
</html>
