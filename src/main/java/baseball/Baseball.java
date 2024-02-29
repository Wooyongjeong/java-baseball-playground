package baseball;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Baseball {
    public static final int MAX_NUM = 10;
    public static final int SIZE = 3;
    public static final String ZERO = "0";
    public static final String GAME_CONTINUE = "1";
    private final InputView inputView;
    private final OutputView outputView;

    public Baseball(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    // 숫자야구게임 시작
    public void play() {
        boolean isNotEnd = true;
        while (isNotEnd) {
            // 컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개를 선택한다
            String[] computerNumbers = makeComputerNumbers();
            System.out.println(Arrays.toString(computerNumbers));
            isNotEnd = startInning(computerNumbers);
        }
    }

    // 컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개를 선택한다
    public String[] makeComputerNumbers() {
        String[] numbers = null;

        boolean notDuplicate = true;
        boolean notContainsZero = true;
        while (notDuplicate || notContainsZero) {
            numbers = makeRandomNumbers(SIZE);
            notDuplicate = isNotDuplicate(numbers);
            notContainsZero = isNotContainsZero(numbers);
        }

        return numbers;
    }

    // size 크기의 랜덤한 숫자가 들어있는 배열 생성
    public String[] makeRandomNumbers(int size) {
        String[] numbers = new String[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int number = random.nextInt(MAX_NUM);
            numbers[i] = String.valueOf(number);
        }
        return numbers;
    }


    public boolean isNotContainsZero(String[] numbers) {
        return !Arrays.asList(numbers).contains(ZERO);
    }

    // 입력으로 주어진 배열 내의 숫자들 중 중복되는 수가 있는지 판별
    public boolean isNotDuplicate(String[] numbers) {
        Set<String> set = Arrays.stream(numbers).collect(Collectors.toSet());
        return set.size() < numbers.length;
    }

    // 숫자야구 시작
    public boolean startInning(String[] computerNumbers) {
        boolean isNotEnd = true;
        while (isNotEnd) {
            // 사용자로부터 숫자를 입력받는 기능
            String playerNumberInput = inputView.inputBaseballNumber();
            String[] playerNumbers = playerNumberInput.split("");

            // 컴퓨터와 사용자의 수를 비교하는 기능
            Result result = compare(playerNumbers, computerNumbers);

            // 컴퓨터와 사용자의 수를 비교한 결과를 출력하는 기능
            outputView.printResult(result.getBall(), result.getStrike());

            // 3개의 숫자를 모두 맞혔는지 판별하는 기능
            isNotEnd = isInningNotEnd(result);
        }
        // 게임 종료 문구 출력
        outputView.printGameEnd();

        // 사용자로부터 게임을 다시 시작할 지, 종료할 지 입력받는 기능
        String gameCommand = inputView.inputGameCommand();
        return GAME_CONTINUE.equals(gameCommand);
    }

    // 컴퓨터와 사용자의 수를 비교하는 기능
    public Result compare(String[] playerNumbers, String[] computerNumbers) {
        Result result = new Result();
        result.compare(playerNumbers, computerNumbers);
        return result;
    }

    // 3개의 숫자를 모두 맞혔는지 판별하는 기능
    public boolean isInningNotEnd(Result result) {
        return result.getStrike() < SIZE;
    }
}
