package com.codewithserdar.mypackage;

import com.codewithserdar.mypackage.ISaveable;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return this.name;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public int getStrength() {
        return this.strength;
    }

    public List<String> write() {
        ArrayList<String> values = new ArrayList();
        values.add(0, this.name);
        values.add(1, this.hitPoints.makeConcatWithConstants<invokedynamic>(this.hitPoints));
        values.add(2, this.strength.makeConcatWithConstants<invokedynamic>(this.strength));
        return values;
    }

    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            this.name = (String)savedValues.get(0);
            this.hitPoints = Integer.parseInt((String)savedValues.get(1));
            this.strength = Integer.parseInt((String)savedValues.get(2));
        }

    }

    public String toString() {
        return "Monster{name='" + this.name + "', hitPoints=" + this.hitPoints + ", strength=" + this.strength + "}";
    }
}