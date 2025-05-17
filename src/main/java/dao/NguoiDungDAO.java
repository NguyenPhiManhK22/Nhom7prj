package dao;

import db.DBConnection;
import model.NguoiDung;

import java.sql.*;

public class NguoiDungDAO {

    public boolean kiemTraDangNhap(String email, String matKhau) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM NguoiDung WHERE email=? AND mat_khau=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, matKhau);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean dangKyNguoiDung(NguoiDung nguoiDung) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO NguoiDung (ho_ten, email, mat_khau, so_dien_thoai, dia_chi, vai_tro) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nguoiDung.getHoTen());
            stmt.setString(2, nguoiDung.getEmail());
            stmt.setString(3, nguoiDung.getMatKhau());
            stmt.setString(4, nguoiDung.getSoDienThoai());
            stmt.setString(5, nguoiDung.getDiaChi());
            stmt.setString(6, nguoiDung.getVaiTro());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Email đã tồn tại!");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
