package org.example.facadepattern;

public class Amplifier {
    public void on() {
        System.out.println("Amplifier turned on.");
    }

    public void setVolume(int volume) {
        System.out.println("Amplifier volume set to " + volume);
    }

    public void off() {
        System.out.println("Amplifier turned off.");
    }
}
