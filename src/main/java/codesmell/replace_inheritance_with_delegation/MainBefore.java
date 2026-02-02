package codesmell.replace_inheritance_with_delegation;

/**
 * PROBLEMA: Abuso dell'Ereditarietà (Inheritance Abuse).
 *
 * Questo codice viola la logica "IS-A" (È-Un) solo per riutilizzare del codice.
 *
 * CRITICITA':
 * - Errore Semantico: Un'auto NON E' un motore. Un'auto HA un motore.
 * - Inquinamento dell'API: Estendendo Engine, la classe Car eredita ed espone
 * tutti i metodi pubblici di Engine (es. setFuel), anche quelli che non dovrebbe esporre.
 * - Accoppiamento: Car è indissolubilmente legata alla classe Engine a tempo di compilazione.
 */
public class MainBefore {
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

    /**
     * CODE SMELL: "Car extends Engine".
     * L'ereditarietà è usata qui solo come scorciatoia per accedere ai campi fuel/CV,
     * non perché Car sia un sottotipo di Engine.
     */
    class Car extends Engine {
        private String brand;
        private String model;

        /** Engin is just used here in getName, via getCv() */
        public String getName() {
            return brand + " " + model + " (" + getCV() + "CV)";
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