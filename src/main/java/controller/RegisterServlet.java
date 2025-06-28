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
 * Servlet implementation class RegisterServlet
 */
@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển tới trang đăng ký
        request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoTen = request.getParameter("hoten");
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matkhau");
        String soDienThoai = request.getParameter("sdt");
        String diaChi = request.getParameter("diachi");


        if(nguoiDungDAO.emailExists(email)) {
            request.setAttribute("errorMsg", "Email đã tồn tại, vui lòng chọn email khác.");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
            return;
        }

        NguoiDung user = new NguoiDung();
        user.setHoTen(hoTen);
        user.setEmail(email);
        user.setMatKhau(matKhau); // Lưu thẳng mật khẩu
        user.setSoDienThoai(soDienThoai);
        user.setDiaChi(diaChi);
        user.setVaiTro("khach_hang");

        boolean success = nguoiDungDAO.insertUser(user);

        if(success) {
            // Chuyển về trang login (nên redirect tới URL servlet hoặc file JSP chính xác)
            response.sendRedirect(request.getContextPath() + "/login"); 
            // Hoặc nếu dùng file jsp trực tiếp: response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        } else {
            request.setAttribute("errorMsg", "Đăng ký thất bại, vui lòng thử lại.");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
        }
    }
}
