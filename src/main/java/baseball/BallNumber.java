package baseball;

public class BallNumber {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;

    private final int number;
    public BallNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException("1~9의 숫자가 아닙니다.");
        }
    }
}
