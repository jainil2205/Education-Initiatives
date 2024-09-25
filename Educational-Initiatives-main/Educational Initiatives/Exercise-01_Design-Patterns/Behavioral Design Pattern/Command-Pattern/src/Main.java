public class LightCommandDemo {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        // Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command lightDim = new LightDimCommand(livingRoomLight, 50);

        // Remote Control
        RemoteControl remote = new RemoteControl();

        // Turning the light ON
        remote.setCommand(lightOn);
        remote.pressButton();

        // Dimming the light to 50%
        remote.setCommand(lightDim);
        remote.pressButton();

        // Turning the light OFF
        remote.setCommand(lightOff);
        remote.pressButton();

        // Undo the last command (turn off)
        remote.pressUndo();

        // Undo dimming the light
        remote.pressUndo();

        // Undo turning the light on
        remote.pressUndo();
    }
}
