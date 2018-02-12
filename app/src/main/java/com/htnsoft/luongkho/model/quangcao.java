package com.htnsoft.luongkho.model;

/**
 * Created by TRUNG VAN on 2/11/2018.
 */

public class quangcao {
    public int MaQC;
    public String TenQC;
    public String MoTaQC;
    public String HinhAnhQC;

    public quangcao(int maQC, String tenQC, String moTaQC, String hinhAnhQC) {
        MaQC = maQC;
        TenQC = tenQC;
        MoTaQC = moTaQC;
        HinhAnhQC = hinhAnhQC;
    }

    public int getMaQC() {
        return MaQC;
    }

    public void setMaQC(int maQC) {
        MaQC = maQC;
    }

    public String getTenQC() {
        return TenQC;
    }

    public void setTenQC(String tenQC) {
        TenQC = tenQC;
    }

    public String getMoTaQC() {
        return MoTaQC;
    }

    public void setMoTaQC(String moTaQC) {
        MoTaQC = moTaQC;
    }

    public String getHinhAnhQC() {
        return HinhAnhQC;
    }

    public void setHinhAnhQC(String hinhAnhQC) {
        HinhAnhQC = hinhAnhQC;
    }
}
