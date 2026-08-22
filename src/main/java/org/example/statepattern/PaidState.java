package org.example.statepattern;

public class PaidState implements OrderState {
    @Override
    public void next(OrderContext context) {
        context.setState(new ShippedState());
    }

    @Override
    public void prev(OrderContext context) {
        context.setState(new NewState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order paid, preparing for shipment.");
    }
}
