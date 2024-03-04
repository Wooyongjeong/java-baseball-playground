package baseball;

public class Result {
    private int ball = 0;
    private int strike = 0;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isGameEnd(int gameEnd) {
        return strike == gameEnd;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.strike += 1;
        }
        if (status.isBall()) {
            this.ball += 1;
        }
    }
}
