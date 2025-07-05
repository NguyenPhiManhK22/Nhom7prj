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

        String maDonHangStr = request.getParameter("maDonHang");
        
        if (maDonHangStr != null) {
            try {
                int maDonHang = Integer.parseInt(maDonHangStr);
                ChiTietDonHangDAO dao = new ChiTietDonHangDAO();
                List<ChiTietDonHang> list = dao.getChiTietByDonHang(maDonHang);

                request.setAttribute("maDonHang", maDonHang);
                request.setAttribute("chiTietList", list);
                request.getRequestDispatcher("/jsp/chitietdonhang.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("donhang");
            }
        } else {
            response.sendRedirect("donhang");
        }
    }
}
