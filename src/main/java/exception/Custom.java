package exception;

public class Custom {
    // 1. Custom exception class
    public static class InvalidWithdrawalAmountException extends Exception {
        public InvalidWithdrawalAmountException(String message) {
            super(message);  // Passing the error message to the base Exception class
        }
    }
    
    public static class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        // 2. Method with can throw InvalidWithdrawalAmountException with different message
        public void withdraw(double amount) throws InvalidWithdrawalAmountException {
            if (amount < 0) {
                throw new InvalidWithdrawalAmountException("Withdrawal amount cannot be negative.");
            } else if (amount > balance) {
                throw new InvalidWithdrawalAmountException("Withdrawal amount exceeds account balance.");
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance: " + balance);
            }
        }
    }
        
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);
        try {
            account.withdraw(600);  // This should trigger our custom exception
        } catch (InvalidWithdrawalAmountException e) {
            // -- 3. Handle the custom exception by printing out the error message
            System.out.println("Error: " + e.getMessage());  
        } catch (Exception e) {
            // -- 3. This catch block will handle general exceptions
            System.out.println("A general error occurred: " + e.getMessage());
        }
    }

}
