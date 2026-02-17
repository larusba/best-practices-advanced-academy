package exercises_part2.ex10;

public class Exercise10Step4 {
    public interface Transport { void deliver(); }
    public static abstract class Logistics {
        public abstract Transport createTransport();
    }
    
    // Stub della nuova logistica Aerea
    public static class AirLogistics extends Logistics {
        public Transport createTransport() {
            // TODO: return new Plane();
            return null;
        }
    }
    
    static class Plane implements Transport {
        public void deliver() { System.out.println("Via aerea."); }
    }
}