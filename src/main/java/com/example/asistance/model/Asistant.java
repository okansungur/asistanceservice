package com.example.asistance.model;

public class Asistant {
    private int id;
    private String name;
    private String address;
    private int userid;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Asistant(int id, String name, String address, int userid) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.userid = userid;
    }

    public Asistant() {
    }
}
