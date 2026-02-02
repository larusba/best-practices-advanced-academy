package designpattern.decorator;

/**
 * Esempio concreto del Pattern Decorator: Calcolo del prezzo della Pizza.
 *
 * IL PROBLEMA:
 * Vogliamo calcolare il costo di una pizza con diverse combinazioni di ingredienti (toppings).
 * Usare l'ereditarietà classica porterebbe a un'esplosione combinatoria di classi
 * (es. CheeseAndSalamiPizza, CheeseOnlyPizza, SalamiAndMushroomsPizza...).
 *
 * LA SOLUZIONE:
 * Usiamo il Decorator per "avvolgere" la pizza base con strati di ingredienti.
 * Ogni ingrediente è un oggetto che contiene la pizza (o l'ingrediente precedente) al suo interno.
 * Quando chiamiamo cost(), la richiesta attraversa tutti gli strati, sommando i prezzi.
 */
public class Food {
    public class Main {
        public static void main(String[] args) {
            // 1. Iniziamo con l'oggetto base (Concrete Component)
            Pizza simplePizza = new SimplePizza();
            
            // 2. Prima decorazione: Avvolgiamo la pizza nel formaggio
            Pizza cheesePizza = new Cheese(simplePizza);
            
            // 3. Seconda decorazione: Avvolgiamo il risultato nel salame
            // Struttura in memoria: Salami -> contiene -> Cheese -> contiene -> SimplePizza
            Pizza salamiPizza = new Salami(cheesePizza);

            System.out.println(simplePizza.getDescription() + " - $" + simplePizza.cost());
            // Output: Simple pizza - $8.99
            
            System.out.println(cheesePizza.getDescription() + " - $" + cheesePizza.cost());
            // Output: Simple pizza, with cheese - $10.49
            
            System.out.println(salamiPizza.getDescription() + " - $" + salamiPizza.cost());
            // Output: Simple pizza, with cheese, with salami - $12.49
        }
    }


    /**
     * COMPONENT: Interfaccia Component.
     * Definisce i metodi comuni sia per l'oggetto base che per i decoratori.
     * Garantisce che un decoratore possa essere passato ovunque ci si aspetti una Pizza.
     */
    public interface Pizza {
        String getDescription();
        double cost();
    }
    
    /**
     * CONCRETE COMPONENT: L'oggetto Base.
     * Rappresenta l'elemento centrale che verrà decorato.
     * È il punto di terminazione della catena di chiamate (non ha riferimenti ad altre pizze).
     */
    public static class SimplePizza implements Pizza {
        @Override
        public String getDescription() {
            return "Simple pizza";
        }

        @Override
        public double cost() {
            return 8.99;
        }
    }

    /**
     * DECORATOR: Classe Astratta Decorator.
     *
     * Ruoli fondamentali:
     * - IS-A Pizza: Implementa l'interfaccia Component per essere intercambiabile.
     * - HAS-A Pizza: Mantiene un riferimento (composizione) all'oggetto che sta decorando.
     *
     * La sua implementazione di default è delegare le chiamate all'oggetto 'decoratedPizza'.
     */
    public abstract static class PizzaDecorator implements Pizza {
        protected Pizza decoratedPizza;

        protected PizzaDecorator(Pizza decoratedPizza) {
            this.decoratedPizza = decoratedPizza;
        }

        @Override
        public String getDescription() {
            return decoratedPizza.getDescription();
        }

        @Override
        public double cost() {
            return decoratedPizza.cost();
        }
    }

    // -- Concrete Decorators --

    /**
     * Decoratore Concreto 1: Formaggio.
     * Aggiunge il proprio stato (costo del formaggio) e comportamento (descrizione)
     * al risultato dell'oggetto decorato.
     */
    public static class Cheese extends PizzaDecorator {
        public Cheese(Pizza decoratedPizza) {
            super(decoratedPizza);
        }

        @Override
        public String getDescription() {
            // Estende il comportamento: Recupera stringa precedente + aggiunge testo
            return super.getDescription() + ", with cheese";
        }

        @Override
        public double cost() {
            // Estende il comportamento: Recupera costo precedente + aggiunge prezzo
            return super.cost() + 1.50; // Cheese costs $1.50
        }
    }

    /**
     * Decoratore Concreto 2: Salame.
     */
    public static class Salami extends PizzaDecorator {
        public Salami(Pizza decoratedPizza) {
            super(decoratedPizza);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", with pepperoni";
        }

        @Override
        public double cost() {
            return super.cost() + 2.00; // Pepperoni costs $2.00
        }
    }

}