package org.example.strategypattern;

public interface FlyBehaviour {
    void fly();
}

class FLyWithWings implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("FLY WITH WINGS");
    }
}

class FlyNoWay implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Cannot Fly");
    }
}
