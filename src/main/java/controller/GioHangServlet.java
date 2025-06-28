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

/**
 * Servlet implementation class GioHangServlet
 */
@SuppressWarnings("serial")
@WebServlet("/giohang")
public class GioHangServlet extends HttpServlet {

    private GioHangDAO gioHangDAO = new GioHangDAO();
    private SanPhamDAO sanPhamDAO = new SanPhamDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy giỏ hàng từ session
        HttpSession session = request.getSession();
        NguoiDung userLogin = (NguoiDung) session.getAttribute("userLogin");

        if (userLogin == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Lấy giỏ hàng của người dùng từ database
        List<GioHang> cart = gioHangDAO.getCartByUser(userLogin.getMaNguoiDung());
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/jsp/giohang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));

        // Lấy thông tin sản phẩm từ database
        SanPham sanPham = sanPhamDAO.getSanPhamById(maSanPham);
        if (sanPham != null) {
            HttpSession session = request.getSession();
            NguoiDung userLogin = (NguoiDung) session.getAttribute("userLogin");

            if (userLogin != null) {
                GioHang gioHang = new GioHang(userLogin.getMaNguoiDung(), maSanPham, soLuong);

                // Thêm sản phẩm vào giỏ hàng
                boolean success = gioHangDAO.addToCart(gioHang);
                if (success) {
                    response.sendRedirect(request.getContextPath() + "/giohang");
                } else {
                    request.setAttribute("errorMsg", "Lỗi khi thêm sản phẩm vào giỏ.");
                    request.getRequestDispatcher("/jsp/giohang.jsp").forward(request, response);
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }
    }
}
