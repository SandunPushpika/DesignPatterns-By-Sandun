package org.example.observerpattern;

import org.example.observerpattern.interfaces.Display;
import org.example.observerpattern.interfaces.Observer;

public class StatisticsDisplay implements Observer, Display {

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Statistics Display");
        System.out.println("Display average temperature: " + temperature);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();
        display();
    }
}
