package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NguoiDung;

import java.io.IOException;
import java.util.List;

import dao.AdminUserDAO;

/**
 * Servlet implementation class AdminUserServlet
 */
@SuppressWarnings("serial")
@WebServlet("/admin/users")
public class AdminUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminUserDAO userDAO = new AdminUserDAO();
        List<NguoiDung> users = userDAO.getAllUsers();  // Sử dụng NguoiDung thay vì User

        request.setAttribute("users", users);
        request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
    }
}