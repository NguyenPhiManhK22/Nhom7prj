package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GioHang;
import model.NguoiDung;

import java.io.IOException;

import dao.GioHangDAO;

/**
 * Servlet implementation class AddToCartServlet
 */
@SuppressWarnings("serial")
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    private GioHangDAO gioHangDAO = new GioHangDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tham số từ URL (maSanPham và soLuong)
        int maSanPham = Integer.parseInt(request.getParameter("maSanPham"));
        int soLuong = 1;  // Mặc định số lượng là 1

        // Lấy thông tin người dùng từ session
        HttpSession session = request.getSession();
        NguoiDung user = (NguoiDung) session.getAttribute("userLogin");

        if (user != null) {
            // Thêm sản phẩm vào giỏ hàng
            GioHang gioHang = new GioHang();
            gioHang.setMaNguoiDung(user.getMaNguoiDung());
            gioHang.setMaSanPham(maSanPham);
            gioHang.setSoLuong(soLuong);

            boolean added = gioHangDAO.addToCart(gioHang);

            if (added) {
                response.sendRedirect(request.getContextPath() + "/giohang"); // Chuyển hướng đến giỏ hàng
            } else {
                request.setAttribute("errorMsg", "Không thể thêm sản phẩm vào giỏ hàng.");
                request.getRequestDispatcher("/jsp/sanpham.jsp").forward(request, response); // Quay lại trang sản phẩm
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login"); // Chuyển hướng tới trang đăng nhập nếu chưa đăng nhập
        }
    }
}


