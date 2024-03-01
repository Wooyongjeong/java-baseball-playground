package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    private final List<Ball> answers;

    public Balls(List<Integer> answers) {
        this.answers = mapBall(answers);
    }

    private static List<Ball> mapBall(List<Integer> answers) {
        return IntStream.range(0, 3)
                .mapToObj(i -> new Ball(i + 1, answers.get(i)))
                .collect(Collectors.toList());
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public Result play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        Result result = new Result();
        for (Ball answer : answers) {
            BallStatus status = userBalls.play(answer);
            result.report(status);
        }
        return result;
    }
}
