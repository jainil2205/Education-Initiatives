// Coffee interface
interface Coffee {
    String getDescription();
    double cost();
}

// Simple coffee implementation with size and base cost
class SimpleCoffee implements Coffee {
    private String size;
    private double baseCost;

    // Constructor to set size and base cost
    public SimpleCoffee(String size) {
        this.size = size;
        this.baseCost = getBaseCost(size);
    }

    @Override
    public String getDescription() {
        return size + " Simple Coffee";
    }

    @Override
    public double cost() {
        return baseCost;
    }

    // Helper method to determine cost based on size
    private double getBaseCost(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return 50;
            case "medium":
                return 75;
            case "large":
                return 100;
            default:
                return 50;
        }
    }
}

// Abstract CoffeeDecorator to allow decoration of Coffee objects
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

// Milk decorator with configurable price
class MilkDecorator extends CoffeeDecorator {
    private double milkCost;

    public MilkDecorator(Coffee coffee, double milkCost) {
        super(coffee);
        this.milkCost = milkCost;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return coffee.cost() + milkCost;
    }
}

// Sugar decorator with configurable price
class SugarDecorator extends CoffeeDecorator {
    private double sugarCost;

    public SugarDecorator(Coffee coffee, double sugarCost) {
        super(coffee);
        this.sugarCost = sugarCost;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return coffee.cost() + sugarCost;
    }
}

// Vanilla decorator
class VanillaDecorator extends CoffeeDecorator {
    private double vanillaCost;

    public VanillaDecorator(Coffee coffee, double vanillaCost) {
        super(coffee);
        this.vanillaCost = vanillaCost;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Vanilla";
    }

    @Override
    public double cost() {
        return coffee.cost() + vanillaCost;
    }
}

// Whipped cream decorator
class WhippedCreamDecorator extends CoffeeDecorator {
    private double whippedCreamCost;

    public WhippedCreamDecorator(Coffee coffee, double whippedCreamCost) {
        super(coffee);
        this.whippedCreamCost = whippedCreamCost;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double cost() {
        return coffee.cost() + whippedCreamCost;
    }
}

