package com.polytech.guylplatteau;

import java.util.Date;
import java.util.List;

public class Consumer extends Negociator {
    private List<String> compagniesAccepted, companiesRefused;
    private String departure, destination;
    private double maximalPrice;
    private Date latestDate;

    public Consumer(List<String> compagniesAccepted, List<String> companiesRefused, String departure, String destination, double maximalPrice, Date latestDate) {
        this.compagniesAccepted = compagniesAccepted;
        this.companiesRefused = companiesRefused;
        this.departure = departure;
        this.destination = destination;
        this.maximalPrice = maximalPrice;
        this.latestDate = latestDate;
    }

    public List<String> getCompagniesAccepted() {
        return compagniesAccepted;
    }

    public void setCompagniesAccepted(List<String> compagniesAccepted) {
        this.compagniesAccepted = compagniesAccepted;
    }

    public List<String> getCompaniesRefused() {
        return companiesRefused;
    }

    public void setCompaniesRefused(List<String> companiesRefused) {
        this.companiesRefused = companiesRefused;
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

    public double getMaximalPrice() {
        return maximalPrice;
    }

    public void setMaximalPrice(double maximalPrice) {
        this.maximalPrice = maximalPrice;
    }

    public Date getLatestDate() {
        return latestDate;
    }

    public void setLatestDate(Date latestDate) {
        this.latestDate = latestDate;
    }

    @Override
    void negociate() {

    }
}
