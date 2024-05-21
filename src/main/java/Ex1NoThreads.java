import java.util.ArrayList;
import java.util.List;

public class Ex1NoThreads {

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        List<Integer> numbers = createNumbersList(size);

        for (int number : numbers) {
            System.out.println(number + "^2=" + (number * number));
        }

    }

    private static List<Integer> createNumbersList(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
