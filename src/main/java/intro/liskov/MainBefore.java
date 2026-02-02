package intro.liskov;

/**
 * both Car and Motorcycle are subclasses of Vehicle, and they both override the startEngine()
 * method to provide their specific implementation. 
 * 
 * However, this implementation may violate the 
 * Liskov Substitution Principle if the superclass Vehicle makes assumptions about the behavior of
 * all vehicles.
 * 
 * What happens if we add a bicycle? In this case, the bicycle may not have an engine to start,
 * which could lead to unexpected behavior if the Vehicle class assumes all vehicles have engines.
 */
public class MainBefore {
    // Base class representing a vehicle
    static class Vehicle {
        private String fuelType;

        public Vehicle(String fuelType) {
            this.fuelType = fuelType;
        }

        public void startEngine() {
            System.out.println("Starting engine of the vehicle...");
        }

        public String getFuelType() {
            return fuelType;
        }
    }

    // Car class representing a car, a type of vehicle
    static class Car extends Vehicle {
        public Car(String fuelType) {
            super(fuelType);
        }

        // Override startEngine method to implement car-specific behavior
        @Override
        public void startEngine() {
            System.out.println("Starting car engine...");
        }
    }

    // Motorcycle class representing a motorcycle, a type of vehicle
    static class Motorcycle extends Vehicle {
        public Motorcycle(String fuelType) {
            super(fuelType);
        }

        // Override startEngine method to implement motorcycle-specific behavior
        @Override
        public void startEngine() {
            System.out.println("Starting motorcycle engine...");
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Vehicle vehicle = new Car("Gasoline");
            vehicle.startEngine(); // Prints "Starting car engine..."

            vehicle = new Motorcycle("Gasoline");
            vehicle.startEngine(); // Prints "Starting motorcycle engine..."
        }
    }
}
