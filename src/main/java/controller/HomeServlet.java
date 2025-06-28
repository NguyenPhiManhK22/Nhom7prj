package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.NguoiDung;
import model.SanPham;
import dao.SanPhamDAO;

import java.io.IOException;
import java.util.List;


@SuppressWarnings("serial")
@WebServlet("/index")
public class HomeServlet extends HttpServlet {

    private SanPhamDAO sanPhamDAO = new SanPhamDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Kiểm tra session xem người dùng đã đăng nhập chưa
        HttpSession session = request.getSession();
        NguoiDung userLogin = (NguoiDung) session.getAttribute("userLogin");

      /*  if (userLogin == null) {
            // Nếu chưa đăng nhập, chuyển hướng về trang đăng nhập
            response.sendRedirect(request.getContextPath() + "/login");
            return;  // Dừng lại nếu chưa đăng nhập
        } */

        // Nếu đã đăng nhập, hiển thị danh sách sản phẩm
        List<SanPham> listSanPham = sanPhamDAO.getAllSanPham();
        request.setAttribute("listSanPham", listSanPham);
        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }
}
