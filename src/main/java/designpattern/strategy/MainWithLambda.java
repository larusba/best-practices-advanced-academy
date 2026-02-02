package designpattern.strategy;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Esempio del Design Pattern Strategy "Moderno" (Java 8+).
 *
 * SCOPO:
 * Semplificare l'implementazione del pattern utilizzando le Lambda Expressions.
 *
 * DIFFERENZA CHIAVE:
 * - Approccio Classico: Creiamo un'interfaccia (es. SortStrategy) e una classe per ogni algoritmo.
 * - Approccio Lambda: Usiamo le interfacce funzionali standard (`Consumer`, `Function`)
 * per passare direttamente il blocco di codice dell'algoritmo.
 *
 * QUANDO USARLO:
 * Perfetto per strategie semplici (un solo metodo). Se la strategia richiede stato complesso
 * o più metodi, meglio tornare all'approccio classico con le classi.
 */
public class MainWithLambda {

    /**
     * COMPONENT: Context.
     * Invece di interfacce custom, usiamo quelle di `java.util.function`.
     */
    static class Context {
        // Consumer<T>: Accetta un input, non restituisce nulla (void).
        // Ideale per sostituire 'void sort(List<String> list)'
        private Consumer<List<String>> sortStrategy;

        // Function<T, R>: Accetta un input T, restituisce un output R.
        // Ideale per sostituire 'String search(List<String> list)'
        private Function<List<String>, String> searchStrategy;

        void sort(List<String> list) {
            // Esegue la lambda
            sortStrategy.accept(list);
        }

        public Context(
                Consumer<List<String>> sortStrategy,
                Function<List<String>, String> searchStrategy) {
            this.sortStrategy = sortStrategy;
            this.searchStrategy = searchStrategy;
        }

        public void setSortStrategy(Consumer<List<String>> sortStrategy) {
            this.sortStrategy = sortStrategy;
        }

        public void setSearchStrategy(Function<List<String>, String> searchStrategy) {
            this.searchStrategy = searchStrategy;
        }

        public String search(List<String> list) {
            // Esegue la lambda
            return searchStrategy.apply(list);
        }
    }

    public static void main(String[] args) {
        List<String> list = List.of("b", "a", "c");

        // 1. Definizione "Inline" delle strategie.
        // Non servono classi separate (BubbleSortStrategyImpl, ecc.).
        // Definiamo il comportamento al volo.
        Consumer<List<String>> bubbleSort =
                l -> System.out.println("List sorted using Bubble sort implementation");
        
        Function<List<String>, String> binarySearch =
                list1 -> {
                    System.out.println("list is binary searched");
                    return null;
                };

        // Iniezione delle Lambda nel Context
        Context context = new Context(bubbleSort, binarySearch);

        context.sort(list);
        String searchedElement1 = context.search(list);
        System.out.println("searchedElement = " + searchedElement1);

        System.out.println("-------------");

        // 2. Runtime Swap con nuove Lambda
        // Possiamo passare direttamente il codice senza nemmeno assegnarlo a una variabile
        Consumer<List<String>> quickSort =
                list1 -> System.out.println("List sorted using Quick sort implementation");
        
        Function<List<String>, String> linearSearch =
                l -> {
                    System.out.println("list is linearly searched");
                    return null;
                };
        
        context.setSortStrategy(quickSort);
        context.setSearchStrategy(linearSearch);
        
        context.sort(list);
        String searchedElement2 = context.search(list);
        System.out.println("searchedElement2 = " + searchedElement2);
    }
}