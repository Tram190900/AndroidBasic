package com.example.lab6_b;

public class Shoes {
    private int img;
    private String moTa;


    public Shoes(int img, String moTa) {
        this.img = img;
        this.moTa = moTa;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getImg() {
        return img;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
