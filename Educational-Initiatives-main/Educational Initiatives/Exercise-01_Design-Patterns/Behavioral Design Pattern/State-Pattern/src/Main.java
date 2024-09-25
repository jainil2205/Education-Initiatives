// Demo class
public class TrafficLightDemo {
    public static void main(String[] args) {
        // Create a TrafficLight instance
        TrafficLight trafficLight = new TrafficLight();

        // Add observers
        trafficLight.addObserver(new PedestrianObserver());
        trafficLight.addObserver(new CarObserver());

        // Start the traffic light with custom durations (milliseconds)
        trafficLight.start(3000, 5000, 2000);  // Red for 3 sec, Green for 5 sec, Yellow for 2 sec

        // Run for 20 seconds and then stop
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                trafficLight.stop();
                System.out.println("Traffic light stopped.");
            }
        }, 20000);
    }
}
