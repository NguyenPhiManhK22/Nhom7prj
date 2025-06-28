package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DonHang;

import java.io.IOException;
import java.util.List;

import dao.AdminOrderDAO;

/**
 * Servlet implementation class AdminOrderServlet
 */
@SuppressWarnings("serial")
@WebServlet("/admin/orders")
public class AdminOrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminOrderDAO orderDAO = new AdminOrderDAO();
        List<DonHang> orders = orderDAO.getAllOrders();

        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);
    }
}
