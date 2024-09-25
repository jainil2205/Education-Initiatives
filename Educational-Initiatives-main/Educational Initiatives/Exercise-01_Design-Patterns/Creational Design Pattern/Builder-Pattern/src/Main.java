// Demo class
public class PizzaBuilderDemo {
    public static void main(String[] args) {
        // Building a pizza
        Pizza myPizza = new Pizza.Builder(Pizza.Size.LARGE)
                .crust(Pizza.Crust.STUFFED)
                .sauce(Pizza.Sauce.BBQ)
                .cheese()
                .pepperoni()
                .bacon()
                .addTopping("Jalapenos")
                .build();

        // Describe the pizza order
        myPizza.describe();
    }
}
