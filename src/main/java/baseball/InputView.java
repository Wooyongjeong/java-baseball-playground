package baseball;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    // 사용자로부터 숫자를 입력받는 기능
    public String inputBaseballNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }

    // 사용자로부터 게임을 다시 시작할 지, 종료할 지 입력받는 기능
    public String inputGameCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine();
    }
}
