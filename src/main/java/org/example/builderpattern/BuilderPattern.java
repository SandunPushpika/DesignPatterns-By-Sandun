package org.example.builderpattern;

public class BuilderPattern {
    public static void main(String[] args) {
        AbstractCarBuilder abstractCarBuilder = new BmwCarBuilder();
        Car car = abstractCarBuilder.id(12)
                .model("Td_model")
                .build();

        System.out.println("Car Id: " + car.getId());
        System.out.println("Car Model: " + car.getModel());
        System.out.println("Car Brand: " + car.getBrand());
    }
}
