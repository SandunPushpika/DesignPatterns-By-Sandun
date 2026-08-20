package org.example.factorypattern;

public class VeggiePizza extends Pizza {
    public VeggiePizza() {
        super.name = "Veggie Pizza";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Veggie Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Veggie Pizza");
    }
}
