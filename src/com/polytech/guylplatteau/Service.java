package com.polytech.guylplatteau;

import java.util.Date;

public class Service {

    private String departure, destination;
    private double price;
    private Date date;

    public Service(String departure, String destination, double price, Date date) {
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.date = date;
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

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
