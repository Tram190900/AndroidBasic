package com.example.lab4_a.Model;

public class Language {
    private int id;
    private String name;
    private String shop;

    public Language(int id, String name, String shop){
        this.id = id;
        this.name = name;
        this.shop = shop;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  String getShop(){
        return shop;
    }
    public  void  setShop(String shop){
        this.shop = shop;
    }
}
