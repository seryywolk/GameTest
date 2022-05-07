package com.codewithserdar;

import com.codewithserdar.mypackage.ISaveable;
import com.codewithserdar.mypackage.Monster;
import com.codewithserdar.mypackage.Player;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Player serdar = new Player("Serdar", 10, 15);
        System.out.println(serdar.toString());
        saveObject(serdar);
        serdar.setHitPoints(8);
        System.out.println(serdar);
        serdar.setWeapon("Stormbringer");
        saveObject(serdar);
        System.out.println(serdar);
        ISaveable wereWolf = new Monster("Werewolf", 20, 40);
        System.out.println("Strength = " + ((Monster)wereWolf).getStrength());
        saveObject(wereWolf);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n1 to enter a string\n0 to quit");

        while(!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    ++index;
            }
        }

        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for(int i = 0; i < objectToSave.write().size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = (String)objectToSave.write().get(i);
            var10000.println("Saving " + var10001 + " to storage device");
        }

    }

    public static void loadObject(ISaveable objectLoad) {
        ArrayList<String> values = readValues();
        objectLoad.read(values);
    }
}
