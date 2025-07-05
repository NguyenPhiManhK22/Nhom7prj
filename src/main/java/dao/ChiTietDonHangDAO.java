package dao;

import model.ChiTietDonHang;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietDonHangDAO {
    private Connection conn;

    // Constructor mặc định – luôn khởi tạo kết nối
    public ChiTietDonHangDAO() {
        this.conn = DBConnection.getConnection();
        if (this.conn == null) {
            throw new RuntimeException("Không thể kết nối đến CSDL (conn = null)");
        }
    }

    // Thêm chi tiết đơn hàng bằng đối tượng model
    public boolean themChiTietDonHang(ChiTietDonHang ctdh) {
        String sql = "INSERT INTO ChiTietDonHang(ma_don_hang, ma_san_pham, ten_san_pham, so_luong, gia_ban) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ctdh.getMaDonHang());
            stmt.setInt(2, ctdh.getMaSanPham());
            stmt.setString(3, ctdh.getTenSanPham());
            stmt.setInt(4, ctdh.getSoLuong());
            stmt.setDouble(5, ctdh.getGiaBan());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Thêm chi tiết đơn hàng qua tham số riêng
    public boolean themChiTietDonHang(int maDonHang, int maSanPham, String tenSanPham, int soLuong, double giaBan) {
        String sql = "INSERT INTO ChiTietDonHang (ma_don_hang, ma_san_pham, ten_san_pham, so_luong, gia_ban) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maDonHang);
            ps.setInt(2, maSanPham);
            ps.setString(3, tenSanPham);
            ps.setInt(4, soLuong);
            ps.setDouble(5, giaBan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách chi tiết đơn hàng theo mã đơn hàng
    public List<ChiTietDonHang> getChiTietByDonHang(int maDonHang) {
        List<ChiTietDonHang> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietDonHang WHERE ma_don_hang = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maDonHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietDonHang ct = new ChiTietDonHang();
                ct.setMaChiTietDonHang(rs.getInt("ma_chi_tiet_don_hang"));
                ct.setMaDonHang(rs.getInt("ma_don_hang"));
                ct.setMaSanPham(rs.getInt("ma_san_pham"));
                ct.setTenSanPham(rs.getString("ten_san_pham"));
                ct.setSoLuong(rs.getInt("so_luong"));
                ct.setGiaBan(rs.getDouble("gia_ban"));
                list.add(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Xóa toàn bộ chi tiết theo mã đơn hàng
    public void xoaChiTietTheoDonHang(int maDonHang) {
        String sql = "DELETE FROM ChiTietDonHang WHERE ma_don_hang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maDonHang);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa 1 dòng chi tiết đơn hàng theo mã chi tiết
    public void xoaChiTietTheoMaChiTiet(int maChiTiet) {
        String sql = "DELETE FROM ChiTietDonHang WHERE ma_chi_tiet_don_hang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maChiTiet);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
