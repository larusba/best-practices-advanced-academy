package codesmell.null_object;

/**
 * PROBLEMA: "Null Check Pollution" (Inquinamento da controlli Null).
 *
 * Quando un metodo può restituire null, obbliga chi lo chiama a difendersi
 * costantemente con controlli condizionali per evitare crash.
 *
 * SVANTAGGI:
 * - Codice ripetitivo: Lo stesso check (customer == null) è ripetuto ovunque nel client.
 * - Fragilità: Se ci si dimentica un solo check, l'applicazione lancia una NullPointerException.
 * - Scarsa leggibilità: La logica di business è nascosta dalla logica difensiva.
 */
public class NullObjectBefore {
    static class Company {
        private Customer customer;

        public Company(Customer customer) {
            this.customer = customer;
        }

        public Customer getCustomer() {
            // Rischio: può restituire null se non inizializzato
            return customer;
        }
    }

    static class Customer {
        // …
        public String getName() {
            return "name";
        }

        public String getPlan() {
            return "plan";
        }
        // a lot of methods...
    }

    public static void main(String[] args) {

        // Somewhere in client code
        Customer customer = new Company(null).getCustomer();

        // CODE SMELL:
        // Siamo costretti a usare l'operatore ternario o if/else per ogni singola chiamata.
        String plan = customer == null ? "nullPlan" : customer.getPlan();

        String name = customer == null ? "nullName" : customer.getName();

        System.out.println("name = " + name);
        System.out.println("plan = " + plan);
    }
}