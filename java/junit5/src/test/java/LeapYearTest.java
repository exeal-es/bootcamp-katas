import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LeapYearTest {

    @Test
    public void should_return_leap_year_for_year_2000() {
        final int year = 2000;

        final LeapYearCalculator leapYearCalculator = new LeapYearCalculator();
        final boolean isLeapYear = leapYearCalculator.isLeapYear(year);

        assertThat(isLeapYear).isTrue();
    }
}
