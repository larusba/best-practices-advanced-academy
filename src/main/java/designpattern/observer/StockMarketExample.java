package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ESEMPIO 2: Mercato Azionario (Push Model).
 *
 * A differenza dell'esempio precedente, qui i dati non vengono "tirati" (get) dall'Observer,
 * ma vengono "spinti" (Push) dal Subject tramite i parametri del metodo update().
 */
public class StockMarketExample {
    
    /**
     * COMPONENT: Observer Interface.
     * I sottoscrittori (Investitori) devono implementare questo metodo.
     */
    public interface StockObserver {
        // PUSH MODEL: I dati (symbol, price) sono passati direttamente.
        void update(String stockSymbol, double stockPrice);
    }

    /**
     * Concrete Observer.
     */
    public static class Investor implements StockObserver {
        private String name;

        public Investor(String name) {
            this.name = name;
        }

        @Override
        public void update(String stockSymbol, double stockPrice) {
            System.out.println(name + " received an update for " + stockSymbol + ": $" + stockPrice);
        }
    }


    /**
     * COMPONENT: Subject Interface.
     * Definisce le operazioni di gestione delle sottoscrizioni.
     */
    public interface StockMarket {
        void registerObserver(StockObserver observer);
        void removeObserver(StockObserver observer);
        void notifyObservers(String stockSymbol, double stockPrice);
    }

    /**
     * Concrete Subject.
     */
    public static class StockMarketImpl implements StockMarket {
        private List<StockObserver> observers = new ArrayList<>();

        @Override
        public void registerObserver(StockObserver observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(StockObserver observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers(String stockSymbol, double stockPrice) {
            for (StockObserver observer : observers) {
                // Notifica push a tutti gli iscritti
                observer.update(stockSymbol, stockPrice);
            }
        }
    }
    

    // -- usage example
    public static class Main {
        public static void main(String[] args) {
            StockMarket stockMarket = new StockMarketImpl();

            StockObserver investor1 = new Investor("Alice");
            StockObserver investor2 = new Investor("Bob");

            // Registrazione dinamica
            stockMarket.registerObserver(investor1);
            stockMarket.registerObserver(investor2);

            System.out.println("--- First Update ---");
            stockMarket.notifyObservers("INFY", 1250.0); // Tutti ricevono notifica

            System.out.println("--- Investor leaves ---");
            // Disiscrizione (Unsubscribe)
            stockMarket.removeObserver(investor1);

            stockMarket.notifyObservers("WIPRO", 700.0); // Solo Bob riceve notifica
        }
    }
}