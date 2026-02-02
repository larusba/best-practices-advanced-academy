package refactoring.extract_subclass;

/**
 * ESEMPIO "AFTER": Refactoring applicato (Extract Subclass).
 *
 * Abbiamo trasformato il flag 'isLabor' in una gerarchia di classi.
 *
 * Vantaggi didattici:
 * - Coesione: Ogni sottoclasse contiene solo i dati necessari (niente più campi null).
 * - Polimorfismo: Il metodo getUnitPrice() non ha più bisogno di 'if/else'.
 * - Semplicità: I costruttori sono chiari e richiedono solo i dati pertinenti.
 */
public class MainAfter {
    
    /**
     * Classe Base Astratta.
     * Contiene solo i dati e i comportamenti comuni a tutti i JobItem (es. quantity).
     * Definisce il "contratto" tramite il metodo astratto getUnitPrice().
     */
    abstract static class JobItem {
        private int quantity;

        protected JobItem(int quantity) {
            this.quantity = quantity;
        }

        // Template Method: usa il metodo astratto getUnitPrice()
        public int getTotalPrice() {
            return quantity * getUnitPrice();
        }

        public int getQuantity() {
            return quantity;
        }

        // Il metodo che variava in base al flag ora è astratto
        public abstract int getUnitPrice();
    }

    /**
     * Sottoclasse per i Pezzi di ricambio (Parts).
     * Gestisce lo stato specifico 'unitPrice' che prima era nella classe padre.
     */
    static class PartsItem extends JobItem {
        private int unitPrice;

        public PartsItem(int quantity, int unitPrice) {
            super(quantity);
            this.unitPrice = unitPrice;
        }

        @Override
        public int getUnitPrice() {
            return unitPrice;
        }
    }

    /**
     * Sottoclasse per la Manodopera (Labor).
     * Gestisce lo stato specifico 'employee'.
     */
    static class LaborItem extends JobItem {
        private Employee employee;

        public LaborItem(int quantity, Employee employee) {
            super(quantity);
            this.employee = employee;
        }

        public Employee getEmployee() {
            return employee;
        }

        @Override
        public int getUnitPrice() {
            return employee.getRate();
        }
    }

    static class Employee {
        private int rate;

        public Employee(int rate) {
            this.rate = rate;
        }

        public int getRate() {
            return rate;
        }
    }

    // Somewhere in client code
    Employee kent = new Employee(50);
    // Nota: I costruttori ora sono puliti, nessun parametro 'null' o '0' inutile.
    JobItem j1 = new LaborItem(5, kent);
    JobItem j2 = new PartsItem(15, 10);
    int total = j1.getTotalPrice() + j2.getTotalPrice();
}