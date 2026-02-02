package designpattern.decorator;

/**
 * Esempio del Design Pattern Decorator.
 *
 * Questo pattern permette di aggiungere comportamenti a un oggetto individualmente,
 * dinamicamente e in modo trasparente, senza influenzare il comportamento di altri
 * oggetti della stessa classe.
 *
 * PROBLEMA RISOLTO:
 * - Esplosione delle Classi: Se usassimo l'ereditarietà per combinare le caratteristiche,
 * avremmo bisogno di classi come BasicSportsCar, BasicLuxuryCar, SportsLuxuryCar, etc.
 * - Ereditarietà Multipla: In Java non possiamo estendere più classi contemporaneamente.
 *
 * SOLUZIONE:
 * - Usiamo la Composizione. "Avvolgiamo" l'oggetto base dentro dei Decoratori.
 * - Simile a una Matrioska: ogni strato aggiunge qualcosa e chiama lo strato interno.
 */
public class Main {
    /**
     * COMPONENT: Interfaccia comune.
     * Definisce il metodo che sarà implementato sia dall'oggetto concreto che dai decoratori.
     */
    interface Car {
        void assemble();
    }

    /**
     * CONCRETE COMPONENT: L'oggetto base.
     * Questa è l'auto standard su cui andremo ad aggiungere optional.
     */
    static class BasicCar implements Car {
        @Override
        public void assemble() {
            System.out.print("Basic Car.");
        }
    }

    static class AnotherCar implements Car {
        @Override
        public void assemble() {
            System.out.print("Another Car.");
        }
    }

    /**
     * DECORATOR (Base).
     *
     * Ha due caratteristiche fondamentali:
     * 1. Implementa l'interfaccia Component (Car), così può sostituire l'oggetto originale.
     * 2. HA UN (Has-A) riferimento a un oggetto Component (il campo 'car').
     *
     * Il suo compito di base è solo delegare la chiamata all'oggetto incapsulato.
     */
    static class CarDecorator implements Car {

        protected Car car;

        public CarDecorator(Car c) {
            this.car = c;
        }

        @Override
        public void assemble() {
            this.car.assemble();
        }
    }

    /**
     * CONCRETE DECORATOR 1 (Sports).
     *
     * Estende il comportamento base.
     * Prima delega all'oggetto interno (super.assemble), poi aggiunge la sua logica.
     */
    static class SportsCar extends CarDecorator {

        public SportsCar(Car c) {
            super(c);
        }

        @Override
        public void assemble() {
            // Delega al componente "interno" (che potrebbe essere una BasicCar o un altro Decorator)
            super.assemble();
            // Aggiunge la funzionalità specifica
            System.out.print(" Adding features of Sports Car.");
        }
    }

    /**
     * CONCRETE DECORATOR 2 (Luxury).
     */
    static class LuxuryCar extends CarDecorator {

        public LuxuryCar(Car c) {
            super(c);
        }

        @Override
        public void assemble() {
            super.assemble();
            System.out.print(" Adding features of Luxury Car.");
        }
    }

    public static void main(String[] args) {
        // Esempio 1: Singola decorazione
        // BasicCar viene avvolta da SportsCar.
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n-----");

        // Esempio 2: Decorazione Multipla (Chaining)
        // Qui si vede la potenza del pattern:
        // 1. Creiamo una BasicCar.
        // 2. La avvolgiamo in una LuxuryCar.
        // 3. Avvolgiamo il tutto in una SportsCar.
        //
        // Risultato: BasicCar + Luxury features + Sports features.
        // Tutto questo senza toccare il codice delle classi esistenti (Open/Closed Principle).
        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}