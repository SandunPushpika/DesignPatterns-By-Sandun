package org.example.factorypattern;

public class NewYorkPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChickenPizza();
        }else{
            return null;
        }
    }
}
