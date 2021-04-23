package com.mturko.bestshop.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
 public class Product extends AbstractEntity{

    private String name;
    private int price;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
