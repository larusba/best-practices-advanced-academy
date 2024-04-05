package codesmell.shotgun_surgery;

public class MainAfter {
    public class Account {

        private String type;
        private String accountNumber;
        private int amount;

        public Account(String type, String accountNumber, int amount) {
            this.amount = amount;
            this.type = type;
            this.accountNumber = accountNumber;
        }

        private boolean isAccountUnderflow() {
            return amount <= 500;
        }

        public void debit(int debit) throws Exception {
            if (isAccountUnderflow()) {
                throw new Exception("Mininum balance shuold be over 500");
            }

            amount = amount - debit;
            System.out.println("Now amount is" + amount);
        }

        public void transfer(Account from, Account to, int cerditAmount) throws Exception {
            if (from.isAccountUnderflow()) {
                throw new Exception("Mininum balance shuold be over 500");
            }
            to.amount = amount + cerditAmount;
        }

        public void sendWarningMessage() {
            if (isAccountUnderflow()) {
                System.out.println("amount should be over 500");
            }
        }
    }
}
