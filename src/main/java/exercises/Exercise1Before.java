package exercises;

/**
 * Refactor this class, using a design pattern
 */
public class Exercise1Before {
    public static class Vehicle {
        private String type;
        private String make;
        private String model;

        public Vehicle(String type, String make, String model) {
            this.type = type;
            this.make = make;
            this.model = model;
        }

        public static Vehicle createVehicle(String type, String make, String model) {
            if (type.equalsIgnoreCase("car")) {
                return new Car(make, model);
            } else if (type.equalsIgnoreCase("motorcycle")) {
                return new Motorcycle(make, model);
            } else if (type.equalsIgnoreCase("truck")) {
                return new Truck(make, model);
            } else {
                // unknown vehicle
                return null;
            }
        }

        public String getType() {
            return type;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        // setters..
    }

    public static class Car extends Vehicle {
        public Car(String make, String model) {
            super("Car", make, model);
        }
    }

    public static class Motorcycle extends Vehicle {
        public Motorcycle(String make, String model) {
            super("Motorcycle", make, model);
        }
    }

    public static class Truck extends Vehicle {
        public Truck(String make, String model) {
            super("Truck", make, model);
        }
    }

    public static void main(String[] args) {
        Vehicle car = Vehicle.createVehicle("car", "Toyota", "Corolla");
        System.out.println(car.getType() + ": " + car.getMake() + " " + car.getModel());

        Vehicle motorcycle = Vehicle.createVehicle("motorcycle", "Honda", "CBR500R");
        System.out.println(motorcycle.getType() + ": " + motorcycle.getMake() + " " + motorcycle.getModel());
    }
    
}
