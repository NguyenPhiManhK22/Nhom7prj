package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SanPham;

import java.io.IOException;

import dao.SanPhamDAO;

/**
 * Servlet implementation class ChiTietSanPhamServlet
 */
@SuppressWarnings("serial")
@WebServlet("/chitietsanpham")
public class ChiTietSanPhamServlet extends HttpServlet {
    private SanPhamDAO sanPhamDAO = new SanPhamDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSPStr = request.getParameter("id");
        if(maSPStr == null) {
            response.sendRedirect("index"); // Nếu không có id, quay về trang chủ
            return;
        }

        try {
            int maSP = Integer.parseInt(maSPStr);
            SanPham sp = sanPhamDAO.getSanPhamById(maSP);
            if(sp == null) {
                response.sendRedirect("index"); // Không tìm thấy sản phẩm, quay về trang chủ
                return;
            }
            request.setAttribute("sanPham", sp);
            request.getRequestDispatcher("/jsp/chitietsanpham.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("index");
        }
    }
}

