// Demo class
public class HomeTheaterDemo {
    public static void main(String[] args) {
        // Create devices
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();
        PopcornMachine popcornMachine = new PopcornMachine();

        // Create the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, lights, popcornMachine);

        // Watch a movie
        homeTheater.watchMovie("Inception");

        // End the movie
        homeTheater.endMovie();
    }
}
