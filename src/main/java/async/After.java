package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BEST PRACTICES E SOLUZIONI CON COMPLETABLEFUTURE.
 *
 * SOLUZIONI APPLICATE:
 * - Custom Executors: Utilizziamo thread pool dedicati per operazioni I/O bound.
 * Questo previene che operazioni lente blocchino il pool di calcolo della CPU (ForkJoinPool).
 * - Non-Blocking Composition: Invece di .get(), usiamo callback come .thenAccept()
 * per reagire quando il dato è pronto, lasciando il main thread libero di fare altro.
 * - Exception Handling: Uso di .exceptionally() per catturare errori e fornire valori
 * di default (fallback), rendendo il sistema resiliente (Graceful Degradation).
 */
public class After {

    public static void main(String[] args) {

        // 1. Use a custom Executor for I/O-bound operations
        // BEST PRACTICE: Isolamento delle risorse (Bulkhead pattern).
        // Creiamo un pool dedicato per non intasare quello globale.
        ExecutorService customExecutor = Executors.newFixedThreadPool(5);
        
        CompletableFuture<Integer> future1 =
                CompletableFuture.supplyAsync(
                        () -> {
                            // Perform I/O-bound operation asynchronously
                            return performIOOperation();
                        },
                        customExecutor); // Passiamo l'executor esplicito

        // 2. Proper exception handling with exceptionally()
        ExecutorService computationExecutor = Executors.newFixedThreadPool(5);
        CompletableFuture<Integer> future2 =
                CompletableFuture.supplyAsync(
                                () -> {
                                    // Perform asynchronous computation
                                    return performComputation();
                                },
                                computationExecutor)
                        .thenApplyAsync(
                                result -> {
                                    // Process the result asynchronously
                                    return result + 10;
                                },
                                customExecutor)
                        .exceptionally(
                                ex -> {
                                    // 2. Handle the exception gracefully
                                    // BEST PRACTICE: Recupero dagli errori (Fallback)
                                    System.err.println("Exception occurred: " + ex.getMessage());
                                    return 0; // Provide a default value
                                });

        // 3. Avoid blocking the main thread
        // BEST PRACTICE: Il main thread continua o termina senza aspettare attivamente (busy wait).
        // Il codice dentro thenAccept verrà eseguito solo quando il future sarà completato.
        future1.thenAccept(
                result -> {
                    // Process the result asynchronously
                    System.out.println("Result: " + result);
                });

        future2.thenAccept(
                result -> {
                    // Process the result asynchronously
                    System.out.println("Result from future2: " + result);
                });

        // Shutdown the customExecutor to release resources
        // Importante: gli ExecutorService vanno chiusi o la JVM potrebbe non terminare.
        customExecutor.shutdown();
        computationExecutor.shutdown();
    }

    private static Integer performComputation() {
        // Simulate computation
        return 10;
    }

    private static Integer performIOOperation() {
        // Simulate a blocking operation
        try {
            Thread.sleep(5000); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 10;
    }
}