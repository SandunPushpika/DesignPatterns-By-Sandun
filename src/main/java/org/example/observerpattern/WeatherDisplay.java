package org.example.observerpattern;

import org.example.observerpattern.interfaces.Display;
import org.example.observerpattern.interfaces.Observer;

public class WeatherDisplay implements Observer, Display {

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public WeatherDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Weather Display");
        System.out.println("Temperature: "+ temperature);
        System.out.println("Humidity: "+ humidity);
        System.out.println("Pressure: "+ pressure);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();
        display();
    }
}
