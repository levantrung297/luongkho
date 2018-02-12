package com.htnsoft.luongkho.model;

/**
 * Created by TRUNG VAN on 2/12/2018.
 */

public class danhmuc {
    private int Id;
    private String Ten;
    private String HinhAnh;

    public danhmuc(int id, String ten, String hinhAnh) {
        Id = id;
        Ten = ten;
        HinhAnh = hinhAnh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
