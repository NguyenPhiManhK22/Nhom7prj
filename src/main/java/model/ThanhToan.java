package model;

import java.sql.Timestamp;

public class ThanhToan {
    private int maThanhToan;
    private int maDonHang;
    private String phuongThuc;  // 'tien_mat', 'chuyen_khoan', 'vi_dien_tu'
    private String trangThai;    // 'cho_thanh_toan', 'da_thanh_toan', 'that_bai'
    private Timestamp ngayThanhToan;

    // Constructors
    public ThanhToan() {}

    public ThanhToan(int maDonHang, String phuongThuc, String trangThai) {
        this.maDonHang = maDonHang;
        this.phuongThuc = phuongThuc;
        this.trangThai = trangThai;
    }

    // Getter and Setter
    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getPhuongThuc() {
        return phuongThuc;
    }

    public void setPhuongThuc(String phuongThuc) {
        this.phuongThuc = phuongThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Timestamp getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Timestamp ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }
}
