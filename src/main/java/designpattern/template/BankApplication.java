package designpattern.template;

public class BankApplication {
    
    // Usage example
    public static class LoanProcessorDemo {
        public static void main(String[] args) {
            System.out.println("Processing Personal Loan:");
            LoanProcessor personalLoanProcessor = new PersonalLoanProcessor();
            personalLoanProcessor.processLoan();

            System.out.println("\nProcessing Mortgage Loan:");
            LoanProcessor mortgageLoanProcessor = new MortgageLoanProcessor();
            mortgageLoanProcessor.processLoan();
        }
    }

    /**
     * COMPONENT: Abstract Template 
     */
    abstract static class LoanProcessor {

        /**
         * COMPONENT: Template method
         * Template method defining the loan processing process
         */
        public final void processLoan() {
            verifyCustomer();
            calculateInterest();
            approveLoan();
            if (needSecurity()) {
                provideSecurity();
            }
            System.out.println("Loan processing completed!");
        }

        // Concrete methods shared by subclasses
        private void verifyCustomer() {
            System.out.println("Verifying customer details");
        }

        private void approveLoan() {
            System.out.println("Approving loan");
        }

        // Abstract methods to be implemented by subclasses
        protected abstract void calculateInterest();
        protected abstract boolean needSecurity();
        protected abstract void provideSecurity();
    }

    // Concrete subclass for processing Personal Loans
    static class PersonalLoanProcessor extends LoanProcessor {
        @Override
        protected void calculateInterest() {
            System.out.println("Calculating interest for personal loan");
        }

        @Override
        protected boolean needSecurity() {
            return false;
        }

        @Override
        protected void provideSecurity() {
            // No security needed for personal loans
        }
    }

    // Concrete subclass for processing Mortgage Loans
    static class MortgageLoanProcessor extends LoanProcessor {
        @Override
        protected void calculateInterest() {
            System.out.println("Calculating interest for mortgage loan");
        }

        @Override
        protected boolean needSecurity() {
            return true;
        }

        @Override
        protected void provideSecurity() {
            System.out.println("Collecting property documents as security for mortgage loan");
        }
    }

}
