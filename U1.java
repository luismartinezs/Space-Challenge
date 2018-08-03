package com.company;

public class U1 extends Rocket {

    public U1() {
        weightRocket = 10;
        maxWeight = 18;
        costRocket = 100000000;
        chanceLaunchExplosion = 0.05 * ((double) weightRocket / (double) maxWeight);
        chanceLandExplosion = 0.01 * ((double) weightRocket / (double) maxWeight);
    }

    /*
    Rocket cost = $100 Million
    Rocket weight = 10 Tonnes
    Max weight (with cargo) = 18 Tonnes
    Chance of launch explosion = 5% * (cargo carried / cargo limit)
    Chance of landing crash = 1% * (cargo carried / cargo limit)
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
