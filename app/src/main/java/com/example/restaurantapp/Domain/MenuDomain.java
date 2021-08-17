package com.example.restaurantapp.Domain;

import java.io.Serializable;

public class MenuDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private Double price;
    private String numberInCard;

    public MenuDomain(String title, String pic, String description, Double price) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.price = price;
    }

    public MenuDomain(String title, String pic, String description, Double price, String numberInCard) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.price = price;
        this.numberInCard = numberInCard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(String numberInCard) {
        this.numberInCard = numberInCard;
    }
}
