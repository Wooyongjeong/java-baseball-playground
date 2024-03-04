package baseball.ui;

import baseball.BallStatus;

public class OutputView {
    public void printResult(int ball, int strike) {
        String message = makeMessage(ball, strike);
        System.out.println(message);
    }

    private String makeMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return BallStatus.NOTHING.getMessage();
        }
        if (ball > 0 && strike == 0) {
            return getMessage(ball, BallStatus.BALL);
        }
        if (ball == 0 && strike > 0) {
            return getMessage(strike, BallStatus.STRIKE);
        }
        String ballMessage = getMessage(ball, BallStatus.BALL);
        String strikeMessage = getMessage(strike, BallStatus.STRIKE);
        return String.join(" ", ballMessage, strikeMessage);
    }

    private String getMessage(int count, BallStatus status) {
        if (count == 0) {
            return "";
        }
        return String.format("%d%s", count, status.getMessage());
    }

    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
