package baseball;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Baseball baseball = new Baseball(inputView, outputView);
        baseball.play();
    }
}
