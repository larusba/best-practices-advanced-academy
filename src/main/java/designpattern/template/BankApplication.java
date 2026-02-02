package designpattern.template;

/**
 * ESEMPIO PRATICO: Processo di Approvazione Prestiti.
 *
 * Il Template Method è ideale qui perché garantisce che i controlli legali (verifyCustomer)
 * e l'approvazione finale (approveLoan) siano eseguiti SEMPRE e NELLO STESSO ORDINE,
 * indipendentemente dal tipo di prestito.
 */
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
     * COMPONENT: Abstract Class.
     * Definisce il workflow.
     */
    abstract static class LoanProcessor {

        /**
         * COMPONENT: Template Method.
         * Dichiarato 'final' affinché nessuno possa modificare la procedura legale/sicurezza.
         *
         * Flusso:
         * 1. Verifica (Fisso)
         * 2. Calcolo Interessi (Variabile)
         * 3. Approvazione (Fisso)
         * 4. Gestione Garanzie (Opzionale/Condizionale tramite Hook)
         */
        public final void processLoan() {
            verifyCustomer();
            calculateInterest();
            approveLoan();
            
            // Uso dell'Hook booleano per controllare il flusso
            if (needSecurity()) {
                provideSecurity();
            }
            System.out.println("Loan processing completed!");
        }

        // Metodi concreti (Invarianti): Condivisi da tutti i prestiti.
        private void verifyCustomer() {
            System.out.println("Verifying customer details");
        }

        private void approveLoan() {
            System.out.println("Approving loan");
        }

        // Metodi astratti (Varianti): Ogni prestito ha la sua matematica.
        protected abstract void calculateInterest();
        
        // Metodi astratti per la gestione garanzie
        protected abstract boolean needSecurity();
        protected abstract void provideSecurity();
    }

    // Concrete Class 1: Prestito Personale
    static class PersonalLoanProcessor extends LoanProcessor {
        @Override
        protected void calculateInterest() {
            System.out.println("Calculating interest for personal loan");
        }

        // Hook booleano: Non serve garanzia per piccoli prestiti personali
        @Override
        protected boolean needSecurity() {
            return false;
        }

        @Override
        protected void provideSecurity() {
            // No security needed for personal loans
        }
    }

    // Concrete Class 2: Mutuo
    static class MortgageLoanProcessor extends LoanProcessor {
        @Override
        protected void calculateInterest() {
            System.out.println("Calculating interest for mortgage loan");
        }

        // Hook booleano: Serve garanzia (la casa) per il mutuo
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