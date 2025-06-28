package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.DBConnection;
import model.SanPham;

public class SanPhamDAO {

    // Lấy tất cả sản phẩm
    public List<SanPham> getAllSanPham() {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getInt("ma_san_pham"));
                sp.setTenSanPham(rs.getString("ten_san_pham"));
                sp.setMoTa(rs.getString("mo_ta"));
                sp.setGia(rs.getDouble("gia"));
                sp.setSoLuongTrongKho(rs.getInt("so_luong_trong_kho"));
                sp.setMaDanhMuc(rs.getInt("ma_danh_muc"));
                sp.setDuongDanAnh(rs.getString("duong_dan_anh"));
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy sản phẩm theo ID
    public SanPham getSanPhamById(int maSanPham) {
        String sql = "SELECT * FROM SanPham WHERE ma_san_pham = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maSanPham);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaSanPham(rs.getInt("ma_san_pham"));
                    sp.setTenSanPham(rs.getString("ten_san_pham"));
                    sp.setMoTa(rs.getString("mo_ta"));
                    sp.setGia(rs.getDouble("gia"));
                    sp.setSoLuongTrongKho(rs.getInt("so_luong_trong_kho"));
                    sp.setMaDanhMuc(rs.getInt("ma_danh_muc"));
                    sp.setDuongDanAnh(rs.getString("duong_dan_anh"));
                    return sp;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm sản phẩm
    public boolean addSanPham(SanPham sanPham) {
        String sql = "INSERT INTO SanPham (ten_san_pham, gia, mo_ta, so_luong_trong_kho, ma_danh_muc, duong_dan_anh) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sanPham.getTenSanPham());
            ps.setDouble(2, sanPham.getGia());
            ps.setString(3, sanPham.getMoTa());
            ps.setInt(4, sanPham.getSoLuongTrongKho());
            ps.setInt(5, sanPham.getMaDanhMuc());
            ps.setString(6, sanPham.getDuongDanAnh());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sản phẩm đã được thêm thành công.");
                return true;
            } else {
                System.out.println("Không thể thêm sản phẩm.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Cập nhật sản phẩm
    public boolean updateSanPham(SanPham sanPham) {
        String sql = "UPDATE SanPham SET ten_san_pham = ?, gia = ?, mo_ta = ?, so_luong_trong_kho = ?, duong_dan_anh = ?, ma_danh_muc = ? WHERE ma_san_pham = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sanPham.getTenSanPham());
            ps.setDouble(2, sanPham.getGia());
            ps.setString(3, sanPham.getMoTa());
            ps.setInt(4, sanPham.getSoLuongTrongKho());
            ps.setString(5, sanPham.getDuongDanAnh());
            ps.setInt(6, sanPham.getMaDanhMuc());
            ps.setInt(7, sanPham.getMaSanPham());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Xóa sản phẩm
    public boolean deleteSanPham(int maSanPham) {
        String sql = "DELETE FROM SanPham WHERE ma_san_pham = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maSanPham);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
