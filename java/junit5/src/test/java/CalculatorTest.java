import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CalculatorTest {

    @Test
    void calculate_price_from_item_and_price() {
        Calculator calculator = new Calculator();
        int expectedTotal = 10;
        int price = 10;

        int total = calculator.getTotal(price);

        assertThat(expectedTotal).isEqualTo(total);
    }

    @Test
    void calculate_price_from_items_and_price() {
        Calculator calculator = new Calculator();
        int expectedTotal = 200;
        int items = 20;
        int price = 10;

        int total = calculator.getTotal(items, price);

        assertThat(expectedTotal).isEqualTo(total);
    }

    @Test
    void  calculate_price_from_items_and_price_with_ut_taxes() {
        Calculator calculator = new Calculator();
        double expectedTotal = 200*1.0685;
        int items = 20;
        int price = 10;

        double total = calculator.getTotalUtah(items, price);


        assertThat(expectedTotal).isEqualTo(total);
    }
}
