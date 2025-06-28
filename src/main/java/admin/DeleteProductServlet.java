package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.SanPhamDAO;

/**
 * Servlet implementation class DeleteProductServlet
 */
@SuppressWarnings("serial")
@WebServlet("/admin/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maSanPham = Integer.parseInt(request.getParameter("id"));

        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        boolean isDeleted = sanPhamDAO.deleteSanPham(maSanPham);

        if (isDeleted) {
            response.sendRedirect(request.getContextPath() + "/admin/products");
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/products");
        }
    }
}