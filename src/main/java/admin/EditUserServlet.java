package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NguoiDung;

import java.io.IOException;

import dao.NguoiDungDAO;

/**
 * Servlet implementation class EditUserServlet
 */
@SuppressWarnings("serial")
@WebServlet("/admin/editUser")
public class EditUserServlet extends HttpServlet {
    private NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy id người dùng từ request
        int maNguoiDung = Integer.parseInt(request.getParameter("id"));

        // Lấy thông tin người dùng từ DB
        NguoiDung user = nguoiDungDAO.getNguoiDungById(maNguoiDung);

        // Đưa thông tin người dùng vào request để gửi sang JSP
        request.setAttribute("user", user);
        request.getRequestDispatcher("/view/admin/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin người dùng sửa từ form
        int maNguoiDung = Integer.parseInt(request.getParameter("id"));
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");
        String soDienThoai = request.getParameter("soDienThoai");
        String diaChi = request.getParameter("diaChi");
        String vaiTro = request.getParameter("vaiTro");

        // Cập nhật thông tin người dùng
        NguoiDung user = new NguoiDung();
        boolean result = nguoiDungDAO.updateNguoiDung(user);

        if (result) {
            // Nếu cập nhật thành công, chuyển hướng về trang quản lý người dùng
            response.sendRedirect(request.getContextPath() + "/admin/users");
        } else {
            // Nếu có lỗi, gửi thông báo lỗi
            request.setAttribute("errorMsg", "Có lỗi trong quá trình cập nhật thông tin!");
            request.getRequestDispatcher("/view/admin/editUser.jsp").forward(request, response);
        }
    }	
}