package designpattern.decorator;

/**
 * Add topping feature to pizza. That increase the price of the base pizza (i.e. SimplePizza)
 */
public class Food {
    public class Main {
        public static void main(String[] args) {
            Pizza simplePizza = new SimplePizza();
            
            // pizza with cheese
            Pizza cheesePizza = new Cheese(simplePizza);
            
            // pizza with cheese and salami
            Pizza salamiPizza = new Salami(cheesePizza);

            System.out.println(simplePizza.getDescription() + " - $" + simplePizza.cost());
            // Output: Simple pizza - $8.99
            
            System.out.println(cheesePizza.getDescription() + " - $" + cheesePizza.cost());
            // Output: Simple pizza, with cheese - $10.49
            
            System.out.println(salamiPizza.getDescription() + " - $" + salamiPizza.cost());
            // Output: Simple pizza, with cheese, with salami - $12.49
        }
    }


    /**
     * COMPONENT: Component (interface and concretes)
     */
    public interface Pizza {
        String getDescription();
        double cost();
    }
    
    public static class SimplePizza implements Pizza {
        @Override
        public String getDescription() {
            return "Simple pizza";
        }

        @Override
        public double cost() {
            return 8.99;
        }
    }

    /**
     * COMPONENT: Decorator (interface and concretes)
     */
    public abstract static class PizzaDecorator implements Pizza {
        protected Pizza decoratedPizza;

        protected PizzaDecorator(Pizza decoratedPizza) {
            this.decoratedPizza = decoratedPizza;
        }

        @Override
        public String getDescription() {
            return decoratedPizza.getDescription();
        }

        @Override
        public double cost() {
            return decoratedPizza.cost();
        }
    }

    // -- Decorators
    public static class Cheese extends PizzaDecorator {
        public Cheese(Pizza decoratedPizza) {
            super(decoratedPizza);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", with cheese";
        }

        @Override
        public double cost() {
            return super.cost() + 1.50; // Cheese costs $1.50
        }
    }

    public static class Salami extends PizzaDecorator {
        public Salami(Pizza decoratedPizza) {
            super(decoratedPizza);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", with pepperoni";
        }

        @Override
        public double cost() {
            return super.cost() + 2.00; // Pepperoni costs $2.00
        }
    }

}
