package com.company;

public class U2 extends Rocket {

    public U2() {
        costRocket = 120000000;
        weightRocket = 18;
        maxWeight = 29;
        chanceLaunchExplosion = 0.04 * ((double)weightRocket / (double)maxWeight);
        chanceLandExplosion = 0.08 * ((double) weightRocket / (double) maxWeight);
    }

/*
    Rocket cost = $120 Million
    Rocket weight = 18 Tonnes
    Max weight (with cargo) = 29 Tonnes
    Chance of launch explosion = 4% * (cargo carried / cargo limit)
    Chance of landing crash = 8% * (cargo carried / cargo limit)
     */

    public boolean land(){
        double random = Math.random();
        return random > this.chanceLaunchExplosion;
    }

    public boolean launch(){
        double random = Math.random();
        return random > this.chanceLandExplosion;
    }
}
