package org.example.statepattern;

public class NewState implements OrderState {
    @Override
    public void next(OrderContext context) {
        context.setState(new PaidState());
    }

    @Override
    public void prev(OrderContext context) {
        System.out.println("The order is in its root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Order placed, pending payment.");
    }
}
