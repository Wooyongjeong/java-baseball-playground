package baseball;

import java.util.Objects;

public class BallNumber {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private final int number;

    public BallNumber(int number) {
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException("1~9의 숫자가 아닙니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
