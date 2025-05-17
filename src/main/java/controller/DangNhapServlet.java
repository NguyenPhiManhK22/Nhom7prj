package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.NguoiDungDAO;

/**
 * Servlet implementation class DangNhapServlet
 */
@SuppressWarnings("serial")
@WebServlet("/dang-nhap")
public class DangNhapServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matKhau");

        NguoiDungDAO dao = new NguoiDungDAO();
        boolean hopLe = dao.kiemTraDangNhap(email, matKhau);

        if (hopLe) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("jsp/index.jsp");
        } else {
            request.setAttribute("loi", "Sai email hoặc mật khẩu");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
    }
}
