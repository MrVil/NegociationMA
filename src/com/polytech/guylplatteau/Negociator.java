package com.polytech.guylplatteau;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vilgh on 03/01/2017.
 */
public abstract class Negociator extends Thread {

    private Strategy strategy;
    private List<Message> messages = new ArrayList();

    abstract void negociate();

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void receiveMessage(Message message){
        messages.add(message);

        if(message.getPerformatif() == Performatif.Propose)
            onPropose(message);
        else if(message.getPerformatif() == Performatif.Acceptance)
            onAcceptance(message);
        else if(message.getPerformatif() == Performatif.CallForBids)
            onCallForBids(message);
        else if (message.getPerformatif() == Performatif.CounterPropose)
            onCounterPropose(message);
        else if (message.getPerformatif() == Performatif.Refuse)
            onRefuse(message);

    }

    public abstract void onPropose(Message message);
    public abstract void onAcceptance(Message message);
    public abstract void onCallForBids(Message message);
    public abstract void onCounterPropose(Message message);
    public abstract void onRefuse(Message message);


}
