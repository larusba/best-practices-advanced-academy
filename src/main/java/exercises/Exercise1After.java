package exercises;

/**
 * TODO
 */
public class Exercise1After {
    public static class Vehicle {
        private String type;
        private String make;
        private String model;

        public Vehicle(String type, String make, String model) {
            this.type = type;
            this.make = make;
            this.model = model;
        }

        // Enum for different types of vehicles
        public enum VehicleType {
            CAR,
            MOTORCYCLE,
            TRUCK
        }

        // enum factory
        public static Vehicle createVehicle(VehicleType type, String make, String model) {
            return switch (type) {
                case CAR -> new Vehicle("Car", make, model);
                case MOTORCYCLE -> new Vehicle("Motorcycle", make, model);
                case TRUCK -> new Vehicle("Truck", make, model);
            };
            
            /*
            Java until 16
            switch (type) {
                case CAR:
                    return new Vehicle("Car", make, model);
                case MOTORCYCLE:
                    return new Vehicle("Motorcycle", make, model);
                case TRUCK:
                    return new Vehicle("Truck", make, model);
                default:
                    return null;
            }
             */
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

    public static void main(String[] args) {
        Vehicle car = Vehicle.createVehicle(Vehicle.VehicleType.CAR, "Toyota", "Corolla");
        System.out.println(car.getType() + ": " + car.getMake() + " " + car.getModel());

        Vehicle motorcycle = Vehicle.createVehicle(Vehicle.VehicleType.MOTORCYCLE, "Honda", "CBR500R");
        System.out.println(motorcycle.getType() + ": " + motorcycle.getMake() + " " + motorcycle.getModel());
    }

}
