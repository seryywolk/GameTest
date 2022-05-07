package com.codewithserdar.mypackage;

import com.codewithserdar.mypackage.ISaveable;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String toString() {
        return "Player{name='" + this.name + "', hitPoints=" + this.hitPoints + ", strength=" + this.strength + ", weapon='" + this.weapon + "'}";
    }

    public List<String> write() {
        List<String> values = new ArrayList();
        values.add(0, this.name);
        values.add(1, this.hitPoints.makeConcatWithConstants<invokedynamic>(this.hitPoints));
        values.add(2, this.strength.makeConcatWithConstants<invokedynamic>(this.strength));
        values.add(3, this.weapon);
        return values;
    }

    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0) {
            this.name = (String)savedValues.get(0);
            this.hitPoints = Integer.parseInt((String)savedValues.get(1));
            this.strength = Integer.parseInt((String)savedValues.get(2));
            this.weapon = (String)savedValues.get(3);
        }

    }
}
