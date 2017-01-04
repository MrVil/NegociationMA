package com.polytech.guylplatteau;

import java.util.Date;
import java.util.List;

public class Consumer extends Negociator {
    private List<String> compagniesAccepted, companiesRefused;
    private String departure, destination;
    private double maximalPrice;
    private Date latestDate;
    private List<Company> companies;
    private Strategy strategy;

    public Consumer(List<String> compagniesAccepted, List<String> companiesRefused, String departure, String destination, double maximalPrice, Date latestDate, List<Company> companies) {
        this.compagniesAccepted = compagniesAccepted;
        this.companiesRefused = companiesRefused;
        this.departure = departure;
        this.destination = destination;
        this.maximalPrice = maximalPrice;
        this.latestDate = latestDate;
        this.companies = companies;
    }

    public Consumer(List<String> companiesRefused, String departure, String destination, double maximalPrice, Date latestDate, List<Company> companies) {
        this.companiesRefused = companiesRefused;
        this.departure = departure;
        this.destination = destination;
        this.maximalPrice = maximalPrice;
        this.latestDate = latestDate;
        this.companies = companies;
    }

    public Consumer(String departure, String destination, double maximalPrice, Date latestDate, List<Company> companies) {
        this.departure = departure;
        this.destination = destination;
        this.maximalPrice = maximalPrice;
        this.latestDate = latestDate;
        this.companies = companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
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
        for (Company company : companies){
            company.receiveMessage(new Message(Performatif.CallForBids, this, company, null, 0));
        }
    }

    @Override
    public void onPropose(Message message) {
        if(message.getPrice() < maximalPrice)
            message.getEmmiter().receiveMessage(new Message(Performatif.Acceptance, this, message.getEmmiter(), message, message.getPrice()));
        else
            message.getEmmiter().receiveMessage(new Message(Performatif.CounterPropose, this, message.getEmmiter(), message, strategy.getSuggestion(message.getPrice(), maximalPrice)));
    }

    @Override
    public void onAcceptance(Message message) {
        System.out.println("Consumer received : Accept");
    }

    @Override
    public void onCallForBids(Message message) {

    }

    @Override
    public void onCounterPropose(Message message) {
        onPropose(message);
    }

    @Override
    public void onRefuse(Message message) {
        System.out.println("Consumer received : Refused");
    }
}
