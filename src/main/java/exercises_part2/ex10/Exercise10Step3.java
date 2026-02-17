package exercises_part2.ex10;

/**
 * STEP 3: REFACTORING COMPLETATO (GREEN)
 */
public class Exercise10Step3 {
    public interface Transport { void deliver(); }

    public static abstract class Logistics {
        public abstract Transport createTransport();

        // La logica core non sa CHE tipo di trasporto userà
        public void planDelivery() {
            Transport t = createTransport();
            t.deliver();
        }
    }

    // Concrete Creator 1
    public static class RoadLogistics extends Logistics {
        @Override
        public Transport createTransport() { return new Truck(); }
    }
    
    static class Truck implements Transport {
        public void deliver() { System.out.println("Via terra."); }
    }
}