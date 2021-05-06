package com.mturko.bestshop.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order extends AbstractEntity{

    private User user;

    private String date;

    private String status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", id=" + id +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
