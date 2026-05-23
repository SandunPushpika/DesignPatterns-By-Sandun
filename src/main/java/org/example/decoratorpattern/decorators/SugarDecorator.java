package org.example.decoratorpattern.decorators;

import org.example.decoratorpattern.interfaces.Coffee;

public class SugarDecorator extends CoffeeDecorator{

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public double getCost() {
        return super.getCost() + 0.4;
    }

    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}
