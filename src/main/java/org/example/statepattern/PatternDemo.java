package org.example.statepattern;

public class PatternDemo {
    public static void main(String[] args) {
        OrderContext context = new OrderContext();
        context.printStatus();

        context.nextState();
        context.printStatus();

        context.nextState();
        context.printStatus();

        context.nextState();
    }
}
