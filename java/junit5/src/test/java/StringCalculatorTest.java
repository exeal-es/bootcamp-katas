import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringCalculatorTest {

    @Test
    void it_should_return_zero_when_string_empty() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "";
        int expectedResult = 0;

        int result = stringCalculator.add(input);

        assertThat(result)
                .isEqualTo(expectedResult);
    }
}
