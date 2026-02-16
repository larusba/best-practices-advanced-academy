package exercises;

/**
 * Applicato il principio **"Tell, Don't Ask"**.
 * La logica di modifica del saldo è stata spostata all'interno della classe `Wallet`.
 * Il servizio ora si limita a chiedere al Wallet di eseguire l'operazione.
 */
public class Exercise11After {

    public static class Wallet {
        private double balance;

        public void debit(double amount) {
            if (balance < amount) {
                throw new RuntimeException("Insufficient funds");
            }
            this.balance -= amount;
        }
    }

    public static class PaymentService {
        public void processPayment(Wallet wallet, double amount) {
            wallet.debit(amount);
            System.out.println("Payment processed");
        }
    }
}