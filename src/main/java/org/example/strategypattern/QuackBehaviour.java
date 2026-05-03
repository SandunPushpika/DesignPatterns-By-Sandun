package org.example.strategypattern;

public interface QuackBehaviour {
    void quack();
}


class Quack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}

class Silent implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Silent");
    }
}

class Squeak implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}