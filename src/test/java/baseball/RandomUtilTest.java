package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {

    @Test
    void makeOneRandomNumber() {
        int number = RandomUtil.makeOneRandomNumber();
        assertThatNoException()
                .isThrownBy(() -> new BallNumber(number));
    }

    @Test
    void makeRandomNumbers() {
        List<Integer> numbers = RandomUtil.makeRandomNumbers(3);
        assertThat(numbers).doesNotHaveDuplicates();
    }
}
