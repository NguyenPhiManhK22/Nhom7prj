package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SanPham;

import java.io.IOException;

import dao.SanPhamDAO;

/**
 * Servlet implementation class UpdateProductServlet
 */
@SuppressWarnings("serial")
@WebServlet("/admin/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
        String tenSanPham = request.getParameter("tenSanPham");
        double gia = Double.parseDouble(request.getParameter("gia"));
        String moTa = request.getParameter("moTa");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String duongDanAnh = request.getParameter("duongDanAnh");
        int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));

        // Tạo đối tượng SanPham
        SanPham sanPham = new SanPham(maSanPham, tenSanPham, moTa, gia, soLuong, maDanhMuc, duongDanAnh);

        // Tạo DAO và cập nhật sản phẩm
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        boolean isUpdated = sanPhamDAO.updateSanPham(sanPham);

        if (isUpdated) {
            // Sau khi cập nhật thành công, chuyển hướng về trang quản lý sản phẩm
            response.sendRedirect(request.getContextPath() + "/admin/products");
        } else {
            // Nếu có lỗi, quay lại trang cập nhật sản phẩm
            request.setAttribute("errorMsg", "Cập nhật sản phẩm thất bại.");
            request.getRequestDispatcher("/admin/editProduct.jsp").forward(request, response);
        }
    }
}

