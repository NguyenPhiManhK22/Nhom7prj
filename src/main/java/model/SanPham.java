package model;

public class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private String moTa;
    private double gia;
    private int soLuongTrongKho;
    private int maDanhMuc;
    private String duongDanAnh;

    // Constructor
    public SanPham() {}

    public SanPham(int maSanPham, String tenSanPham, String moTa, double gia, int soLuongTrongKho, int maDanhMuc, String duongDanAnh) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.gia = gia;
        this.soLuongTrongKho = soLuongTrongKho;
        this.maDanhMuc = maDanhMuc;
        this.duongDanAnh = duongDanAnh;
    }

    // Getter - Setter
    public int getMaSanPham() { return maSanPham; }
    public void setMaSanPham(int maSanPham) { this.maSanPham = maSanPham; }

    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public double getGia() { return gia; }
    public void setGia(double gia) { this.gia = gia; }

    public int getSoLuongTrongKho() { return soLuongTrongKho; }
    public void setSoLuongTrongKho(int soLuongTrongKho) { this.soLuongTrongKho = soLuongTrongKho; }

    public int getMaDanhMuc() { return maDanhMuc; }
    public void setMaDanhMuc(int maDanhMuc) { this.maDanhMuc = maDanhMuc; }

    public String getDuongDanAnh() { return duongDanAnh; }
    public void setDuongDanAnh(String duongDanAnh) { this.duongDanAnh = duongDanAnh; }
}
