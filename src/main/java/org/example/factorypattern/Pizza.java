package org.example.factorypattern;

public abstract class Pizza {
    public String name;
    public String other;

    public abstract void prepare();
    public abstract void bake();

    public void cut(){
        System.out.println("Cutting the pizza: "+ name);
    }

    public void box() {
        System.out.println("Pizza Boxing: "+ name);
    }
}
