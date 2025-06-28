package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.NguoiDung;

import java.io.IOException;

import dao.GioHangDAO;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@SuppressWarnings("serial")
@WebServlet("/remove")
public class RemoveFromCartServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin sản phẩm từ yêu cầu (maSanPham)
        int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
        
        // Kiểm tra session để lấy thông tin người dùng
        HttpSession session = request.getSession(false); // Không tạo session mới
        NguoiDung userLogin = null;
        
        if (session != null) {
            userLogin = (NguoiDung) session.getAttribute("userLogin");
        }
        
        if (userLogin != null) {
            int maNguoiDung = userLogin.getMaNguoiDung();  // Lấy mã người dùng từ đối tượng NguoiDung

            // Gọi DAO để xóa sản phẩm khỏi giỏ hàng
            GioHangDAO gioHangDAO = new GioHangDAO();
            boolean success = gioHangDAO.removeFromCart(maNguoiDung, maSanPham);
            
            if (success) {
                // Nếu xóa thành công, chuyển hướng lại giỏ hàng
                response.sendRedirect(request.getContextPath() + "/giohang");
            } else {
                // Nếu xóa thất bại, có thể thông báo lỗi
                request.setAttribute("errorMsg", "Không thể xóa sản phẩm khỏi giỏ hàng.");
                request.getRequestDispatcher("/giohang").forward(request, response);
            }
        } else {
            // Nếu người dùng chưa đăng nhập, chuyển hướng về trang đăng nhập
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}