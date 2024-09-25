import java.util.Stack;

// Command interface
interface Command {
    void execute();
    void undo();
}

// Light class with more functionalities
class Light {
    private int brightness = 0;

    public void turnOn() {
        brightness = 100;
        System.out.println("Light is ON with brightness: " + brightness + "%");
    }

    public void turnOff() {
        brightness = 0;
        System.out.println("Light is OFF");
    }

    public void dim(int level) {
        brightness = level;
        System.out.println("Light dimmed to: " + brightness + "%");
    }

    public int getBrightness() {
        return brightness;
    }
}

// LightOnCommand with undo functionality
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

// LightOffCommand with undo functionality
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

// LightDimCommand for adjusting brightness with undo support
class LightDimCommand implements Command {
    private Light light;
    private int previousBrightness;
    private int newBrightness;

    public LightDimCommand(Light light, int newBrightness) {
        this.light = light;
        this.newBrightness = newBrightness;
    }

    @Override
    public void execute() {
        previousBrightness = light.getBrightness();
        light.dim(newBrightness);
    }

    @Override
    public void undo() {
        light.dim(previousBrightness);
    }
}

// RemoteControl class with history and undo feature
class RemoteControl {
    private Command currentCommand;
    private Stack<Command> commandHistory = new Stack<>();

    public void setCommand(Command command) {
        this.currentCommand = command;
    }

    public void pressButton() {
        currentCommand.execute();
        commandHistory.push(currentCommand);
    }

    public void pressUndo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("No commands to undo");
        }
    }
}

