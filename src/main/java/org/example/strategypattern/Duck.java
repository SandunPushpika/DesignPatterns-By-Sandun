package org.example.strategypattern;

public class Duck {

    public FlyBehaviour flyBehaviour;
    public QuackBehaviour quackBehaviour;

    public void display() {
        System.out.println("I'm a duck");
    }
    public void swim() {
        System.out.println("I'm swimming duck");
    }

    public void performFly() {
        if(flyBehaviour != null)
            flyBehaviour.fly();
    }

    public void performQuack() {
        if(quackBehaviour != null)
            quackBehaviour.quack();
    }
}


class RedHeadDuck extends Duck{
    RedHeadDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Quack();
    }
}

class RubberDuck extends Duck {
    RubberDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Squeak();
    }
}

class MallardDuck extends Duck {

    MallardDuck() {
        flyBehaviour = new FLyWithWings();
        quackBehaviour = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a mallard duck");
    }
}