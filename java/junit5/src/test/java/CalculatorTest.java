import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CalculatorTest {

    @Test
    void it_should_print_hello_world() {
        final Calculator calculator = new Calculator("Hello World!");
        assertThat(calculator.getMessage()).isEqualTo("Hello World!");
    }
}
