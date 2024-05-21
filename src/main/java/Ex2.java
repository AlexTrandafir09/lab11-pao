import java.io.FileWriter;
import java.io.IOException;

public class Ex2 {

    public static void main(String[] args) throws IOException {
        int[] datasetSizes = {10, 1000, 10000, 10000000};
        String fileName = "C:\\Users\\trand\\IdeaProjects\\lab11-pao\\src\\test\\java\\execution_times.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            for (int size : datasetSizes) {
                long ThreadsTime = measureExecutionTime(() -> {
                    try {
                        Ex1Threads.main(new String[]{String.valueOf(size)});
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                writer.write("Ex1Threads," + size + "," + ThreadsTime + "\n");


                long ParallelStreamTime = measureExecutionTime(() -> Ex1ParallelStream.main(new String[]{String.valueOf(size)}));
                writer.write("Ex1ParallelStream," + size + "," + ParallelStreamTime + "\n");


                long CompletableFutureTime = measureExecutionTime(() -> Ex1CompletableFuture.main(new String[]{String.valueOf(size)}));
                writer.write("Ex1CompletableFuture," + size + "," + CompletableFutureTime + "\n");


                long NoThreadsTime = measureExecutionTime(() -> Ex1NoThreads.main(new String[]{String.valueOf(size)}));
                writer.write("Ex1NoThreads," + size + "," + NoThreadsTime + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static long measureExecutionTime(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
}
