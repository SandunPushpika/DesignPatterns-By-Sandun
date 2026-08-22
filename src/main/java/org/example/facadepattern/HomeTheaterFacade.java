package org.example.facadepattern;

public class HomeTheaterFacade {
    private Amplifier amp;
    private Projector projector;
    private SoundSystem sound;

    public HomeTheaterFacade(Amplifier amp, Projector projector, SoundSystem sound) {
        this.amp = amp;
        this.projector = projector;
        this.sound = sound;
    }

    public void watchMovie() {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.setWideScreenMode();
        amp.on();
        amp.setVolume(10);
        sound.on();
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        projector.off();
        amp.off();
        sound.off();
    }
}
