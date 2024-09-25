import java.util.HashMap;

// Abstract Shape class with color and size attributes
abstract class Shape implements Cloneable {
    private String id;
    private String color;
    private int size;

    // Constructor with default attributes
    public Shape() {
        this.color = "Black";
        this.size = 5;  // Default size
    }

    abstract void draw();

    // Getters and setters for additional attributes
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// Circle class
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle of size: " + getSize() + " and color: " + getColor());
    }
}

// Square class
class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Square of size: " + getSize() + " and color: " + getColor());
    }
}

// Rectangle class (new shape added)
class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle of size: " + getSize() + " and color: " + getColor());
    }
}

// ShapeCache class with dynamic registration and attribute customization
class ShapeCache {
    private static final HashMap<String, Shape> shapeMap = new HashMap<>();

    // Get shape from cache and allow for customization of attributes
    public static Shape getShape(String shapeId, String color, int size) {
        Shape cachedShape = shapeMap.get(shapeId);
        try {
            Shape clonedShape = (Shape) cachedShape.clone();
            clonedShape.setColor(color);  // Customize color
            clonedShape.setSize(size);    // Customize size
            return clonedShape;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Load initial cache with some default shapes
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }

    // Dynamically register a new shape
    public static void registerShape(String id, Shape shape) {
        shapeMap.put(id, shape);
    }
}
