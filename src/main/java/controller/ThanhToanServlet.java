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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ChiTietDonHangDAO;
import dao.DonHangDAO;
import dao.GioHangDAO;
import dao.SanPhamDAO;

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
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        Map<Integer, SanPham> sanPhamMap = new HashMap<>();

        for (GioHang item : cart) {
            SanPham sanPham = sanPhamDAO.getSanPhamById(item.getMaSanPham());
            if (sanPham != null) {
                totalAmount += sanPham.getGia() * item.getSoLuong();
                sanPhamMap.put(item.getMaSanPham(), sanPham); // Lưu lại sản phẩm để dùng sau
            }
        }

        // Lấy phương thức thanh toán từ form
        String phuongThucThanhToan = request.getParameter("phuongThucThanhToan");

        // ✅ Bắt đầu xử lý thanh toán và lưu đơn hàng
        if (phuongThucThanhToan != null) {
            // 1. Tạo đơn hàng
            DonHangDAO donHangDAO = new DonHangDAO();
            int maDonHang = donHangDAO.taoDonHang(userLogin.getMaNguoiDung(), totalAmount); // trạng thái mặc định: 'cho_xu_ly'

            if (maDonHang > 0) {
                // 2. Lưu chi tiết đơn hàng (bao gồm tên sản phẩm)
                ChiTietDonHangDAO chiTietDAO = new ChiTietDonHangDAO();
                for (GioHang item : cart) {
                    SanPham sp = sanPhamMap.get(item.getMaSanPham());
                    if (sp != null) {
                        chiTietDAO.themChiTietDonHang(
                            maDonHang,
                            sp.getMaSanPham(),
                            sp.getTenSanPham(), // ✅ thêm tên sản phẩm
                            item.getSoLuong(),
                            sp.getGia()
                        );
                    }
                }

                // 3. Xóa giỏ hàng sau khi thanh toán
                gioHangDAO.clearCartByUser(userLogin.getMaNguoiDung());

                // 4. Chuyển hướng đến trang thanh toán tương ứng
                if ("tien_mat".equals(phuongThucThanhToan)) {
                    response.sendRedirect(request.getContextPath() + "/jsp/tienmat.jsp");
                } else if ("chuyen_khoan".equals(phuongThucThanhToan)) {
                    response.sendRedirect(request.getContextPath() + "/jsp/chuyenkhoan.jsp");
                } else if ("vi_dien_tu".equals(phuongThucThanhToan)) {
                    response.sendRedirect(request.getContextPath() + "/jsp/vidientu.jsp");
                } else {
                    response.sendRedirect(request.getContextPath() + "/jsp/thanhtoanthanhcong.jsp");
                }

            } else {
                request.setAttribute("error", "Không thể tạo đơn hàng.");
                request.getRequestDispatcher("/jsp/thanhtoan.jsp").forward(request, response);
            }

        } else {
            // Nếu không có phương thức thanh toán, quay lại trang giỏ hàng
            request.setAttribute("error", "Chưa chọn phương thức thanh toán.");
            request.getRequestDispatcher("/jsp/thanhtoan.jsp").forward(request, response);
        }
    }
}