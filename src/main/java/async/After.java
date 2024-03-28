package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class After {

    public static void main(String[] args) {
        
        // 1. Use a custom Executor for I/O-bound operations
        ExecutorService customExecutor = Executors.newFixedThreadPool(5);
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Perform I/O-bound operation asynchronously
            return performIOOperation();
        }, customExecutor);

        // 2. Proper exception handling with exceptionally()
        ExecutorService computationExecutor = Executors.newFixedThreadPool(5);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            // Perform asynchronous computation
            return performComputation();
        }, computationExecutor).thenApplyAsync(result -> {
            // Process the result asynchronously
            return result + 10;
        }, customExecutor)
                .exceptionally(ex -> {
            // 2. Handle the exception gracefully
            System.err.println("Exception occurred: " + ex.getMessage());
            return 0; // Provide a default value
        });

        // 3. Avoid blocking the main thread
        future1.thenAccept(result -> {
            // Process the result asynchronously
            System.out.println("Result: " + result);
        });

        future2.thenAccept(result -> {
            // Process the result asynchronously
            System.out.println("Result from future2: " + result);
        });

        // Shutdown the customExecutor to release resources
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