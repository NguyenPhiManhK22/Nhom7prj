package model;

import java.sql.Timestamp;

public class DonHang {

    private int maDonHang;      // Mã đơn hàng
    private int maNguoiDung;    // Mã người dùng (liên kết với bảng NguoiDung)
    private double tongTien;    // Tổng tiền đơn hàng
    private String trangThai;   // Trạng thái đơn hàng ('cho_xu_ly', 'dang_van_chuyen', 'da_giao', 'da_huy')
    private Timestamp ngayTao;  // Thời gian tạo đơn hàng

    // Getters and Setters
    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }
}
