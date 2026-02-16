package designpattern.builder;

/**
 * Classe principale che dimostra l'implementazione del <b>Builder Design Pattern</b>.
 *
 * <p>Il pattern Builder viene utilizzato per costruire oggetti complessi passo dopo passo.
 * È particolarmente utile quando un oggetto deve essere creato con molteplici configurazioni
 * possibili, evitando il cosiddetto "Telescoping Constructor Anti-Pattern" (costruttori
 * con troppi parametri, difficili da leggere e gestire).</p>
 */
public class Main {

    /**
     * COMPONENT: Product
     * <p>Rappresenta l'oggetto complesso (Computer) che vogliamo costruire.</p>
     *
     * <p>Caratteristiche principali di questa implementazione:</p>
     * <ul>
     * <li><b>Immutabilità:</b> Tutti i campi sono {@code final} e non ci sono setter.
     * Una volta costruito, l'oggetto non può cambiare stato.</li>
     * <li><b>Costruttore Privato:</b> L'unico modo per ottenere un'istanza è tramite
     * la classe {@link Builder}.</li>
     * </ul>
     */
    public static class Computer {

        /*
         * NOTA DIDATTICA:
         * Invece di avere un costruttore pubblico con 10/20 parametri, che sarebbe
         * incline a errori (es. scambiare due stringhe o due booleani), usiamo il Builder.
         * Esempio da evitare: new Computer("500GB", "8GB", true, false, true, ...);
         */

        // Parametri obbligatori (Required)
        private final String hdd;
        private final String ram;

        // Parametri opzionali (Optional)
        private final boolean isGraphicsCardEnabled;
        private final boolean isBluetoothEnabled;

        public String getHdd() {
            return hdd;
        }

        public String getRam() {
            return ram;
        }

        public boolean isGraphicsCardEnabled() {
            return isGraphicsCardEnabled;
        }

        public boolean isBluetoothEnabled() {
            return isBluetoothEnabled;
        }

        /**
         * Costruttore privato.
         *
         * <p>Copia i valori dall'oggetto {@link Builder} all'istanza finale di {@link Computer}.
         * Essendo privato, impedisce l'istanziazione diretta dall'esterno.</p>
         *
         * @param builder L'oggetto builder contenente la configurazione desiderata.
         */
        private Computer(Builder builder) {
            this.hdd = builder.hdd;
            this.ram = builder.ram;
            this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
            this.isBluetoothEnabled = builder.isBluetoothEnabled;
        }

        /**
         * COMPONENT: Builder
         * <p>Classe statica interna responsabile della costruzione dell'oggetto {@link Computer}.</p>
         *
         * <p>Implementa una <b>Fluent Interface</b> (i metodi ritornano {@code this})
         * per permettere il concatenamento delle chiamate (method chaining).</p>
         */
        public static class Builder {

            // Parametri obbligatori
            private final String hdd;
            private final String ram;

            // Parametri opzionali (inizializzati ai valori di default di Java, es. false)
            private boolean isGraphicsCardEnabled;
            private boolean isBluetoothEnabled;

            /**
             * Costruttore del Builder.
             *
             * <p>Forza il client a fornire i parametri strettamente necessari per
             * creare un oggetto valido.</p>
             *
             * @param hdd Hard Disk (parametro obbligatorio).
             * @param ram RAM (parametro obbligatorio).
             */
            public Builder(String hdd, String ram) {
                this.hdd = hdd;
                this.ram = ram;
            }

            /**
             * Imposta la scheda grafica (Opzionale).
             *
             * @param isGraphicsCardEnabled true per abilitare, false altrimenti.
             * @return L'istanza corrente del Builder per il chaining.
             */
            public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
                this.isGraphicsCardEnabled = isGraphicsCardEnabled;
                return this;
            }

            /**
             * Imposta il Bluetooth (Opzionale).
             *
             * @param isBluetoothEnabled true per abilitare, false altrimenti.
             * @return L'istanza corrente del Builder per il chaining.
             */
            public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
                this.isBluetoothEnabled = isBluetoothEnabled;
                return this;
            }

            /**
             * Metodo finale di costruzione.
             *
             * <p>Crea l'istanza effettiva di {@link Computer} passando il Builder stesso
             * al costruttore privato del Product.</p>
             *
             * @return Una nuova istanza immutabile di {@link Computer}.
             */
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    /**
     * Metodo Client.
     * Dimostra come istanziare un Computer usando la sintassi fluida del Builder.
     */
    public static void main(String[] args) {
        // Utilizzo del Builder per ottenere l'oggetto in una singola riga di codice,
        // leggibile e senza problemi di stato inconsistente.
        Computer comp =
                new Computer.Builder("500 GB", "2 GB")
                        .setBluetoothEnabled(true)
                        .setGraphicsCardEnabled(true)
                        .build();
    }
}