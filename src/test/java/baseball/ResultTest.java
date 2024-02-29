package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {
    Result result;

    @BeforeEach
    void beforeAll() {
        result = new Result();
    }

    @DisplayName("컴퓨터와 사용자의 수를 비교하는 기능")
    @ParameterizedTest
    @MethodSource("providePlayerNumbersAndComputerNumbers")
    void compare(String[] playerNumbers, String[] computerNumbers, int ball, int strike) {
        result.compare(playerNumbers, computerNumbers);
        assertThat(result.getBall()).isEqualTo(ball);
        assertThat(result.getStrike()).isEqualTo(strike);
    }

    static Stream<Arguments> providePlayerNumbersAndComputerNumbers() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3"}, new String[]{"4", "5", "6"}, 0, 0),
                Arguments.of(new String[]{"1", "2", "3"}, new String[]{"3", "4", "5"}, 1, 0),
                Arguments.of(new String[]{"1", "2", "3"}, new String[]{"3", "1", "4"}, 2, 0),
                Arguments.of(new String[]{"1", "2", "3"}, new String[]{"3", "1", "4"}, 2, 0),
                Arguments.of(new String[]{"1", "2", "3"}, new String[]{"1", "3", "2"}, 2, 1),
                Arguments.of(new String[]{"1", "2", "3"}, new String[]{"1", "3", "4"}, 1, 1),
                Arguments.of(new String[]{"1", "2", "3"}, new String[]{"1", "7", "8"}, 0, 1),
                Arguments.of(new String[]{"1", "2", "3"}, new String[]{"1", "2", "9"}, 0, 2),
                Arguments.of(new String[]{"1", "2", "3"}, new String[]{"1", "2", "3"}, 0, 3)
        );
    }
}