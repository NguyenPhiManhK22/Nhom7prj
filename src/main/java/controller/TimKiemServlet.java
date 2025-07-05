package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SanPham;

import java.io.IOException;
import java.util.List;

import dao.SanPhamDAO;

/**
 * Servlet implementation class TimKiemServlet
 */
@SuppressWarnings("serial")
@WebServlet("/timkiem")
public class TimKiemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        SanPhamDAO dao = new SanPhamDAO();
        List<SanPham> ketQua = dao.timKiemSanPham(keyword);

        request.setAttribute("ketQua", ketQua);
        request.getRequestDispatcher("/timkiem.jsp").forward(request, response);
    }
}

