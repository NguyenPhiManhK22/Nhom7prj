package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GioHang;
import model.NguoiDung;
import model.SanPham;

import java.io.IOException;
import java.util.List;

import dao.GioHangDAO;
import dao.SanPhamDAO;
import dao.ThanhToanDAO;

/**
 * Servlet implementation class ThanhToanServlet
 */
@SuppressWarnings("serial")
@WebServlet("/thanhtoan")
public class ThanhToanServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Kiểm tra đăng nhập
        if (session == null || session.getAttribute("userLogin") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        NguoiDung userLogin = (NguoiDung) session.getAttribute("userLogin");

        // Lấy giỏ hàng của người dùng từ cơ sở dữ liệu
        GioHangDAO gioHangDAO = new GioHangDAO();
        List<GioHang> cart = gioHangDAO.getCartByUser(userLogin.getMaNguoiDung());

        double totalAmount = 0;
        for (GioHang item : cart) {
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            SanPham sanPham = sanPhamDAO.getSanPhamById(item.getMaSanPham());
            if (sanPham != null) {
                totalAmount += sanPham.getGia() * item.getSoLuong();
            }
        }

        // Lấy phương thức thanh toán từ form
        String phuongThucThanhToan = request.getParameter("phuongThucThanhToan");

        // Giả sử bạn lưu thông tin thanh toán vào cơ sở dữ liệu
        ThanhToanDAO thanhToanDAO = new ThanhToanDAO();
        boolean paymentSuccess = thanhToanDAO.processPayment(userLogin.getMaNguoiDung(), totalAmount, phuongThucThanhToan);

        // Xử lý thanh toán thành công
        if (phuongThucThanhToan != null) {
            // Bạn có thể thêm logic thanh toán ở đây

            // Sau khi xử lý thanh toán, chuyển hướng đến trang tương ứng
            if ("tien_mat".equals(phuongThucThanhToan)) {
                response.sendRedirect(request.getContextPath() + "/jsp/tienmat.jsp");
            } else if ("chuyen_khoan".equals(phuongThucThanhToan)) {
                response.sendRedirect(request.getContextPath() + "/jsp/chuyenkhoan.jsp");
            } else if ("vi_dien_tu".equals(phuongThucThanhToan)) {
                response.sendRedirect(request.getContextPath() + "/jsp/vidientu.jsp");
            }
        } else {
            // Nếu không có phương thức thanh toán, quay lại trang giỏ hàng
            request.setAttribute("error", "Chưa chọn phương thức thanh toán.");
            request.getRequestDispatcher("/jsp/thanhtoan.jsp").forward(request, response);
        }
    }
}