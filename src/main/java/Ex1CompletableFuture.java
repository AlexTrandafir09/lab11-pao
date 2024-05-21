import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex1CompletableFuture {

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        ExecutorService executor = Executors.newWorkStealingPool();

        CompletableFuture<Void>[] futures = new CompletableFuture[size];

        for (int i = 0; i < size; i++) {
            final int number = i;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println(number + "^2=" + (number * number)), executor);
            futures[i] = future;
        }

        CompletableFuture<Void> all = CompletableFuture.allOf(futures);
        all.join();

        executor.shutdown();
    }
}
