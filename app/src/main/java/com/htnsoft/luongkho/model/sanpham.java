package com.htnsoft.luongkho.model;

/**
 * Created by TRUNG VAN on 2/10/2018.
 */

public class sanpham {
    public int MaSP;
    public String TenSP;
    public Integer GiaSP;
    public String MoTaSP;
    public String HinhAnhSP;
    public int LoaiSP;

    public sanpham(int maSP, String tenSP, Integer giaSP, String moTaSP, String hinhAnhSP, int loaiSP) {
        MaSP = maSP;
        TenSP = tenSP;
        GiaSP = giaSP;
        MoTaSP = moTaSP;
        HinhAnhSP = hinhAnhSP;
        LoaiSP = loaiSP;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public Integer getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(Integer giaSP) {
        GiaSP = giaSP;
    }

    public String getMoTaSP() {
        return MoTaSP;
    }

    public void setMoTaSP(String moTaSP) {
        MoTaSP = moTaSP;
    }

    public String getHinhAnhSP() {
        return HinhAnhSP;
    }

    public void setHinhAnhSP(String hinhAnhSP) {
        HinhAnhSP = hinhAnhSP;
    }

    public int getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(int loaiSP) {
        LoaiSP = loaiSP;
    }
}
