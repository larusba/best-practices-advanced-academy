package designpattern.decorator;

public class Main {
    interface Car {
        void assemble();
    }

    static class BasicCar implements Car {
        @Override
        public void assemble() {
            System.out.print("Basic Car.");
        }
    }

    static class AnotherCar implements Car {
        @Override
        public void assemble() {
            System.out.print("Another Car.");
        }
    }

    static class CarDecorator implements Car {

        protected Car car;

        public CarDecorator(Car c) {
            this.car = c;
        }

        @Override
        public void assemble() {
            this.car.assemble();
        }
    }

    /** The assemble() has additional features, besides the one of the injected `Car` */
    static class SportsCar extends CarDecorator {

        public SportsCar(Car c) {
            super(c);
        }

        @Override
        public void assemble() {
            super.assemble();
            System.out.print(" Adding features of Sports Car.");
        }
    }

    static class LuxuryCar extends CarDecorator {

        public LuxuryCar(Car c) {
            super(c);
        }

        @Override
        public void assemble() {
            super.assemble();
            System.out.print(" Adding features of Luxury Car.");
        }
    }

    /**
     * we can "decorate" our `BasicCar` with additional "features"
     *
     * <p>We cannot use multiple inheritance like SportCar/LuxuryCar --> BasicCar --> Car e.g. -->
     * `sportsLuxuryCar`
     *
     * <p>Otherwise, we can use intro.di example --> for example, the pc cannot have, at the same
     * time, a ComputerWindows.boot() and ComputerLinux.boot()
     */
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();

        //
        // decorate without change base classes
        //
        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}
