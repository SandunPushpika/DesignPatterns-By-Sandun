package org.example.prototypepattern;

public class PatternDemo {
    public static void main(String[] args) {
        Monster redMonster = new Monster("Fire Monster", 100, 20);
        System.out.println("Original: " + redMonster);

        Monster clonedMonster = (Monster) redMonster.clone();
        clonedMonster.setHealth(80);
        clonedMonster.setSpeed(25);
        System.out.println("Cloned and modified: " + clonedMonster);
        System.out.println("Original remains unchanged: " + redMonster);
    }
}
