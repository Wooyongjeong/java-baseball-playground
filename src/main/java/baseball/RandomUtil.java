package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    private final Random random;

    public RandomUtil() {
        random = new Random();
    }

    public int makeOneRandomNumber() {
        return random.nextInt(9) + 1;
    }

    public List<Integer> makeRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < size) {
            makeNoDuplicateNumber(numbers);
        }
        return numbers;
    }

    private void makeNoDuplicateNumber(List<Integer> numbers) {
        int number = makeOneRandomNumber();
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
