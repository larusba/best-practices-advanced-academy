package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Before {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1. Creating CompletableFuture without specifying Executor
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Blocking operation inside CompletableFuture
            return performBlockingOperation();
        });

        // 2. Chaining multiple CompletableFuture operations without proper exception handling
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            return performComputation();
        }).thenApply(result -> {
            return result + 10;
        });

        // 3. Blocking the main thread by calling get() method
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
