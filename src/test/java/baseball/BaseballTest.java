package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballTest {
    static InputView inputView;
    static OutputView outputView;
    static Baseball baseball;

    @BeforeAll
    static void beforeAll() {
        inputView = new InputView();
        outputView = new OutputView();
        baseball = new Baseball(inputView, outputView);
    }

    @DisplayName("컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개를 선택하는 기능")
    @Test
    void makeComputerNumbers() {
        String[] computerNumbers = baseball.makeComputerNumbers();

        assertThat(computerNumbers.length).isEqualTo(Baseball.SIZE);
        assertThat(computerNumbers).doesNotHaveDuplicates();
    }

    @DisplayName("3개의 숫자를 모두 맞혔는지 판별하는 기능")
    @Test
    void isInningEnd() {
        String[] playerNumbers = new String[]{"1", "2", "3"};
        String[] computerNumbers = new String[]{"1", "2", "3"};
        Result result = baseball.compare(playerNumbers, computerNumbers);
        boolean inningNotEnd = baseball.isInningNotEnd(result);
        assertThat(inningNotEnd).isFalse();
    }
}