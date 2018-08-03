package com.company;

import java.awt.desktop.SystemSleepEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    // loads all items from a text file and returns an ArrayList of Items
    ArrayList loadItems(File file) throws Exception {
        // creates a list of item objects
        ArrayList<Item> itemList = new ArrayList();
        // scans the file contents
        Scanner fileScanner = new Scanner(file);
        while(fileScanner.hasNextLine()){
            // creates a new item with 2 fields String and int
            Item item = new Item();
            // records line into line String variable
            String line = fileScanner.nextLine();
            // splits line in two differetn Strings and stores them in a String array
            String[] lineArray = line.split("=");
            item.name = lineArray[0];
            item.weight = Integer.parseInt(lineArray[1]);
            item.weight = item.weight / 1000;
            itemList.add(item);
        }
        // this list should be a list of items, each with its String name and int weight
        return itemList;

    }

    /*
    takes the ArrayList of Items returned from loadItems and starts creating U1 rockets. It first tries to fill up 1
     rocket with as many items as possible before creating a new rocket object and filling that one until all items are
      loaded. The method then returns the ArrayList of those U1 rockets that are fully loaded.
     */
    ArrayList<Rocket> loadU1(ArrayList<Item> itemListStatic){
        // Generate copy of itemList so that it doesn't get emptied
        ArrayList<Item> itemList = ((ArrayList) itemListStatic.clone());
        ArrayList<Rocket> U1List = new ArrayList<Rocket>();
        while (itemList.size() > 0) {
            // I need a loop that cycles once for each rocket, 'when rocket is full'
            U1 u1 = new U1();
            U1List.add(u1);
            for (int i = 0; i < itemList.size(); i++) {
                if (u1.canCarry(itemList.get(i))) {
                    u1.weightRocket = u1.carry(itemList.get(i));
                    itemList.remove(i);
                    i --;
                }
            }
        }
        return U1List;

    }

    ArrayList<Rocket> loadU2(ArrayList<Item> itemListStatic){
        // Generate copy of itemList so that it doesn't get emptied
        ArrayList<Item> itemList = ((ArrayList) itemListStatic.clone());
        ArrayList<Rocket> U2List = new ArrayList<Rocket>();
        while (itemList.size() > 0) {
            // I need a loop that cycles once for each rocket, 'when rocket is full'
            U2 u2 = new U2();
            U2List.add(u2);
            for (int i = 0; i < itemList.size(); i++) {
                if (u2.canCarry(itemList.get(i))) {
                    u2.weightRocket = u2.carry(itemList.get(i));
                    itemList.remove(i);
                    i --;
                }
            }
        }
        return U2List;

    }


    /*
    takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList. Every
    time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again. All
    while keeping track of the total budget required to send each rocket safely to Mars. runSimulation then returns the
     total budget required to send all rockets (including the crashed ones).
     */
    double runSimulation(ArrayList<Rocket> rocketList){
        double totalBudget = 0.;
        for (Rocket curretRocket : rocketList){
            totalBudget += curretRocket.costRocket;
            while (!curretRocket.launch() || !curretRocket.land()){
                // System.out.println("A rocket exploded!");
                totalBudget += curretRocket.costRocket;
            }
        }
        return totalBudget;
    }

}
