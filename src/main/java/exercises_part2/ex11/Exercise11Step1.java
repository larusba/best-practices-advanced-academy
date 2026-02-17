package exercises_part2.ex11;

/**
 * STEP 1: CODICE LEGACY
 *
 * ANALISI CODE SMELL:
 * 1. **Incompatibilità:** Il client si aspetta di chiamare `pay(amount)`, ma la libreria legacy usa `makePayment(amount)`.
 * 2. **Accoppiamento:** Il client dipende direttamente dalla classe concreta `LegacyBank`.
 *
 * FEATURE FUTURA:
 * - Aggiungere il supporto per una nuova API di pagamento "Stripe-like" senza cambiare il codice del Client.
 */
public class Exercise11Step1 {
    // Il Client usa direttamente la classe concreta
    public static class Shop {
        private LegacyBank bank = new LegacyBank();
        
        public void checkout(double amount) {
            bank.makePayment(amount); // Metodo specifico della legacy
        }
    }

    // Libreria esterna non modificabile
    static class LegacyBank {
        public void makePayment(double value) {
            System.out.println("Pagamento Legacy: " + value);
        }
    }
}