package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static int makeOneRandomNumber() {
        return random.nextInt(9) + 1;
    }

    public static List<Integer> makeRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < size) {
            makeNoDuplicateNumber(numbers);
        }
        return numbers;
    }

    private static void makeNoDuplicateNumber(List<Integer> numbers) {
        int number = makeOneRandomNumber();
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
