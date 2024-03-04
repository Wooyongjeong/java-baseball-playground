package baseball;

import baseball.ui.InputView;
import baseball.ui.OutputView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        // 출력
        OutputView outputView = new OutputView();

        // 숫자 야구 게임
        Baseball baseball = new Baseball(inputView, outputView);
        baseball.play();

        // 종료
        scanner.close();
    }
}
