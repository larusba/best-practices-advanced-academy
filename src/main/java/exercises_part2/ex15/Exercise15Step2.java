package exercises_part2.ex15;

/**
 * STEP 2: DESIGN OBSERVER (RED)
 *
 * OBIETTIVO:
 * Disaccoppiare tramite interfaccia `Observer` e `Subject`.
 */
public class Exercise15Step2 {
    public interface Observer {
        void update(double price);
    }

    public static class StockMarket {
        // Metodi stub
        public void attach(Observer o) {}
        public void setPrice(double p) {}
    }
}