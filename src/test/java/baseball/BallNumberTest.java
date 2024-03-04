package baseball;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 4, 5})
    void inRange(int number) {
        assertThatNoException()
                .isThrownBy(() -> new BallNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void notInRange(int number) {
        assertThatThrownBy(() -> new BallNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9의 숫자가 아닙니다.");
    }
}
