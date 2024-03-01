package baseball;

import java.util.Objects;

public class Ball {
    private final int position;
    private final BallNumber ballNumber;

    public Ball(int position, int ballNumber) {
        this.position = position;
        this.ballNumber = new BallNumber(ballNumber);
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.matchBallNumber(ballNumber)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNumber(BallNumber ballNumber) {
        return this.ballNumber.equals(ballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return position == ball.position && Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }
}
