	package dao;

import model.DonHang;  // Đảm bảo bạn có lớp DonHang
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminOrderDAO {

    // Lấy tất cả đơn hàng
    public List<DonHang> getAllOrders() {
        List<DonHang> orders = new ArrayList<>();
        String sql = "SELECT * FROM DonHang";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DonHang order = new DonHang();
                order.setMaDonHang(rs.getInt("ma_don_hang"));
                order.setMaNguoiDung(rs.getInt("ma_nguoi_dung"));
                order.setNgayTao(rs.getTimestamp("ngay_tao"));
                order.setTrangThai(rs.getString("trang_thai"));
                order.setTongTien(rs.getDouble("tong_tien"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Lấy thông tin đơn hàng theo ID
    public DonHang getOrderById(int maDonHang) {
        DonHang order = null;
        String sql = "SELECT * FROM DonHang WHERE ma_don_hang = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maDonHang);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    order = new DonHang();
                    order.setMaDonHang(rs.getInt("ma_don_hang"));
                    order.setMaNguoiDung(rs.getInt("ma_nguoi_dung"));
                    order.setNgayTao(rs.getTimestamp("ngay_tao"));
                    order.setTrangThai(rs.getString("trang_thai"));
                    order.setTongTien(rs.getDouble("tong_tien"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    // Cập nhật trạng thái đơn hàng
    public boolean updateOrderStatus(int maDonHang, String trangThai) {
        String sql = "UPDATE DonHang SET trang_thai = ? WHERE ma_don_hang = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, trangThai);
            ps.setInt(2, maDonHang);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa đơn hàng
    public boolean deleteOrder(int maDonHang) {
        String sql = "DELETE FROM DonHang WHERE ma_don_hang = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maDonHang);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public int getTotalOrders() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM DonHang"; // Giả sử bảng đơn hàng của bạn là "DonHang"

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt(1);  // Lấy kết quả đếm từ truy vấn COUNT(*)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
}
