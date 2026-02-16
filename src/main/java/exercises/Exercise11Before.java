package exercises;

/**
 * ESERCIZIO: Rifattorizza le classi per migliorare l'incapsulamento.
 */
public class Exercise11Before {

    public static class Wallet {
        private double balance;

        public double getBalance() { return balance; }
        public void setBalance(double balance) { this.balance = balance; }
    }

    public static class PaymentService {
        public void processPayment(Wallet wallet, double amount) {
            // Il Service sta manipolando i dati interni del Wallet.
            // "Feature Envy": il metodo è più interessato ai dati di un'altra classe.
            if (wallet.getBalance() >= amount) {
                wallet.setBalance(wallet.getBalance() - amount);
                System.out.println("Payment processed");
            } else {
                throw new RuntimeException("Insufficient funds");
            }
        }
    }
}
