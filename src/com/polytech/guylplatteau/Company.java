package com.polytech.guylplatteau;

import java.util.List;

/**
 * Created by vilgh on 03/01/2017.
 */
public class Company extends Negociator {

    private String name;
    private List<Service> services;
    private int nbMaxOfNegociations;
    private Boolean finished = false;


    public Company(String name, List<Service> services, int nbMaxOfNegociations) {
        this.name = name;
        this.services = services;
        this.nbMaxOfNegociations = nbMaxOfNegociations;
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

    private int count(Message message) {
        int i = 1;
        Message pointer = message.getPrevious();
        assert pointer != null;
        while ((pointer = pointer.getPrevious()) != null)
            if(pointer.getPerformatif() == Performatif.CounterPropose || pointer.getPerformatif() == Performatif.Propose)
                i++;
        return i/2;
    }

    @Override
    public void run() {
        while (this.finished);
    }

    @Override
    void negociate() {
    }

    @Override
    public void onPropose(Message message) {
        System.out.println("Not implemented");
    }

    @Override
    public void onAcceptance(Message message) {
        System.out.println("Offer accepted by the consumer !");
    }

    @Override
    public void onCallForBids(Message message) {
        System.out.println("New consumer ! We propose our basic price of " + services.get(0).getPrice());
        message.getEmmiter().receiveMessage(new Message(Performatif.Propose, this, message.getEmmiter(), message, services.get(0).getPrice()));
    }

    @Override
    public void onCounterPropose(Message message) {
        if(services.get(0).getPrice() - getNbMaxOfNegociations()*0.1*services.get(0).getPrice() > message.getPrice()) {
            System.out.println("Counter Proposition is too weak !");
            message.getEmmiter().receiveMessage(new Message(Performatif.Refuse, this, message.getEmmiter(), message, null));
        }
        else if (getNbMaxOfNegociations() < count(message)) {
            System.out.println("Too much negociation !");
            message.getEmmiter().receiveMessage(new Message(Performatif.Refuse, this, message.getEmmiter(), message, null));
        }
        else {
            Message m = new Message(Performatif.Propose, this, message.getEmmiter(), message, Math.max(message.getPrevious().getPrice()-0.1*services.get(0).getPrice(), message.getPrice()));
            System.out.println("We offer at maximum 10% discount : " + m.getPrice() + " Million dollars");
            message.getEmmiter().receiveMessage(m);
        }
    }

    @Override
    public void onRefuse(Message message) {
        System.out.println("We issue a refuse, maybe we are too high !");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
