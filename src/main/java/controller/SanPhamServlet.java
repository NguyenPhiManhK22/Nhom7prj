package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import model.SanPham;
import dao.SanPhamDAO;

/**
 * Servlet implementation class SanPhamServlet
 */
@SuppressWarnings("serial")
@WebServlet("/sanpham")
public class SanPhamServlet extends HttpServlet {

    private SanPhamDAO sanPhamDAO = new SanPhamDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> listSanPham = sanPhamDAO.getAllSanPham();
        request.setAttribute("listSanPham", listSanPham);
        request.getRequestDispatcher("jsp/sanpham.jsp").forward(request, response);
    }
}
