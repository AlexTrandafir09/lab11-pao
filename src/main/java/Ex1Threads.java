import java.util.ArrayList;
import java.util.List;

public class Ex1Threads {

    public static void main(String[] args) throws InterruptedException {
        int nr_threads = Runtime.getRuntime().availableProcessors();
        int size = Integer.parseInt(args[0]);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        List<Thread> threads = new ArrayList<>();
        int numbersperthread = size / nr_threads;

        for (int i = 0; i < nr_threads; i++) {
            int start = i * numbersperthread;
            int end = (i == nr_threads - 1) ? size : start + numbersperthread;

            Thread thread = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    int number = numbers.get(j);
                    System.out.println(number + "^2=" + (number * number));
                }
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}