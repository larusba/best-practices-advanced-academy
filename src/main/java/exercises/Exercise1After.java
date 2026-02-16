package exercises;

/**
 * Factory method
 */
public class Exercise1After {
    enum VehicleType {
        CAR, MOTORCYCLE, TRUCK
    }
    
    
    public static class Vehicle {
        private String type;
        private String make;
        private String model;

        public Vehicle(String type, String make, String model) {
            this.type = type;
            this.make = make;
            this.model = model;
        }

        public static Vehicle createVehicle(VehicleType type, String make, String model) {
            return switch (type) {
                case CAR -> new Car(make, model);
                case TRUCK -> new Truck(make, model);
                case MOTORCYCLE -> new Motorcycle(make, model);
            };
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
        Vehicle car = Vehicle.createVehicle(VehicleType.CAR, "Toyota", "Corolla");
        System.out.println(car.getType() + ": " + car.getMake() + " " + car.getModel());

        Vehicle motorcycle = Vehicle.createVehicle(VehicleType.MOTORCYCLE, "Honda", "CBR500R");
        System.out.println(motorcycle.getType() + ": " + motorcycle.getMake() + " " + motorcycle.getModel());
    }
}
