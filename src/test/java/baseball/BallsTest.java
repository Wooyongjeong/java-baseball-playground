package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BallsTest {
    private static Balls computerBalls;

    @BeforeAll
    static void beforeAll() {
        computerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @ParameterizedTest
    @MethodSource("providePlayArguments")
    void play(List<Integer> userNumbers, int expectedBall, int expectedStrike, boolean expectedGameEnd) {
        Result result = computerBalls.play(userNumbers);
        assertThat(result.getBall()).isEqualTo(expectedBall);
        assertThat(result.getStrike()).isEqualTo(expectedStrike);
        assertThat(result.isGameEnd()).isEqualTo(expectedGameEnd);
    }

    static Stream<Arguments> providePlayArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), 0, 3, true),
                Arguments.of(Arrays.asList(4, 5, 6), 0, 0, false),
                Arguments.of(Arrays.asList(1, 3, 4), 1, 1, false),
                Arguments.of(Arrays.asList(1, 2, 4), 0, 2, false),
                Arguments.of(Arrays.asList(2, 1, 4), 2, 0, false)
        );
    }

    @Test
    void strike() {
        BallStatus status = computerBalls.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus status = computerBalls.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus status = computerBalls.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
