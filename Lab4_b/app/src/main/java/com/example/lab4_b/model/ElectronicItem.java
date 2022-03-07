package com.example.lab4_b.model;

public class ElectronicItem {
    private int idItem;
    private String name;
    private String slDanhGia;
    private String gia;
    private String sale;
    public ElectronicItem(int id, String name, String slDanhGia, String gia, String sale){
        this.idItem = id;
        this.name = name;
        this.slDanhGia = slDanhGia;
        this.gia = gia;
        this.sale = sale;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSlDanhGia(String slDanhGia) {
        this.slDanhGia = slDanhGia;
    }

    public String getSlDanhGia() {
        return slDanhGia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getGia() {
        return gia;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getSale() {
        return sale;
    }
}
