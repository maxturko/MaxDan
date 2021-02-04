package com.mturko.bestshop.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
 public class Product extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    @Column(name = "ID")
//    private Long id;
    private String name;
    private int price;
    private LocalDateTime creationDate;

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

    @Override
    public String toString() {
        return "Product{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", creationDate=" + creationDate +
                '}';
    }
}
