package com.example.lifestyle.models;

import java.io.Serializable;

public class Clothes implements Serializable {
    private String address;
    private Integer cost;
    private String img_link;
    private String name;

    public Clothes(String address, Integer cost, String img_link, String name) {
        this.address = address;
        this.cost = cost;
        this.img_link = img_link;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}