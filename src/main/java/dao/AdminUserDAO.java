package dao;

import model.NguoiDung;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminUserDAO {

    // Lấy tất cả người dùng
    public List<NguoiDung> getAllUsers() {
        List<NguoiDung> users = new ArrayList<>();
        String sql = "SELECT * FROM NguoiDung";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                NguoiDung user = new NguoiDung();
                user.setMaNguoiDung(rs.getInt("ma_nguoi_dung"));
                user.setHoTen(rs.getString("ho_ten"));
                user.setEmail(rs.getString("email"));
                user.setVaiTro(rs.getString("vai_tro"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Lấy thông tin người dùng theo ID
    public NguoiDung getUserById(int maNguoiDung) {
        NguoiDung user = null;
        String sql = "SELECT * FROM NguoiDung WHERE ma_nguoi_dung = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maNguoiDung);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new NguoiDung();
                    user.setMaNguoiDung(rs.getInt("ma_nguoi_dung"));
                    user.setHoTen(rs.getString("ho_ten"));
                    user.setEmail(rs.getString("email"));
                    user.setVaiTro(rs.getString("vai_tro"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Cập nhật thông tin người dùng
    public boolean updateUser(NguoiDung user) {
        String sql = "UPDATE NguoiDung SET ho_ten = ?, email = ?, vai_tro = ? WHERE ma_nguoi_dung = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getHoTen());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getVaiTro());
            ps.setInt(4, user.getMaNguoiDung());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa người dùng
    public boolean deleteUser(int maNguoiDung) {
        String sql = "DELETE FROM NguoiDung WHERE ma_nguoi_dung = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maNguoiDung);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public int getTotalUsers() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM NguoiDung"; // Giả sử bảng người dùng của bạn là "NguoiDung"

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
