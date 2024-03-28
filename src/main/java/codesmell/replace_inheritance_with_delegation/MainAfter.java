package codesmell.replace_inheritance_with_delegation;

public class MainAfter {
    class Engine {
        private double fuel;
        private double CV;

        public double getFuel() {
            return fuel;
        }
        public void setFuel(double fuel) {
            this.fuel = fuel;
        }
        public double getCV() {
            return CV;
        }
        public void setCV(double cv) {
            this.CV = cv;
        }
    }

    class Car {
        private String brand;
        private String model;

        /**
         * Composition over inheritance
         * Car HAS AN Engine
          */
        protected Engine engine;

        public Car() {
            this.engine = new Engine();
        }
        public String getName() {
            return brand + " " + model + " (" + engine.getCV() + "CV)";
        }
        public String getModel() {
            return model;
        }
        public void setModel(String model) {
            this.model = model;
        }
        public String getBrand() {
            return brand;
        }
        public void setBrand(String brand) {
            this.brand = brand;
        }
    }


}
