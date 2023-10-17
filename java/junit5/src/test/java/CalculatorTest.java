import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CalculatorTest {

    @Test
    void it_should_return_total_with_utah_taxes() {
        final Calculator calculator = new Calculator(2, 20.0, 0.0685);
        assertThat(calculator.getTotal()).isEqualTo(42.74);
    }
}
