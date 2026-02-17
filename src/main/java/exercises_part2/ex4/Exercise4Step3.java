package exercises_part2.ex4;

/**
 * STEP 3: REFACTORING COMPLETATO (GREEN)
 * Il processore ora delega l'esecuzione all'oggetto passato (Polimorfismo).
 * Abbiamo eliminato gli `if-else`.
 */
public class Exercise4Step3 {
    
    public interface PaymentMethod {
        void pay(double amount);
    }

    // Implementazione concreta 1
    public static class CreditCardPayment implements PaymentMethod {
        public void pay(double amount) { System.out.println("CC Pay: " + amount); }
    }

    public static class PaymentProcessor {
        public void process(PaymentMethod method, double amount) {
            method.pay(amount); // Delega polimorfica
        }
    }
}