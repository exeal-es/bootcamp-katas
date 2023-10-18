import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;


class StringCalculatorTest {

    @Test
    void it_should_return_zero_when_string_empty() {
        String numbers = "";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3"})
    void it_should_return_the_number_representation(final String number,
        final Integer expectedResult) {

        int result = StringCalculator.add(number);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void it_should_return_the_add_from_string_with_1comma2(){
        String numbers = "1,2";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void it_should_return_the_add_from_string_with_2comma2(){
        String numbers = "2,2";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(4);
    }
}
