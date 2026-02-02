package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ERRORI COMUNI NELLA PROGRAMMAZIONE ASINCRONA.
 *
 * Questa classe mostra un utilizzo ingenuo delle API asincrone che porta a
 * problemi di performance (colli di bottiglia) e instabilità in produzione.
 *
 * PROBLEMI PRINCIPALI:
 * - Thread Starvation: supplyAsync() senza argomenti usa il ForkJoinPool comune di sistema.
 * Eseguire operazioni bloccanti (es. Thread.sleep o I/O) qui dentro può congelare
 * l'intera applicazione.
 * - Blocking Main Thread: L'uso di future1.get() blocca il thread principale in attesa
 * del risultato, vanificando completamente i benefici della programmazione asincrona.
 * - Fragilità: Manca la gestione delle eccezioni. Se performComputation fallisce,
 * l'intero flusso si rompe silenziosamente o in modo incontrollato.
 */
public class Before {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1. Creating CompletableFuture without specifying Executor
        // BAD PRACTICE: Stiamo usando il ForkJoinPool.commonPool() per operazioni lente.
        // Questo pool è dimensionato sul numero di core della CPU e non deve mai essere bloccato.
        CompletableFuture<Integer> future1 =
                CompletableFuture.supplyAsync(
                        () -> {
                            // Blocking operation inside CompletableFuture
                            return performBlockingOperation();
                        });

        // 2. Chaining multiple CompletableFuture operations without proper exception handling
        // BAD PRACTICE: Se performComputation lancia eccezione, il programma crasha o si blocca.
        CompletableFuture<Integer> future2 =
                CompletableFuture.supplyAsync(
                                () -> {
                                    return performComputation();
                                })
                        .thenApply(
                                result -> {
                                    return result + 10;
                                });

        // 3. Blocking the main thread by calling get() method
        // BAD PRACTICE: Trasformiamo un'operazione asincrona in sincrona (bloccante).
        // Il main thread rimane fermo qui finché il future non è completo.
        Integer result = future1.get();
        System.out.println("Result: " + result);
    }

    private static Integer performComputation() {
        return 10;
    }

    private static Integer performBlockingOperation() {
        // Simulate a blocking operation
        try {
            Thread.sleep(5000); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 10;
    }
}