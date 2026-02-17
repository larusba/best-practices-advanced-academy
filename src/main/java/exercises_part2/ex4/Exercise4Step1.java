package exercises_part2.ex4;

/**
 * STEP 1: CODICE LEGACY
 *
 * ANALISI CODE SMELL:
 * 1. **Violazione Open/Closed Principle:** Per aggiungere un nuovo metodo di pagamento,
 * dobbiamo modificare la classe `PaymentProcessor` aggiungendo un altro `else if`.
 * 2. **Complessità Ciclomatica:** Troppe condizioni annidate rendono il codice fragile.
 *
 * FEATURE FUTURA DA IMPLEMENTARE:
 * - Aggiungere il supporto per pagamenti in criptovaluta (Bitcoin).
 */
public class Exercise4Step1 {
    public static class PaymentProcessor {
        public void pay(String type, double amount) {
            if (type.equals("CREDIT_CARD")) {
                System.out.println("Pagamento " + amount + " con Carta di Credito.");
            } else if (type.equals("PAYPAL")) {
                System.out.println("Pagamento " + amount + " con PayPal.");
            } else {
                throw new IllegalArgumentException("Metodo non supportato");
            }
        }
    }
}