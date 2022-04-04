package com.example.lab7_listtravel;

public class Travel {
    private int id;
    private String name;

    public Travel(){

    }
    public Travel(String name){
        this.name = name;
    }
    public Travel(int id, String name){
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
