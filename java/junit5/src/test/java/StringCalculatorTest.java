import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringCalculatorTest {

    @Test
    void it_should_return_zero_when_string_empty() {
        String input = "";
        int expectedResult = 0;

        int result = StringCalculator.add(input);

        assertThat(result)
                .isEqualTo(expectedResult);
    }
}
