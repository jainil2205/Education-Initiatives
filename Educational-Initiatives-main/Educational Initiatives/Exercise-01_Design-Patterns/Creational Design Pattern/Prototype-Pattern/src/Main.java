
// Demo class
public class ShapePrototypeDemo {
    public static void main(String[] args) {
        // Load the shape cache with default shapes
        ShapeCache.loadCache();

        // Clone and customize Circle
        Shape clonedCircle = ShapeCache.getShape("1", "Red", 10);
        clonedCircle.draw();

        // Clone and customize Square
        Shape clonedSquare = ShapeCache.getShape("2", "Blue", 7);
        clonedSquare.draw();

        // Clone and customize Rectangle
        Shape clonedRectangle = ShapeCache.getShape("3", "Green", 12);
        clonedRectangle.draw();

        // Dynamically add a new shape and retrieve it
        Circle newCircle = new Circle();
        newCircle.setId("4");
        ShapeCache.registerShape("4", newCircle);

        Shape customCircle = ShapeCache.getShape("4", "Purple", 15);
        customCircle.draw();
    }
}
