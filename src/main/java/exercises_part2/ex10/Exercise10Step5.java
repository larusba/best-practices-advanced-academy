package exercises_part2.ex10;

public class Exercise10Step5 {
    public interface Transport {
        void deliver();
    }

    public static abstract class Logistics {
        public abstract Transport createTransport();
    }

    // Implementazione Reale
    public static class AirLogistics extends Logistics {
        @Override
        public Transport createTransport() {
            return new Plane();
        }
    }

    static class Plane implements Transport {
        public void deliver() {
            System.out.println("Via aerea.");
        }
    }
}