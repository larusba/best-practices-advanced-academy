package exercises;

import java.util.function.Function;

/**
 * TODO: remove from here
 * 
 */
public class Exercise1BisAfter {
    public static class VehicleFeature {
        private String make;
        private String model;

        public VehicleFeature(String make, String model) {
            this.make = make;
            this.model = model;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }
    }
    
    public static class Vehicle {
        private String type;
        private VehicleFeature feature;

        public Vehicle(String type, VehicleFeature feature) {
            this.type = type;
            this.feature = feature;
        }

        /**
         * NOTA BENE: you have to make sure that the java.util.function.Function<..> accept only VehicleModel, 
         * in case of other parameter, you should change it.
         * So. Less flexible but we can rid of switch case
         */
        public enum VehicleType {
            CAR(model -> new Vehicle("Car", model)),
            MOTORCYCLE(model -> new Vehicle("Motorcycle", model)),
            TRUCK(model -> new Vehicle("Truck", model));
            
            private final Function<VehicleFeature, Vehicle> vehicleConsumer;

            VehicleType(Function<VehicleFeature, Vehicle> vehicleConsumer) {
                this.vehicleConsumer = vehicleConsumer;
            }

            public Function<VehicleFeature, Vehicle> get() {
                return vehicleConsumer;
            }
        }

        public String getType() {
            return type;
        }

        public VehicleFeature getFeature() {
            return feature;
        }
        
        // setters..
    }

    public static void main(String[] args) {
        VehicleFeature vehicleModel = new VehicleFeature("Toyota", "Corolla");
        Vehicle car = Vehicle.VehicleType.CAR.get().apply(vehicleModel);
        System.out.println(car.getType() + ": " + car.getFeature().getMake() + " " + car.getFeature().getModel());

        VehicleFeature vehicleModel1 = new VehicleFeature("Honda", "CBR500R");
        Vehicle motorcycle = Vehicle.VehicleType.MOTORCYCLE.get().apply(vehicleModel1);
        System.out.println(motorcycle.getType() + ": " + motorcycle.getFeature().getMake() + " " + motorcycle.getFeature().getModel());
    }

}
