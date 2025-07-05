package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DonHang;
import model.NguoiDung;

import java.io.IOException;
import java.util.List;

import dao.DonHangDAO;

/**
 * Servlet implementation class DonHangServlet
 */
@SuppressWarnings("serial")
@WebServlet("/donhang")
public class DonHangServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userLogin") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        NguoiDung user = (NguoiDung) session.getAttribute("userLogin");
        DonHangDAO donHangDAO = new DonHangDAO();
        List<DonHang> list = donHangDAO.getDonHangsByUser(user.getMaNguoiDung());

        request.setAttribute("donhangList", list);
        request.getRequestDispatcher("/jsp/donhang.jsp").forward(request, response);
    }
}
