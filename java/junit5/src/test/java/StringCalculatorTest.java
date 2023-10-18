import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StringCalculatorTest {

    @Test
    void it_should_return_zero_when_string_empty() {
        String numbers = "";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void it_should_return_1_when_string_is_1(){
        String numbers = "1";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void it_should_return_2_when_string_is_2(){
        String numbers = "2";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void it_should_return_3_when_string_is_3(){
        String numbers = "3";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(3);
    }
}
