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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ID đơn hàng từ tham số trong URL
        int maDonHang = Integer.parseInt(request.getParameter("id"));

        // Sử dụng DAO để lấy thông tin đơn hàng từ cơ sở dữ liệu
        DonHangDAO donHangDAO = new DonHangDAO();
        DonHang donHang = donHangDAO.getDonHangById(maDonHang);

        if (donHang != null) {
            // Chuyển dữ liệu đơn hàng vào trang JSP để hiển thị
            request.setAttribute("donHang", donHang);
            request.getRequestDispatcher("/view/admin/editOrder.jsp").forward(request, response);
        } else {
            // Nếu không tìm thấy đơn hàng, chuyển hướng về trang danh sách đơn hàng
            response.sendRedirect(request.getContextPath() + "/admin/orders");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        int maDonHang = Integer.parseInt(request.getParameter("id"));
        String trangThai = request.getParameter("trangThai");
        double tongTien = Double.parseDouble(request.getParameter("tongTien"));

        // Tạo đối tượng DonHang mới để lưu thông tin
        DonHang donHang = new DonHang();
        donHang.setMaDonHang(maDonHang);
        donHang.setTrangThai(trangThai);
        donHang.setTongTien(tongTien);

        // Cập nhật thông tin đơn hàng
        DonHangDAO donHangDAO = new DonHangDAO();
        boolean isUpdated = donHangDAO.updateDonHang(donHang);

        if (isUpdated) {
            // Nếu cập nhật thành công, chuyển hướng về trang danh sách đơn hàng
            response.sendRedirect(request.getContextPath() + "/admin/orders");
        } else {
            // Nếu cập nhật thất bại, hiển thị lỗi và quay lại trang sửa
            request.setAttribute("errorMessage", "Cập nhật đơn hàng thất bại!");
            request.getRequestDispatcher("/view/admin/editOrder.jsp").forward(request, response);
        }
    }
}
