package com.polytech.guylplatteau;

/**
 * Created by vilgh on 03/01/2017.
 */
public class Strategy {

    private double price;

    double getSuggestion(double proposal, double myPrice){
        return (proposal + myPrice)/2;
    }

}
