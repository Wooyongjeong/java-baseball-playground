package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    public static final int SIZE = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> ballNumbers) {
        if (ballNumbers.size() != SIZE) {
            throw new IllegalArgumentException("세 자리 수가 아닙니다.");
        }
        balls = mapBall(ballNumbers);
    }

    private List<Ball> mapBall(List<Integer> ballNumbers) {
        return IntStream.range(0, SIZE)
                .mapToObj(i -> new Ball(i + 1, ballNumbers.get(i)))
                .collect(Collectors.toList());
    }

    public Result play(List<Integer> userNumbers) {
        Balls userBalls = new Balls(userNumbers);
        Result result = new Result();
        for (Ball ball : balls) {
            BallStatus status = userBalls.play(ball);
            result.report(status);
        }
        return result;
    }

    public BallStatus play(Ball other) {
        return balls.stream()
                .map(ball -> ball.play(other))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
