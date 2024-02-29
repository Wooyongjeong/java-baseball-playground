package calculator;

import java.util.Scanner;

public class StringCalculator {
    public int calculate(Scanner scanner) {
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        return calculate(values);
    }

    private int calculate(String[] values) {
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length - 1; i += 2) {
            String operator = values[i];
            int number = Integer.parseInt(values[i + 1]);
            result = calculate(result, operator, number);
        }

        return result;
    }

    private int calculate(int number1, String operator, int number2) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
        }
        return 0;
    }
}
