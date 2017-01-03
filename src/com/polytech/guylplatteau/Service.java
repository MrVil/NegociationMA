package com.polytech.guylplatteau;

import java.util.Date;

/**
 * Created by vilgh on 03/01/2017.
 */
public class Service {

    private String company;
    private double price;
    private Date date;

    public Service(String company, double price, Date date) {
        this.company = company;
        this.price = price;
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
