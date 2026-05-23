package org.example.decoratorpattern;

import org.example.decoratorpattern.decorators.MilkDecorator;
import org.example.decoratorpattern.decorators.SugarDecorator;
import org.example.decoratorpattern.interfaces.Coffee;

public class PatternDemo {

    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffe();
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
        System.out.println();

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
        System.out.println();

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
        System.out.println();

    }

}
