package baseball;

public class Result {
    public static final int GAME_END = 3;
    private int ball = 0;
    private int strike = 0;

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.strike += 1;
        }
        if (status.isBall()) {
            this.ball += 1;
        }
    }

    public boolean isGameEnd() {
        return strike == GAME_END;
    }
}
