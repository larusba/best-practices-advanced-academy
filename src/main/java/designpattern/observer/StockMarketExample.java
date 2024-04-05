package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Mercato azionario
 * Suppose we want to create a stock market monitoring system where 
 * `investors can subscribe to receive stock price updates` 
 * for specific companies. 
 * 
 */
public class StockMarketExample {
    
    /**
     * COMPONENT: Observer interface and concrete implementations
     */
    public interface StockObserver {
        void update(String stockSymbol, double stockPrice);
    }

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
     * COMPONENT: Subject component 
     */
    public interface StockMarket {
        void registerObserver(StockObserver observer);
        void removeObserver(StockObserver observer);
        void notifyObservers(String stockSymbol, double stockPrice);
    }

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

            stockMarket.registerObserver(investor1);
            stockMarket.registerObserver(investor2);

            stockMarket.notifyObservers("INFY", 1250.0); // Both investors receive updates
            stockMarket.notifyObservers("TCS", 2500.0); // Both investors receive updates

            stockMarket.removeObserver(investor1);

            stockMarket.notifyObservers("WIPRO", 700.0); // Only investor2 receives the update
        }
    }
}
