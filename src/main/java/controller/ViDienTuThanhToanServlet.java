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

        // Xử lý thanh toán ví điện tử
        // Ở đây bạn có thể thêm logic kết nối với dịch vụ thanh toán ví điện tử

        // Chuyển hướng đến trang thanh toán thành công
        response.sendRedirect(request.getContextPath() + "/ketnoithanhcong");
    }
}

