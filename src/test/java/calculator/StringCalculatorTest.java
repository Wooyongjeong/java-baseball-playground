package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    private static StringCalculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new StringCalculator();
    }

    @Test
    void calculate() {
        String input = "2 + 3 * 4 / 2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        int expected = 10;
        assertThat(calculator.calculate(scanner)).isEqualTo(expected);
    }

}