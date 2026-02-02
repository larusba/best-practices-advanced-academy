package refactoring.extract_subclass;

/**
 * ESEMPIO "BEFORE": Classe candidata per "Extract Subclass".
 *
 * CODE SMELL: "Class with Type Code" / "Conditional Logic".
 *
 * Questa classe JobItem gestisce due concetti diversi (Manodopera e Parti)
 * basandosi su un flag booleano 'isLabor'.
 *
 * Problemi didattici:
 * - Campi opzionali/inutili: Se 'isLabor' è true, 'unitPrice' viene ignorato.
 * Se 'isLabor' è false, 'employee' è null.
 * - Costruttore confuso: Il client è costretto a passare 'null' o '0' per i parametri
 * che non servono in quel contesto specifico.
 */
public class MainBefore {
    static class JobItem {
        private int quantity;
        private int unitPrice;
        private Employee employee;
        private boolean isLabor;

        /**
         * Costruttore "sporco".
         * Richiede parametri che potrebbero non aver senso (es. employee per un pezzo di ricambio).
         */
        public JobItem(int quantity, int unitPrice, boolean isLabor, Employee employee) {
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.isLabor = isLabor;
            this.employee = employee;
        }

        public int getTotalPrice() {
            return quantity * getUnitPrice();
        }

        public int getQuantity() {
            return quantity;
        }

        /**
         * Logica condizionale esplicita.
         * Questo metodo deve controllare il flag per sapere come comportarsi.
         * Se aggiungessimo un terzo tipo di lavoro, dovremmo modificare questo metodo (violazione Open/Closed).
         */
        public int getUnitPrice() {
            return (isLabor) ? employee.getRate() : unitPrice;
        }

        public Employee getEmployee() {
            return employee;
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
    // Nota come il codice client sia costretto a passare parametri "dummy" (0 o null)
    Employee kent = new Employee(50);
    JobItem j1 = new JobItem(5, 0, true, kent);
    JobItem j2 = new JobItem(15, 10, false, null);
    int total = j1.getTotalPrice() + j2.getTotalPrice();
}