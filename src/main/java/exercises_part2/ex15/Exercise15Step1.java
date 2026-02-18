package exercises_part2.ex15;

/**
 * STEP 1: CODICE LEGACY
 * 
 * ANALISI CODE SMELL:
 * 1. **Accoppiamento:** `StockMarket` conosce direttamente `Investor`.
 * 2. **Rigidità:** Impossibile aggiungere altri tipi di ascoltatori (es. App Mobile).
 * 
 * FEATURE FUTURA:
 * - Implementare logica di notifica condizionale (Threshold).
 */
public class Exercise15Step1 {
    static class Investor {
        void update(double price) {
            System.out.println("Price: " + price);
        }
    }

    public static class StockMarket {
        Investor investor = new Investor(); // Hardcoded

        public void setPrice(double price) {
            investor.update(price);
        }
    }
}