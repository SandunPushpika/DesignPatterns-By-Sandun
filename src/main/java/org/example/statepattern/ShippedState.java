package org.example.statepattern;

public class ShippedState implements OrderState {
    @Override
    public void next(OrderContext context) {
        System.out.println("Order is already delivered/shipped. Final state.");
    }

    @Override
    public void prev(OrderContext context) {
        context.setState(new PaidState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order shipped, in transit.");
    }
}
