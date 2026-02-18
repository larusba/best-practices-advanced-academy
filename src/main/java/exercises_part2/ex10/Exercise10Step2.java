package exercises_part2.ex10;

/**
 * STEP 2: DESIGN FACTORY METHOD (RED)
 * 
 * OBIETTIVO:
 * Delegare la creazione a un metodo astratto `createTransport()`.
 */
public class Exercise10Step2 {

    public interface Transport {
        void deliver();
    }

    public static abstract class Logistics {
        // Factory Method astratto
        public abstract Transport createTransport();

        public void planDelivery() {
            Transport t = createTransport(); // Chiama il factory
            // TODO: t.deliver();
        }
    }
}