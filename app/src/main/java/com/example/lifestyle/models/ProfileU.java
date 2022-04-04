package com.example.lifestyle.models;

public class ProfileU {
    String Name;
   String color, style, brand, size, gender,season,price,print;

    public ProfileU() {
        this.Name = Name;

        this.color = "0";
        this.style = "0";

        this.brand = "0";
        this.size = "0";

        this.price = "0";
        this.print = "0";
    }

    public ProfileU(String name, String mmr, String color, String style, String brand, String size, String gender, String season,String price,String print) {
        this.Name = name;
        //1
        this.color = color;
        this.style = style;
        //2
        this.brand = brand;
        this.size = size;
        //3
        this.gender = gender;
        this.season = season;
        //4
        this.price = price;
        this.print = print;
    }

    //геттер и сеттер ИМЯ
    public String getName() {return this.Name;}
    public void setName(String name) {
        this.Name = name;
    }

    //геттер и сеттер  ЦВЕТ
    public String getColor() {return this.color;}
    public void setColor(String color) {this.color = color;}

    //геттер и сеттер СТИЛЬ
    public String getStyle() {return this.style;}
    public void setStyle(String style) {this.style = style;}

    //геттер и сеттер БРЕНД
    public String getBrand() {return this.brand;}
    public void setBrand(String brand) {this.brand = brand;}

    //геттер и сеттер РАЗМЕР
    public String getSize() {return this.size;}
    public void setSize(String size) {this.size = size;}

    //геттер и сеттер ПОЛ
    public String getGender() {return this.gender;}
    public void setGender(String gender) {this.gender = gender;}

    //геттер и сеттер СЕЗОН
    public String getSeason() {return this.season;}
    public void setSeason(String season) {this.season = season;}

    //геттер и сеттер ЦЕНА
    public String getPrice() {return this.price;}
    public void setPrice(String price) {this.price = price;}

    //геттер и сеттер ПРИНТ
    public String getPrint() {return this.print;}
    public void setPrint(String print) {this.print = print;}

}
