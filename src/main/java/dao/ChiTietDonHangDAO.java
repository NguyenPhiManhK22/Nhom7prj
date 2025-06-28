package dao;

import model.ChiTietDonHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietDonHangDAO {
    private Connection conn;

    public ChiTietDonHangDAO(Connection conn) {
        this.conn = conn;
    }

    // Lấy danh sách chi tiết đơn hàng theo mã đơn hàng
    public List<ChiTietDonHang> getChiTietDonHangByDonHangId(int maDonHang) {
        List<ChiTietDonHang> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietDonHang WHERE ma_don_hang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maDonHang);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ChiTietDonHang ctdh = new ChiTietDonHang();
            
                ctdh.setSoLuong(rs.getInt("so_luong"));
                ctdh.setGiaBan(rs.getBigDecimal("gia_ban"));
                list.add(ctdh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm một chi tiết đơn hàng mới
    public boolean themChiTietDonHang(ChiTietDonHang ctdh) {
        String sql = "INSERT INTO ChiTietDonHang(ma_don_hang, ma_san_pham, so_luong, gia_ban) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setInt(3, ctdh.getSoLuong());
            stmt.setBigDecimal(4, ctdh.getGiaBan());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa chi tiết đơn hàng theo mã đơn hàng
    public void xoaChiTietTheoDonHang(int maDonHang) {
        String sql = "DELETE FROM ChiTietDonHang WHERE ma_don_hang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maDonHang);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa chi tiết đơn hàng theo mã chi tiết
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
