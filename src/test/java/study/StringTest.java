package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1", "2");
        assertThat(values).containsExactly("1", "2");

        values = "1".split(",");
        assertThat(values).contains("1");
        assertThat(values).containsExactly("1");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String input = "abc";
        char result1 = input.charAt(0);
        char result2 = input.charAt(1);
        char result3 = input.charAt(2);
        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('b');
        assertThat(result3).isEqualTo('c');

        assertThatThrownBy(() -> {
            input.charAt(input.length());
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }


}
