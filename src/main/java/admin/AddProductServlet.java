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
 * Servlet implementation class AddProductServlet
 */
@SuppressWarnings("serial")
@WebServlet("/admin/addProduct")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String tenSanPham = request.getParameter("tenSanPham");
        double gia = Double.parseDouble(request.getParameter("gia"));
        String moTa = request.getParameter("moTa");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        int maDanhMuc = Integer.parseInt(request.getParameter("maDanhMuc"));
        String duongDanAnh = request.getParameter("duongDanAnh");

        // Tạo đối tượng SanPham
        SanPham sanPham = new SanPham(0, tenSanPham, moTa, gia, soLuong, maDanhMuc, duongDanAnh);

        // Tạo DAO và thêm sản phẩm
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        boolean isAdded = sanPhamDAO.addSanPham(sanPham);

        // Nếu thêm sản phẩm thành công, chuyển hướng về trang quản lý sản phẩm
        if (isAdded) {
            response.sendRedirect(request.getContextPath() + "/admin/products");  // Redirect về trang quản lý sản phẩm
        } else {
            // Nếu thêm không thành công, chuyển hướng về trang thêm sản phẩm với thông báo lỗi
            request.setAttribute("errorMsg", "Lỗi khi thêm sản phẩm!");
            request.getRequestDispatcher("/admin/addProduct.jsp").forward(request, response);
        }
    }
}
