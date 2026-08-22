package org.example.prototypepattern;

public class Monster implements Prototype {
    private String type;
    private int health;
    private int speed;

    public Monster(String type, int health, int speed) {
        this.type = type;
        this.health = health;
        this.speed = speed;
    }

    public Monster(Monster source) {
        this.type = source.type;
        this.health = source.health;
        this.speed = source.speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public Prototype clone() {
        return new Monster(this);
    }

    @Override
    public String toString() {
        return "Monster{type='" + type + "', health=" + health + ", speed=" + speed + "}";
    }
}
