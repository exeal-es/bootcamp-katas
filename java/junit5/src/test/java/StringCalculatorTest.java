import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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


    private static Stream<Arguments> firstNumberPlusTwoTestParameters() {
        return Stream.of(
                Arguments.of("1,2", 3),
                Arguments.of("2,2", 4),
                Arguments.of("3,2", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("firstNumberPlusTwoTestParameters")
    void it_should_return_the_sum_of_first_number_plus_two(final String number,
                                                    final Integer expectedResult) {

        int result = StringCalculator.add(number);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void it_should_return_the_sum_of_2_plus_1() {
        String numbers = "2,1";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void it_should_return_the_sum_of_2_plus_3() {
        String numbers = "2,3";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void it_should_return_the_sum_of_2_plus_4() {
        String numbers = "2,4";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void it_should_return_the_sum_of_5_plus_7() {
        String numbers = "5,7";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(12);
    }
}
