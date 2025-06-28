package dao;

import model.DonHang;
import model.SanPham;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonHangDAO {

    // Lấy danh sách đơn hàng của người dùng
    public List<DonHang> getDonHangsByUser(int maNguoiDung) {
        List<DonHang> donHangs = new ArrayList<>();
        String sql = "SELECT * FROM DonHang WHERE ma_nguoi_dung = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maNguoiDung);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DonHang donHang = new DonHang();
                    donHang.setMaDonHang(rs.getInt("ma_don_hang"));
                    donHang.setMaNguoiDung(rs.getInt("ma_nguoi_dung"));
                    donHang.setTongTien(rs.getDouble("tong_tien"));
                    donHang.setTrangThai(rs.getString("trang_thai"));
                    donHang.setNgayTao(rs.getTimestamp("ngay_tao"));
                    donHangs.add(donHang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donHangs;
    }

    // Thêm một đơn hàng mới
    public boolean addDonHang(DonHang donHang) {
        String sql = "INSERT INTO DonHang (ma_nguoi_dung, tong_tien, trang_thai, ngay_tao) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, donHang.getMaNguoiDung());
            ps.setDouble(2, donHang.getTongTien());
            ps.setString(3, donHang.getTrangThai());
            ps.setTimestamp(4, donHang.getNgayTao());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Cập nhật thông tin đơn hàng (ví dụ: trạng thái)
    public boolean updateDonHang(DonHang donHang) {
        String sql = "UPDATE DonHang SET tong_tien = ?, trang_thai = ? WHERE ma_don_hang = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, donHang.getTongTien());
            ps.setString(2, donHang.getTrangThai());
            ps.setInt(3, donHang.getMaDonHang());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Xóa đơn hàng
    public boolean deleteDonHang(int maDonHang) {
        String sql = "DELETE FROM DonHang WHERE ma_don_hang = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maDonHang);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Lấy đơn hàng theo mã đơn hàng
    public DonHang getDonHangById(int maDonHang) {
        String sql = "SELECT * FROM DonHang WHERE ma_don_hang = ?";
        DonHang donHang = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maDonHang);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    donHang = new DonHang();
                    donHang.setMaDonHang(rs.getInt("ma_don_hang"));
                    donHang.setMaNguoiDung(rs.getInt("ma_nguoi_dung"));
                    donHang.setTongTien(rs.getDouble("tong_tien"));
                    donHang.setTrangThai(rs.getString("trang_thai"));
                    donHang.setNgayTao(rs.getTimestamp("ngay_tao"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donHang;
    }
    
    public List<SanPham> getProductsByOrderId(int maDonHang) {
        List<SanPham> products = new ArrayList<>();
        String sql = "SELECT p.* FROM SanPham p " +
                     "JOIN DonHangSanPham dhsp ON p.ma_san_pham = dhsp.ma_san_pham " +
                     "WHERE dhsp.ma_don_hang = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maDonHang);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    SanPham product = new SanPham();
                    product.setMaSanPham(rs.getInt("ma_san_pham"));
                    product.setTenSanPham(rs.getString("ten_san_pham"));
                    product.setGia(rs.getDouble("gia"));
                    product.setSoLuongTrongKho(rs.getInt("so_luong_trong_kho"));
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
    
}
