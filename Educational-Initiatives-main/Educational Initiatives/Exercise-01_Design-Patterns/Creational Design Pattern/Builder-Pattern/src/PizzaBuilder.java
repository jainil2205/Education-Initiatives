import java.util.ArrayList;
import java.util.List;

// Pizza class
class Pizza {
    private Size size;
    private Crust crust;
    private Sauce sauce;
    private List<String> toppings;

    // Enum for pizza size
    public enum Size {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE
    }

    // Enum for crust type
    public enum Crust {
        THIN, THICK, STUFFED
    }

    // Enum for sauce type
    public enum Sauce {
        TOMATO, ALFREDO, PESTO, BBQ
    }

    public static class Builder {
        private Size size;
        private Crust crust = Crust.THIN;  // Default crust
        private Sauce sauce = Sauce.TOMATO;  // Default sauce
        private List<String> toppings = new ArrayList<>();

        public Builder(Size size) {
            this.size = size;
        }

        // Optional crust selection
        public Builder crust(Crust crust) {
            this.crust = crust;
            return this;
        }

        // Optional sauce selection
        public Builder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        // Add cheese
        public Builder cheese() {
            this.toppings.add("Cheese");
            return this;
        }

        // Add pepperoni
        public Builder pepperoni() {
            this.toppings.add("Pepperoni");
            return this;
        }

        // Add mushrooms
        public Builder mushrooms() {
            this.toppings.add("Mushrooms");
            return this;
        }

        // Add olives
        public Builder olives() {
            this.toppings.add("Olives");
            return this;
        }

        // Add bacon
        public Builder bacon() {
            this.toppings.add("Bacon");
            return this;
        }

        // Add a custom topping
        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.toppings = builder.toppings;
    }

    // Describe the pizza order
    public void describe() {
        System.out.println("Pizza size: " + size + 
                           ", Crust: " + crust + 
                           ", Sauce: " + sauce + 
                           ", Toppings: " + String.join(", ", toppings));
    }
}

