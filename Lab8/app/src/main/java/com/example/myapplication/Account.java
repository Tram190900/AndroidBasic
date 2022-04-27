package com.example.myapplication;

public class Account {
    private String eMail;
    private String name;
    private String password;
    private int smile;
    private int normal;
    private int sad;

    public String geteMail() {
        return eMail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSmile() {
        return smile;
    }

    public void setSmile(int smile) {
        this.smile = smile;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getSad() {
        return sad;
    }

    public void setSad(int sad) {
        this.sad = sad;
    }

    public Account(String eMail, String name, String password, int smile, int normal, int sad) {
        this.eMail = eMail;
        this.name = name;
        this.password = password;
        this.smile = smile;
        this.normal = normal;
        this.sad = sad;
    }
    public Account(){

    }

    @Override
    public String toString() {
        return "Account{" +
                "smile=" + smile +
                ", normal=" + normal +
                ", sad=" + sad +
                '}';
    }
}
