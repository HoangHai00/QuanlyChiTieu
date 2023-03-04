package com.example.quanlychitieu;

public class ChiTieu {
    private int IdChiTieu;
    private String TenKhoanChi;
    private int SoTien;
    private String NgayChi;


    public ChiTieu(int idChiTieu, String tenKhoanChi, int soTien, String ngayChi) {
        IdChiTieu = idChiTieu;
        TenKhoanChi = tenKhoanChi;
        SoTien = soTien;
        NgayChi = ngayChi;
    }

    public int getIdChiTieu() {
        return IdChiTieu;
    }

    public void setIdChiTieu(int idChiTieu) {
        IdChiTieu = idChiTieu;
    }

    public String getTenKhoanChi() {
        return TenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        TenKhoanChi = tenKhoanChi;
    }

    public int getSoTien() {
        return SoTien;
    }

    public void setSoTien(int soTien) {
        SoTien = soTien;
    }

    public String getNgayChi() {
        return NgayChi;
    }

    public void setNgayChi(String ngayChi) {
        NgayChi = ngayChi;
    }
}
