package codesmell.replace_inheritance_with_delegation;

/**
 * SOLUZIONE: Refactoring tramite Delega (Composition over Inheritance).
 *
 * Abbiamo trasformato la relazione da Ereditarietà (IS-A) a Composizione (HAS-A).
 * La classe Car ora contiene un'istanza di Engine e "delega" a essa il lavoro.
 *
 * VANTAGGI:
 * - Modellazione Corretta: Rispetta la realtà (l'auto possiede il motore).
 * - Incapsulamento: Car può decidere quali metodi di Engine esporre e quali nascondere.
 * - Flessibilità: In futuro potremmo cambiare il motore a runtime (cosa impossibile con l'ereditarietà).
 */
public class MainAfter {
    class Engine {
        private double fuel;
        private double CV;

        public double getFuel() {
            return fuel;
        }

        public void setFuel(double fuel) {
            this.fuel = fuel;
        }

        public double getCV() {
            return CV;
        }

        public void setCV(double cv) {
            this.CV = cv;
        }
    }

    class Car {
        private String brand;
        private String model;

        /**
         * COMPOSITION: Car "HAS A" (possiede un) Engine.
         * Engine è ora un campo privato, non un genitore.
         */
        protected Engine engine;

        public Car() {
            this.engine = new Engine();
        }

        public String getName() {
            // DELEGA: Chiediamo al motore i suoi dati, invece di ereditarli.
            return brand + " " + model + " (" + engine.getCV() + "CV)";
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }
    }
}