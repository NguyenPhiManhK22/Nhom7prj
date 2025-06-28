package dao;

import java.sql.*;

import db.DBConnection;

public class ThanhToanDAO {

    public boolean createThanhToan(int maNguoiDung, String phuongThucThanhToan, double tongTien) {
        String sql = "INSERT INTO ThanhToan (ma_don_hang, phuong_thuc, trang_thai) VALUES (?, ?, 'cho_thanh_toan')";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, maNguoiDung);
            ps.setString(2, phuongThucThanhToan);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int maThanhToan = rs.getInt(1);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	public boolean processPayment(int maNguoiDung, double totalAmount, String phuongThucThanhToan) {
		// TODO Auto-generated method stub
		return false;
	}
}