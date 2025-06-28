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
 * Servlet implementation class UpdateCartServlet
 */
@SuppressWarnings("serial")
@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {
    private GioHangDAO gioHangDAO = new GioHangDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        NguoiDung user = (NguoiDung) session.getAttribute("userLogin");

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Debugging: In ra tất cả các tham số trong request
        System.out.println("Tất cả tham số request: " + request.getParameterMap());

        // Lấy thông tin số lượng sản phẩm từ form
        for (String param : request.getParameterMap().keySet()) {
            if (param.startsWith("soLuong_")) {
                int maSanPham = Integer.parseInt(param.substring("soLuong_".length()));
                int soLuong = Integer.parseInt(request.getParameter(param));

                // Debugging: Kiểm tra ID sản phẩm và số lượng
                System.out.println("Sản phẩm ID: " + maSanPham + ", Số lượng: " + soLuong);

                boolean updated = gioHangDAO.updateCart(user.getMaNguoiDung(), maSanPham, soLuong);
                if (!updated) {
                    request.setAttribute("errorMsg", "Không thể cập nhật giỏ hàng.");
                    request.getRequestDispatcher("/jsp/giohang.jsp").forward(request, response);
                    return;
                }
            }
        }

        // Chuyển hướng về giỏ hàng sau khi cập nhật
        response.sendRedirect(request.getContextPath() + "/giohang");
    }
}

