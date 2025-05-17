package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NguoiDung;

import java.io.IOException;

import dao.NguoiDungDAO;

/**
 * Servlet implementation class DangKyServlet
 */
@SuppressWarnings("serial")
@WebServlet("/dang-ky")
public class DangKyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoTen = request.getParameter("hoTen");
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matKhau");
        String soDienThoai = request.getParameter("soDienThoai");
        String diaChi = request.getParameter("diaChi");

        NguoiDung nguoiDung = new NguoiDung(hoTen, email, matKhau, soDienThoai, diaChi, "khach_hang");

        NguoiDungDAO dao = new NguoiDungDAO();
        boolean thanhCong = dao.dangKyNguoiDung(nguoiDung);

        if (thanhCong) {
            response.sendRedirect("jsp/login.jsp");
        } else {
            request.setAttribute("loi", "Đăng ký thất bại. Email có thể đã tồn tại.");
            request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
        }
    }
}

