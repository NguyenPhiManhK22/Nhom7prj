package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.NguoiDung;

import java.io.IOException;

import dao.NguoiDungDAO;


/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển hướng đến trang đăng nhập
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matkhau");

        // Kiểm tra thông tin đăng nhập
        NguoiDung user = nguoiDungDAO.checkLogin(email, matKhau);

        if (user != null) {
            // Lưu thông tin người dùng vào session
            HttpSession session = request.getSession();
            session.setAttribute("userLogin", user);  // Lưu đối tượng người dùng vào session

            // Kiểm tra vai trò của người dùng
            if ("quan_tri".equalsIgnoreCase(user.getVaiTro())) {
                // Nếu là admin, chuyển hướng đến trang quản trị
                response.sendRedirect(request.getContextPath() + "/admin/dashboard");  // Chuyển hướng đến trang quản trị
            } else {
                // Nếu là người dùng thường, chuyển hướng đến trang chủ
                response.sendRedirect(request.getContextPath() + "/index");  // Chuyển hướng đến trang chủ
            }
        } else {
            // Nếu thông tin đăng nhập không chính xác, hiển thị thông báo lỗi
            request.setAttribute("errorMsg", "Email hoặc mật khẩu không đúng.");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}
