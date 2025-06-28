package controller;

import dao.ChiTietDonHangDAO;
import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChiTietDonHang;


import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/chitietdonhang")
public class ChiTietDonHangServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        String maDonHangStr = request.getParameter("ma_don_hang");

        if (maDonHangStr == null || maDonHangStr.isEmpty()) {
            response.sendRedirect("donhang.jsp"); // hoặc trang báo lỗi
            return;
        }

        int maDonHang;
        try {
            maDonHang = Integer.parseInt(maDonHangStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("donhang.jsp");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            ChiTietDonHangDAO chiTietDAO = new ChiTietDonHangDAO(conn);
            List<ChiTietDonHang> chiTietList = chiTietDAO.getChiTietDonHangByDonHangId(maDonHang);

            request.setAttribute("chiTietList", chiTietList);
            request.setAttribute("maDonHang", maDonHang);
            request.getRequestDispatcher("chitietdonhang.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
