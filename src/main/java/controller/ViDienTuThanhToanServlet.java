package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ViDienTuThanhToanServlet
 */
@SuppressWarnings("serial")
@WebServlet("/vidientuThanhToan")
public class ViDienTuThanhToanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin thẻ từ form
        String soThe = request.getParameter("soThe");
        String ngayHetHan = request.getParameter("ngayHetHan");
        String cvv = request.getParameter("cvv");

        response.sendRedirect(request.getContextPath() + "/ketnoithanhcong");
    }
}

