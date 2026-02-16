package exercises;

import java.util.function.Function;

/**
 * Functional Enum Pattern
 * detto anche: Enum Factory Method Pattern
 */
public class Exercise1BisAfter {
    public static class VehicleFeature {
        private String type;
        private String make;

        public VehicleFeature(String type, String make) {
            this.type = type;
            this.make = make;
        }

        public String getType() {
            return type;
        }

        public String getMake() {
            return make;
        }
    }

    enum VehicleType {
        CAR(feature -> new Vehicle(feature, "Car")),
        MOTORCYCLE(feature -> new Vehicle(feature, "model132123")),
        TRUCK(feature -> new Vehicle(feature, "model1121"));


        private final Function<VehicleFeature, Vehicle> vehicleFunction;

        VehicleType(Function<VehicleFeature, Vehicle> vehicleFunction) {
            this.vehicleFunction = vehicleFunction;
        }

        public Function<VehicleFeature, Vehicle> get() {
            return vehicleFunction;
        }
    }

    public static class Vehicle {
        private VehicleFeature feature;
        private String model;

        public Vehicle(VehicleFeature feature, String model) {
            this.feature = feature;
            this.model = model;
        }

        public VehicleFeature getFeature() {
            return feature;
        }

        public String getModel() {
            return model;
        }
    }


    public static void main(String[] args) {
        VehicleFeature feature = new VehicleFeature("Toyota", "Corolla");
        Vehicle car = VehicleType.CAR.get().apply(feature);
        System.out.println(car.getFeature().getType() + ": " + car.getFeature().getMake() + car.getModel());
        
    }
}