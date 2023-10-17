import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CalculatorTest {

    @Test
    void it_should_return_total() {
        final Calculator calculator = new Calculator(2, 20.0);
        assertThat(calculator.getTotal()).isEqualTo(40.0);
    }
}
