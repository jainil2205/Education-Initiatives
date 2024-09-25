// Demo class to test the Coffee customization
public class CoffeeShop {
    public static void main(String[] args) {
        // Create a large simple coffee
        Coffee coffee = new SimpleCoffee("Large");

        // Customize it by adding Milk and Sugar with configurable prices
        coffee = new MilkDecorator(coffee, 20);  // Adding milk costing 20
        coffee = new SugarDecorator(coffee, 5);  // Adding sugar costing 5
        coffee = new VanillaDecorator(coffee, 25);  // Adding vanilla costing 25
        coffee = new WhippedCreamDecorator(coffee, 30);  // Adding whipped cream costing 30

        // Output the final description and total cost of the customized coffee
        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Total cost: " + coffee.cost());
    }
}
