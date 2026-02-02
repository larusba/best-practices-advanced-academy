package designpattern.strategy;

import java.util.List;

/**
 * Esempio del Design Pattern Strategy.
 *
 * SCOPO:
 * Definire una famiglia di algoritmi, incapsularli e renderli intercambiabili.
 *
 * PROBLEMA RISOLTO:
 * - Evita lunghi costrutti "if-else" o "switch-case" per scegliere un algoritmo.
 * - Permette di cambiare il comportamento di una classe (Context) a runtime.
 * - Rispetta l'Open/Closed Principle: possiamo aggiungere 'MergeSort' senza toccare la classe Context.
 */
public class Main {
    
    /**
     * COMPONENT: Strategy Interface 1.
     * Definisce il contratto comune per tutti gli algoritmi di ordinamento.
     */
    interface SortStrategy {
        void sort(List<String> list);
    }

    /**
     * COMPONENT: Concrete Strategy A (Sort).
     * Implementazione specifica (QuickSort).
     */
    static class QuickSortStrategyImpl implements SortStrategy {

        @Override
        public void sort(List<String> list) {
            System.out.println("List sorted using Quick sort implementation");
        }
    }

    /**
     * COMPONENT: Concrete Strategy B (Sort).
     * Implementazione specifica (BubbleSort).
     */
    static class BubbleSortStrategyImpl implements SortStrategy {

        @Override
        public void sort(List<String> list) {
            System.out.println("List sorted using Bubble sort implementation");
        }
    }

    /**
     * COMPONENT: Strategy Interface 2.
     * Possiamo avere più famiglie di strategie indipendenti nello stesso contesto.
     */
    interface SearchStrategy {
        String search(String s);
    }

    /** Concrete Strategy A (Search) */
    static class BinarySearchStrategyImpl implements SearchStrategy {
        @Override
        public String search(String s) {
            System.out.println("list is binary searched");
            return null;
        }
    }

    /** Concrete Strategy B (Search) */
    static class LinearSearchStrategyImpl implements SearchStrategy {

        @Override
        public String search(String s) {
            System.out.println("list is linearly searched");
            return null;
        }
    }

    /**
     * COMPONENT: Context.
     * La classe che "usa" le strategie.
     * NON implementa l'algoritmo, ma delega il lavoro all'oggetto strategia corrente.
     */
    static class Context {
        // Composizione: Il Context HA UNA strategia (o più).
        private SortStrategy sortStrategy;
        private SearchStrategy searchStrategy;

        /**
         * Dependency Injection: Le strategie iniziali vengono passate al costruttore.
         */
        public Context(SortStrategy sortStrategy, SearchStrategy searchStrategy) {
            this.sortStrategy = sortStrategy;
            this.searchStrategy = searchStrategy;
        }

        /**
         * Runtime Swap: Questi setter sono il cuore del pattern.
         * Ci permettono di cambiare "cervello" (algoritmo) all'oggetto mentre l'app gira.
         */
        public void setSortStrategy(SortStrategy sortStrategy) {
            this.sortStrategy = sortStrategy;
        }

        public void setSearchStrategy(SearchStrategy searchStrategy) {
            this.searchStrategy = searchStrategy;
        }

        public void sort(List<String> list) {
            // Delega polimorfica: "Non so come ordinare, fallo tu (strategia corrente)".
            sortStrategy.sort(list);
        }

        public String search(String s) {
            // perform search
            return searchStrategy.search(s);
        }
    }

    public static void main(String[] args) {
        List<String> list = List.of("b", "a", "c");
        
        // 1. Configurazione Iniziale
        // Scegliamo BubbleSort e BinarySearch
        Context context = new Context(new BubbleSortStrategyImpl(), new BinarySearchStrategyImpl());
        
        System.out.println("--- First Configuration ---");
        context.sort(list); // Usa BubbleSort
        String searchedElement1 = context.search("b"); // Usa BinarySearch
        System.out.println("searchedElement1 = " + searchedElement1);

        System.out.println("\n--- Runtime Swap ---");

        // 2. Cambio di Strategia a Runtime
        // Improvvisamente i dati crescono e BubbleSort è troppo lento?
        // Passiamo a QuickSort senza dover ricreare l'oggetto Context.
        context.setSortStrategy(new QuickSortStrategyImpl());
        context.setSearchStrategy(new LinearSearchStrategyImpl());
        
        context.sort(list); // Ora usa QuickSort!
        String searchedElement2 = context.search("a");
        System.out.println("searchedElement2 = " + searchedElement2);
    }
}