package intro.liskov;

/**
 * the superclass Vehicle contains a method startEngine() to start the engine of the vehicle, but it
 * does not make any assumptions about the specific behavior of starting the engine for different
 * types of vehicles. Each subclass (Car and Motorcycle) overrides the startEngine() method to
 * provide its specific implementation. This ensures that the code adheres to the Liskov
 * Substitution Principle, as substituting a Car or Motorcycle object for a Vehicle object does not
 * change the expected behavior of the program.
 */
public class MainAfter {
    // Base class representing a vehicle
    static class Vehicle {
        private String fuelType;

        public Vehicle(String fuelType) {
            this.fuelType = fuelType;
        }

        // Method to start the engine of the vehicle
        public void startEngine() {
            System.out.println("Starting engine of the vehicle...");
        }

        // Method to get the fuel type of the vehicle
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
            // Creating a Car object
            Vehicle car = new Car("Gasoline");

            // Starting the engine of the car
            car.startEngine(); // Prints "Starting car engine..."

            // Creating a Motorcycle object
            Vehicle motorcycle = new Motorcycle("Gasoline");

            // Starting the engine of the motorcycle
            motorcycle.startEngine(); // Prints "Starting motorcycle engine..."
        }
    }
}
