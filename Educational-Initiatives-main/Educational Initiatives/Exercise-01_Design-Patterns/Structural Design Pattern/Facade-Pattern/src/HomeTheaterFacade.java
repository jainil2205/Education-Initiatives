// Amplifier class
class Amplifier {
    public void on() {
        System.out.println("Amplifier is ON");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }

    public void off() {
        System.out.println("Amplifier is OFF");
    }
}

// DVDPlayer class
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is ON");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("Stopping the movie");
    }

    public void off() {
        System.out.println("DVD Player is OFF");
    }
}

// Projector class
class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }

    public void off() {
        System.out.println("Projector is OFF");
    }

    public void setWideScreenMode() {
        System.out.println("Setting projector to widescreen mode");
    }
}

// Lights class
class Lights {
    public void dim(int level) {
        System.out.println("Dimming lights to " + level + "%");
    }

    public void on() {
        System.out.println("Lights are ON");
    }

    public void off() {
        System.out.println("Lights are OFF");
    }
}

// PopcornMachine class
class PopcornMachine {
    public void on() {
        System.out.println("Popcorn machine is ON");
    }

    public void pop() {
        System.out.println("Popping popcorn...");
    }

    public void off() {
        System.out.println("Popcorn machine is OFF");
    }
}

// HomeTheaterFacade class
class HomeTheaterFacade {
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Lights lights;
    private PopcornMachine popcornMachine;

    // Constructor with additional devices
    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector proj, Lights lights, PopcornMachine popcorn) {
        this.amplifier = amp;
        this.dvdPlayer = dvd;
        this.projector = proj;
        this.lights = lights;
        this.popcornMachine = popcorn;
    }

    // Watch a movie with full customization
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");

        popcornMachine.on();
        popcornMachine.pop();

        lights.dim(20);  // Dim the lights for movie mode
        projector.on();
        projector.setWideScreenMode();
        
        amplifier.on();
        amplifier.setVolume(7);  // Set custom volume
        
        dvdPlayer.on();
        dvdPlayer.play(movie);

        System.out.println("Movie is starting now...");
    }

    // End movie and power off all devices
    public void endMovie() {
        System.out.println("Shutting down home theater...");

        popcornMachine.off();
        lights.on();
        projector.off();
        
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.off();
    }
}

