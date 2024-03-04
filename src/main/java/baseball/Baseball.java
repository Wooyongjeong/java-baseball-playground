package baseball;

import baseball.ui.InputView;
import baseball.ui.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Baseball {
    public static final int SIZE = 3;
    private final InputView inputView;
    private final OutputView outputView;

    public Baseball(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        GameCommand gameCommand = GameCommand.CONTINUE;
        while (!gameCommand.isEnd()) {
            startInning();
            gameCommand = GameCommand.from(inputView.inputGameCommand());
        }
    }

    private void startInning() {
        List<Integer> randomNumbers = RandomUtil.makeRandomNumbers(SIZE);
        System.out.println(randomNumbers);
        Balls answers = new Balls(randomNumbers);

        boolean isEnd = false;
        while (!isEnd) {
            String inputBalls = inputView.inputBalls();
            List<Integer> balls = fromUserInputBalls(inputBalls);
            Result result = answers.play(balls);
            printResult(result);
            isEnd = result.isGameEnd(SIZE);
        }
    }

    private void printResult(Result result) {
        int ball = result.getBall();
        int strike = result.getStrike();
        outputView.printResult(ball, strike);
        if (strike == SIZE) {
            outputView.printGameEnd();
        }
    }

    private List<Integer> fromUserInputBalls(String inputBalls) {
        String[] balls = inputBalls.split("");
        return Arrays.stream(balls)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
