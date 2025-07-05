package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DonHang;

import java.io.IOException;

import dao.DonHangDAO;

/**
 * Servlet implementation class EditOrderServlet
 */
@SuppressWarnings("serial")
@WebServlet("/admin/orders/edit")
public class EditOrderServlet extends HttpServlet {

    // Hiển thị form sửa đơn hàng
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int maDonHang = Integer.parseInt(request.getParameter("id"));

        DonHangDAO dao = new DonHangDAO();
        DonHang donHang = dao.getDonHangById(maDonHang);

        if (donHang != null) {
            request.setAttribute("donHang", donHang);
            request.getRequestDispatcher("/admin/editOrder.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/orders?error=notfound");
        }
    }

    // Xử lý cập nhật đơn hàng
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int maDonHang = Integer.parseInt(request.getParameter("id"));
            String trangThai = request.getParameter("trangThai");
            double tongTien = Double.parseDouble(request.getParameter("tongTien"));

            DonHang donHang = new DonHang();
            donHang.setMaDonHang(maDonHang);
            donHang.setTrangThai(trangThai);
            donHang.setTongTien(tongTien);

            DonHangDAO dao = new DonHangDAO();
            boolean success = dao.capNhatDonHang(donHang);

            if (success) {
                response.sendRedirect(request.getContextPath() + "/admin/orders?success=true");
            } else {
                request.setAttribute("donHang", donHang);
                request.setAttribute("error", "Cập nhật thất bại.");
                request.getRequestDispatcher("/admin/editOrder.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi khi xử lý dữ liệu.");
            request.getRequestDispatcher("/admin/editOrder.jsp").forward(request, response);
        }
    }
}
