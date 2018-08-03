package com.company;

public class Rocket implements Spaceship {

    int weightRocket;
    int maxWeight;
    double costRocket;
    double chanceLaunchExplosion;
    double chanceLandExplosion;

    public Rocket() {
        this.weightRocket = 0;
        this.maxWeight = 0;
        costRocket = 0.;
        chanceLaunchExplosion = 0.;
        chanceLandExplosion = 0.;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        /* takes an Item as an argument and returns true if the rocket
        can carry such item or false if it will exceed the weight limit  */
        return ((this.weightRocket + item.weight) <= this.maxWeight);
    }

    @Override
    public int carry(Item item) {
        /* takes an Item object and updates the current weight of the rocket */
        return this.weightRocket += item.weight;
    }
}
