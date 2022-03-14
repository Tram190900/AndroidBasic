package com.example.ongk;

public class Donut {
    private int id;
    private String ten;
    private String moTa;
    private String gia;
    private String loai;

    public Donut(int id, String ten, String moTa, String gia, String loai){
        this.id = id;
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
        this.loai = loai;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getTen() {
        return ten;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
