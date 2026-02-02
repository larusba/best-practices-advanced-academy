package codesmell.null_object;

/**
 * SOLUZIONE: Design Pattern Null Object.
 *
 * L'idea è incapsulare l'assenza di un oggetto fornendo un'alternativa che
 * "non fa nulla" o restituisce dati neutri, invece di restituire null.
 *
 * VANTAGGI:
 * - Pulizia: Il client invoca i metodi senza preoccuparsi se l'oggetto esiste o no.
 * - Polimorfismo: Sostituiamo la logica condizionale (if null) con il polimorfismo.
 * - Robustezza: Si eliminano drasticamente le NullPointerException nel client.
 */
public class NullObjectAfter {
    static class Company {
        private Customer customer;

        public Company(Customer customer) {
            this.customer = customer;
        }

        /**
         * Punto chiave: Non restituiamo mai null.
         * Se il customer manca, restituiamo un NullCustomer.
         */
        public Customer getCustomer() {
            return (customer == null) ? new NullCustomer() : customer;
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

    /**
     * Null Object:
     * Una classe concreta che estende Customer ma rappresenta lo stato "Vuoto".
     * Implementa i metodi restituendo valori di default sicuri o non facendo nulla.
     */
    static class NullCustomer extends Customer {
        @Override
        public String getName() {
            return "nullName";
        }

        @Override
        public String getPlan() {
            return "nullPlan";
        }
    }

    public static void main(String[] args) {
        Customer customer = new Company(null).getCustomer();

        // CLEAN CODE:
        // Nessun controllo null necessario. Se è un NullCustomer, risponderà con i default.
        String plan = customer.getPlan();
        String name = customer.getName();

        System.out.println("name = " + name);
        System.out.println("plan = " + plan);
    }
}