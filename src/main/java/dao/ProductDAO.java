package dao;

import model.SanPham;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Lấy tất cả sản phẩm từ cơ sở dữ liệu
    public List<SanPham> getAllProducts() {
        List<SanPham> products = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SanPham product = new SanPham();
                product.setMaSanPham(rs.getInt("ma_san_pham"));
                product.setTenSanPham(rs.getString("ten_san_pham"));
                product.setMoTa(rs.getString("mo_ta"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuongTrongKho(rs.getInt("so_luong_trong_kho"));
                product.setMaDanhMuc(rs.getInt("ma_danh_muc"));
                product.setDuongDanAnh(rs.getString("duong_dan_anh"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    // Lấy sản phẩm theo ID
    public SanPham getProductById(int productId) {
        SanPham product = null;
        String sql = "SELECT * FROM SanPham WHERE ma_san_pham = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product = new SanPham();
                product.setMaSanPham(rs.getInt("ma_san_pham"));
                product.setTenSanPham(rs.getString("ten_san_pham"));
                product.setMoTa(rs.getString("mo_ta"));
                product.setGia(rs.getDouble("gia"));
                product.setSoLuongTrongKho(rs.getInt("so_luong_trong_kho"));
                product.setMaDanhMuc(rs.getInt("ma_danh_muc"));
                product.setDuongDanAnh(rs.getString("duong_dan_anh"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    // Thêm sản phẩm mới vào cơ sở dữ liệu
    public boolean addProduct(SanPham product) {
        String sql = "INSERT INTO SanPham (ten_san_pham, mo_ta, gia, so_luong_trong_kho, ma_danh_muc, duong_dan_anh) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getTenSanPham());
            ps.setString(2, product.getMoTa());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuongTrongKho());
            ps.setInt(5, product.getMaDanhMuc());
            ps.setString(6, product.getDuongDanAnh());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Cập nhật thông tin sản phẩm
    public boolean updateProduct(SanPham product) {
        String sql = "UPDATE SanPham SET ten_san_pham = ?, mo_ta = ?, gia = ?, so_luong_trong_kho = ?, ma_danh_muc = ?, duong_dan_anh = ? WHERE ma_san_pham = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, product.getTenSanPham());
            ps.setString(2, product.getMoTa());
            ps.setDouble(3, product.getGia());
            ps.setInt(4, product.getSoLuongTrongKho());
            ps.setInt(5, product.getMaDanhMuc());
            ps.setString(6, product.getDuongDanAnh());
            ps.setInt(7, product.getMaSanPham());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Xóa sản phẩm khỏi cơ sở dữ liệu
    public boolean deleteProduct(int productId) {
        String sql = "DELETE FROM SanPham WHERE ma_san_pham = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, productId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public int getTotalProducts() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM SanPham"; // Giả sử bảng sản phẩm của bạn là "SanPham"

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
