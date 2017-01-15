package com.polytech.guylplatteau;

import java.util.Date;
import java.util.List;

public class Consumer extends Negociator {
    private List<Company> compagniesAccepted, companiesRefused, companies;
    private String departure, destination;
    private double maximalPrice;
    private Date latestDate;
    private Strategy strategy = new Strategy();
    private Boolean finished = false;


    public Consumer(List<Company> compagniesAccepted, List<Company> companiesRefused, String departure, String destination, double maximalPrice, Date latestDate, List<Company> companies) {
        this.compagniesAccepted = compagniesAccepted;
        this.companiesRefused = companiesRefused;
        this.departure = departure;
        this.destination = destination;
        this.maximalPrice = maximalPrice;
        this.latestDate = latestDate;
        this.companies = companies;
    }

    public Consumer(List<Company> companiesRefused, String departure, String destination, double maximalPrice, Date latestDate, List<Company> companies) {
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
    public void run() {
        negociate();
        while (this.finished);
    }

    @Override
    void negociate() {
        for (Company company : companies){
            System.out.println("Send a call for bids to " + company.toString());
            company.receiveMessage(new Message(Performatif.CallForBids, this, company, null, 0d));
        }
    }

    @Override
    public void onPropose(Message message) {
        if(message.getPrice() < maximalPrice)
        {
            System.out.println("The offer is accepted ! Congratulation !");
            message.getEmmiter().receiveMessage(new Message(Performatif.Acceptance, this, message.getEmmiter(), message, message.getPrice()));
        }
        else if ((message.getPrice()*0.5) > getMaximalPrice())
        {
            System.out.println("Sorry, the offer is too much higher than we're looking for ! (" + message.getPrice() + " for " + getMaximalPrice() + ")");
            message.getEmmiter().receiveMessage(new Message(Performatif.Refuse, this, message.getEmmiter(), message, null));

        }
        else {
            Message m = new Message(Performatif.CounterPropose, this, message.getEmmiter(), message, strategy.getSuggestion(message.getPrice(), maximalPrice));
            System.out.println("Negociation, we propose " + m.getPrice() + " Million dollars");
            message.getEmmiter().receiveMessage(m);
        }
    }

    @Override
    public void onAcceptance(Message message) {
        System.out.println("Consumer received : Accept");
    }

    @Override
    public void onCallForBids(Message message) {
        System.err.println("Oups ! Consumer received a call for birds !");
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
