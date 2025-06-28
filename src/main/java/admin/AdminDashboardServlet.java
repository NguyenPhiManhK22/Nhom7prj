package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.AdminOrderDAO;
import dao.AdminUserDAO;
import dao.ProductDAO;

/**
 * Servlet implementation class AdminDashboardServlet
 */
@SuppressWarnings("serial")
@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tổng số sản phẩm
        ProductDAO productDAO = new ProductDAO();
        int totalProducts = productDAO.getTotalProducts();

        // Lấy tổng số đơn hàng
        AdminOrderDAO orderDAO = new AdminOrderDAO();
        int totalOrders = orderDAO.getTotalOrders();

        // Lấy tổng số người dùng
        AdminUserDAO userDAO = new AdminUserDAO();
        int totalUsers = userDAO.getTotalUsers();

        // Gán các giá trị vào request attribute
        request.setAttribute("totalProducts", totalProducts);
        request.setAttribute("totalOrders", totalOrders);
        request.setAttribute("totalUsers", totalUsers);

        // Chuyển hướng đến trang admin dashboard
        request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
    }
}