package exercises_part2.ex4;

/**
 * REFACTORING COMPLETATO (GREEN)
 * Il processore ora delega l'esecuzione all'oggetto passato (Polimorfismo).
 * Abbiamo eliminato gli `if-else`.
 * 
 * FEATURE:
 * - Aggiungere il supporto per pagamenti in criptovaluta (Bitcoin).
 */
public class Exercise4Step3 {

    public interface PaymentMethod {
        void pay(double amount);
    }

    // Implementazione concreta 1
    public static class CreditCardPayment implements PaymentMethod {
        public void pay(double amount) {
            System.out.println("CC Pay: " + amount);
        }
    }

    public static class PaymentProcessor {
        public void process(PaymentMethod method, double amount) {
            method.pay(amount); // Delega polimorfica
        }
    }
}