package model;

public class GioHang {
    private int maGioHang;
    private int maNguoiDung;
    private int maSanPham;
    private int soLuong;

    // Constructors
    public GioHang() {}

    public GioHang(int maNguoiDung, int maSanPham, int soLuong) {
        this.maNguoiDung = maNguoiDung;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
    }

    // Getter & Setter
    public int getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(int maGioHang) {
        this.maGioHang = maGioHang;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
