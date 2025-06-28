package dao;

import model.NguoiDung;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {

    // Kiểm tra đăng nhập người dùng
    public NguoiDung checkLogin(String email, String matKhau) {
        String sql = "SELECT * FROM NguoiDung WHERE email = ? AND mat_khau = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Sử dụng mật khẩu plain text trong cơ sở dữ liệu
            ps.setString(1, email);
            ps.setString(2, matKhau);  // Không mã hóa mật khẩu, so sánh trực tiếp với mật khẩu trong DB
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    NguoiDung user = new NguoiDung();
                    user.setMaNguoiDung(rs.getInt("ma_nguoi_dung"));
                    user.setHoTen(rs.getString("ho_ten"));
                    user.setEmail(email);
                    user.setVaiTro(rs.getString("vai_tro"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Kiểm tra xem email đã tồn tại chưa
    public boolean emailExists(String email) {
        String sql = "SELECT 1 FROM NguoiDung WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Đăng ký người dùng mới
    public boolean insertUser(NguoiDung user) {
        String sql = "INSERT INTO NguoiDung (ho_ten, email, mat_khau, so_dien_thoai, dia_chi, vai_tro) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getHoTen());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getMatKhau());  // Lưu mật khẩu trực tiếp mà không mã hóa
            ps.setString(4, user.getSoDienThoai());
            ps.setString(5, user.getDiaChi());
            ps.setString(6, user.getVaiTro());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
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
                user.setSoDienThoai(rs.getString("so_dien_thoai"));
                user.setDiaChi(rs.getString("dia_chi"));
                user.setVaiTro(rs.getString("vai_tro"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Cập nhật thông tin người dùng
    public boolean updateNguoiDung(NguoiDung user) {
        String sql = "UPDATE NguoiDung SET ho_ten = ?, email = ?, so_dien_thoai = ?, dia_chi = ?, vai_tro = ? WHERE ma_nguoi_dung = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getHoTen());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSoDienThoai());
            ps.setString(4, user.getDiaChi());
            ps.setString(5, user.getVaiTro());
            ps.setInt(6, user.getMaNguoiDung());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa người dùng
    public boolean deleteNguoiDung(int maNguoiDung) {
        String sql = "DELETE FROM NguoiDung WHERE ma_nguoi_dung = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maNguoiDung);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public NguoiDung getNguoiDungById(int maNguoiDung) {
        String sql = "SELECT * FROM NguoiDung WHERE ma_nguoi_dung = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maNguoiDung);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    NguoiDung user = new NguoiDung();
                    user.setMaNguoiDung(rs.getInt("ma_nguoi_dung"));
                    user.setHoTen(rs.getString("ho_ten"));
                    user.setEmail(rs.getString("email"));
                    user.setSoDienThoai(rs.getString("so_dien_thoai"));
                    user.setDiaChi(rs.getString("dia_chi"));
                    user.setVaiTro(rs.getString("vai_tro"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Nếu không tìm thấy người dùng
    }
}


