package org.example.decoratorpattern;

import org.example.decoratorpattern.interfaces.Coffee;

public class SimpleCoffe implements Coffee {
    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}
