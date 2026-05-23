package org.example.decoratorpattern;

import org.example.decoratorpattern.interfaces.Coffee;

public class Espresso implements Coffee {
    @Override
    public double getCost() {
        return 3.5;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}
