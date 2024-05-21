import java.util.List;
import java.util.stream.IntStream;

public class Ex1ParallelStream {

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        List<Integer> numbers = IntStream.range(0, size).boxed().toList();

        numbers.parallelStream().forEach(number -> System.out.println(number + "^2=" + (number * number)));
    }
}
