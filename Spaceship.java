package com.company;

public interface Spaceship {

    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    int carry(Item item);

}
