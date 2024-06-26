package Executors.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        // supplyAsync
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running computation
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
        // Use the result of the CompletableFuture
        future1.thenAccept(result -> System.out.println("Result: " + result));

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            //Simulate a long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed");
        });

        future.thenRun(() -> System.out.println("Callback after task completion"));


        // thenApply
        CompletableFuture<String> future2 = future1.thenApply(result -> "Transformed Result: " + result);

        // thenCompose
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 20)
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result * 2));

        // thenCombine
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Integer> combinedFuture = future4.thenCombine(future5, (result1, result2) -> result1 + result2);

        // exceptionally
        CompletableFuture<Object> future6 = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Exception occurred");
        }).exceptionally(exception -> {
            System.out.println("Exception occurred: " + exception.getMessage());
            return 0;
        });

        // allOf
        CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future8 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future7, future8);

        // thenRun
        allFutures.thenRun(() -> System.out.println("All futures completed"));

        // Join all futures to wait for their completion
        CompletableFuture.allOf(future1, future2, future3, future4, future5, future6, future7, future8).join();

        CompletableFuture<String> future9 = new CompletableFuture<>();

        // Complete the future with a value after a delay
        CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS)
                .execute(() -> future9.complete("Result"));

        // Complete the future with a default value if it hasn't been completed before the timeout
        future9.completeOnTimeout("Default", 1, TimeUnit.SECONDS);

        // Wait for the future to complete and print the result
        try {
            String result = future9.get();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        CompletableFuture<Integer> future10 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Task was interrupted.");
            }
            return 42;
        });

        boolean cancelled = future10.cancel(true);
        System.out.println("Task cancelled: " + cancelled);
    }
    
}
