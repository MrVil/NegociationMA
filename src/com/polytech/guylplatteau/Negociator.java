package com.polytech.guylplatteau;

/**
 * Created by vilgh on 03/01/2017.
 */
public abstract class Negociator {

    private Strategy strategy;

    abstract void negociate();

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
