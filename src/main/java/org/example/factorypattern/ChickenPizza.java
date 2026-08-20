package org.example.factorypattern;

public class ChickenPizza extends Pizza {

    public ChickenPizza() {
        super.name = "Chicken Pizza";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Chicken Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Chicken Pizza");
    }
}
