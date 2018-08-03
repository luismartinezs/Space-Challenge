package com.company;

import javax.sound.midi.SysexMessage;
import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        double avCostu1 = 0.;
        double avCostu2 = 0.;
        int iterations = 100;

        for(int i=0; i<iterations; i++) {
            // Create a Simulation object
            Simulation simulation = new Simulation();

            // Load Items for Phase-1 and Phase-2
            File file1 = new File("phase-1.txt");
            ArrayList<Item> phase1Items = simulation.loadItems(file1);

            File file2 = new File("phase-2.txt");
            ArrayList<Item> phase2Items = simulation.loadItems(file2);

            // Load a fleet of U1 rockets for Phase-1 and then for Phase-2
            ArrayList<Rocket> u1List = simulation.loadU1(phase1Items);
            ArrayList<Rocket> u2List = simulation.loadU2(phase1Items);
            // Add Phase-2 rockets to Phase-1 rockets
            u1List.addAll(simulation.loadU1(phase2Items));
            u2List.addAll(simulation.loadU2(phase2Items));

            // Run the simulation using the fleet of U1 rockets and display the total budget required

            avCostu1 += simulation.runSimulation(u1List);
            avCostu2 += simulation.runSimulation(u2List);

            // System.out.println("The total cost of using U1 rockets is: " + simulation.runSimulation(u1List));
            // System.out.println("The total cost of using U2 rockets is: " + simulation.runSimulation(u2List));

            // Repeat the same for U2 rockets and display the total budget for that.
        }

        System.out.println("Average cost for U1 rockets after "+iterations+" simulations was "+avCostu1/iterations);
        System.out.println("Average cost for U2 rockets after "+iterations+" simulations was "+avCostu2/iterations);

    }
}
