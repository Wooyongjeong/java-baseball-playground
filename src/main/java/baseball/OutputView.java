package baseball;

public class OutputView {
    // 컴퓨터와 사용자의 수를 비교한 결과를 출력하는 기능
    public void printResult(int ball, int strike) {
        if (ball > 0 && strike == 0) {
            String result = String.format("%d볼", ball);
            System.out.println(result);
            return;
        }
        if (ball == 0 && strike > 0) {
            String result = String.format("%d스트라이크", strike);
            System.out.println(result);
            return;
        }
        if (ball > 0 && strike > 0) {
            String result = String.format("%d볼 %d스트라이크", ball, strike);
            System.out.println(result);
            return;
        }
        System.out.println("낫싱");
    }

    // 게임 종료 문구 출력
    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
