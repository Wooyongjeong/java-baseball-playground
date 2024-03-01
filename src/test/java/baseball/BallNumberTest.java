package baseball;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BallNumberTest {
    @Test
    void 야구_숫자_1_9_검증() {
        assertThatNoException().isThrownBy(() -> {
            new BallNumber(9);
            new BallNumber(1);
            new BallNumber(4);
            new BallNumber(5);
        });
    }

    @Test
    void 야구_숫자_예외_발생() {
        assertThatThrownBy(() -> new BallNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9의 숫자가 아닙니다.");

        assertThatThrownBy(() -> new BallNumber(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9의 숫자가 아닙니다.");
    }
}
