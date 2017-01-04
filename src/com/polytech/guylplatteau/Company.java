package com.polytech.guylplatteau;

import java.util.List;

/**
 * Created by vilgh on 03/01/2017.
 */
public class Company extends Negociator {

    private String name;
    private List<Service> services;
    private int nbMaxOfNegociations;

    public Company(String name, List<Service> services, int nbMaxOfNegociations) {
        this.name = name;
        this.services = services;
        this.nbMaxOfNegociations = nbMaxOfNegociations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public int getNbMaxOfNegociations() {
        return nbMaxOfNegociations;
    }

    public void setNbMaxOfNegociations(int nbMaxOfNegociations) {
        this.nbMaxOfNegociations = nbMaxOfNegociations;
    }

    @Override
    void negociate() {
    }

    @Override
    public void onPropose(Message message) {

    }

    @Override
    public void onAcceptance(Message message) {

    }

    @Override
    public void onCallForBids(Message message) {
        message.getEmmiter().receiveMessage(Performatif.Propose, this, message.getEmmiter(), message, services.get(0).getPrice());
    }

    @Override
    public void onCounterPropose(Message message) {

    }

    @Override
    public void onRefuse(Message message) {

    }
}
