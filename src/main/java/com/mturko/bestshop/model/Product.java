package com.mturko.bestshop.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
 public class Product extends AbstractEntity{

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", creationDate=" + getCreatedOn() +
                ", updateDate=" + getUpdatedOn() +
                '}';
    }
}
