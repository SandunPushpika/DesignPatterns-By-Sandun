package org.example.observerpattern;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        WeatherDisplay display = new WeatherDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(12, 45, 65);
        weatherData.setMeasurements(13, 55, 60);
    }
}
