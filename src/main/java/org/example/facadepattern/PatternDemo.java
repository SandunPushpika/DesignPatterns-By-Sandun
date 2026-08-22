package org.example.facadepattern;

public class PatternDemo {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, projector, sound);
        homeTheater.watchMovie();
        System.out.println("--- Movie Playing ---");
        homeTheater.endMovie();
    }
}
