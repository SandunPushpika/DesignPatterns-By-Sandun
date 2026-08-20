package org.example.builderpattern;

public abstract class AbstractCarBuilder {
    private int id;
    protected String brand;
    private String model;
    private String color;

    public AbstractCarBuilder model(String model) {
        this.model = model;
        return this;
    }

    public AbstractCarBuilder color(String color) {
        this.color = color;
        return this;
    }

    public AbstractCarBuilder id(int id) {
        this.id = id;
        return this;
    }

    public Car build() {
        return new Car(id, brand, model, color);
    }

}
