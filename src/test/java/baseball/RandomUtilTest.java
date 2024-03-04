package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {
    private RandomUtil util;

    @BeforeEach
    void setUp() {
        util = new RandomUtil();
    }

    @Test
    void makeOneRandomNumber() {
        int number = util.makeOneRandomNumber();
        assertThatNoException()
                .isThrownBy(() -> new BallNumber(number));
    }

    @Test
    void makeRandomNumbers() {
        List<Integer> numbers = util.makeRandomNumbers(3);
        assertThat(numbers).doesNotHaveDuplicates();
    }
}
