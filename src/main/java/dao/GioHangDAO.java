package dao;

import model.GioHang;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GioHangDAO {

    // Thêm sản phẩm vào giỏ hàng (kiểm tra sản phẩm đã có chưa)
    public boolean addToCart(GioHang gioHang) {
        // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
        String checkSQL = "SELECT 1 FROM GioHang WHERE ma_nguoi_dung = ? AND ma_san_pham = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(checkSQL)) {

            ps.setInt(1, gioHang.getMaNguoiDung());
            ps.setInt(2, gioHang.getMaSanPham());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Sản phẩm đã có trong giỏ, cập nhật số lượng
                    return updateCart(gioHang.getMaNguoiDung(), gioHang.getMaSanPham(), gioHang.getSoLuong());
                } else {
                    // Thêm sản phẩm mới vào giỏ hàng
                    String sql = "INSERT INTO GioHang (ma_nguoi_dung, ma_san_pham, so_luong) VALUES (?, ?, ?)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(sql)) {
                        insertStmt.setInt(1, gioHang.getMaNguoiDung());
                        insertStmt.setInt(2, gioHang.getMaSanPham());
                        insertStmt.setInt(3, gioHang.getSoLuong());
                        int rowsAffected = insertStmt.executeUpdate();
                        return rowsAffected > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy giỏ hàng của người dùng
    public List<GioHang> getCartByUser(int maNguoiDung) {
        List<GioHang> cart = new ArrayList<>();
        String sql = "SELECT * FROM GioHang WHERE ma_nguoi_dung = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maNguoiDung);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    GioHang gioHang = new GioHang();
                    gioHang.setMaGioHang(rs.getInt("ma_gio_hang"));
                    gioHang.setMaNguoiDung(rs.getInt("ma_nguoi_dung"));
                    gioHang.setMaSanPham(rs.getInt("ma_san_pham"));
                    gioHang.setSoLuong(rs.getInt("so_luong"));
                    cart.add(gioHang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cart;
    }

    // Cập nhật số lượng sản phẩm trong giỏ
    public boolean updateCart(int maNguoiDung, int maSanPham, int soLuong) {
        String sql = "UPDATE GioHang SET so_luong = ? WHERE ma_nguoi_dung = ? AND ma_san_pham = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, soLuong);
            ps.setInt(2, maNguoiDung);
            ps.setInt(3, maSanPham);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa sản phẩm khỏi giỏ hàng
    public boolean removeFromCart(int maNguoiDung, int maSanPham) {
        String sql = "DELETE FROM GioHang WHERE ma_nguoi_dung = ? AND ma_san_pham = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maNguoiDung);
            ps.setInt(2, maSanPham);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sản phẩm đã được xóa khỏi giỏ hàng.");
            } else {
                System.out.println("Không có sản phẩm nào được xóa.");
            }
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	public boolean addToCart(int maNguoiDung, int maSanPham, int soLuong) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clearCart(int maNguoiDung) {
		// TODO Auto-generated method stub
		
	}
	
	public void clearCartByUser(int maNguoiDung) {
	    String sql = "DELETE FROM GioHang WHERE ma_nguoi_dung = ?";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, maNguoiDung);
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}