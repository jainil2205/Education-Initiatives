import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// State interface
interface State {
    void handle(TrafficLight trafficLight);
    String getName();
}

// Red state
class RedState implements State {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Stop! The light is RED.");
        trafficLight.setState(new GreenState());
    }

    @Override
    public String getName() {
        return "Red";
    }
}

// Green state
class GreenState implements State {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Go! The light is GREEN.");
        trafficLight.setState(new YellowState());
    }

    @Override
    public String getName() {
        return "Green";
    }
}

// Yellow state
class YellowState implements State {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Caution! The light is YELLOW.");
        trafficLight.setState(new RedState());
    }

    @Override
    public String getName() {
        return "Yellow";
    }
}

// Observer interface
interface TrafficObserver {
    void update(String state);
}

// PedestrianObserver
class PedestrianObserver implements TrafficObserver {
    @Override
    public void update(String state) {
        System.out.println("Pedestrian sees the light is now: " + state);
    }
}

// CarObserver
class CarObserver implements TrafficObserver {
    @Override
    public void update(String state) {
        System.out.println("Car sees the light is now: " + state);
    }
}

// TrafficLight class with automatic transitions and observer pattern
class TrafficLight {
    private State currentState;
    private List<TrafficObserver> observers = new ArrayList<>();
    private Timer timer;

    public TrafficLight() {
        this.currentState = new RedState();  // Default initial state
    }

    // Add observer
    public void addObserver(TrafficObserver observer) {
        observers.add(observer);
    }

    // Set a new state and notify observers
    public void setState(State state) {
        currentState = state;
        notifyObservers();
    }

    // Notify all observers when the state changes
    private void notifyObservers() {
        for (TrafficObserver observer : observers) {
            observer.update(currentState.getName());
        }
    }

    // Change the state and schedule the next one automatically
    public void change() {
        currentState.handle(this);
    }

    // Start the automatic transition between states with customizable intervals
    public void start(int redDuration, int greenDuration, int yellowDuration) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                change();
            }
        }, 0, getDurationForState(currentState, redDuration, greenDuration, yellowDuration));
    }

    // Cancel the automatic transitions
    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }

    // Helper method to get the duration based on the current state
    private int getDurationForState(State state, int redDuration, int greenDuration, int yellowDuration) {
        if (state instanceof RedState) {
            return redDuration;
        } else if (state instanceof GreenState) {
            return greenDuration;
        } else {
            return yellowDuration;
        }
    }
}

