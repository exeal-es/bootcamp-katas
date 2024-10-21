import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LeapYearTests {

  @ParameterizedTest
  @ValueSource(ints = {2008, 2012, 2016})
  void years_divisible_by_4_are_leap_years(int year) {
    LeapYear leapYear = new LeapYear();
    boolean isLeapYear = leapYear.isLeapYear(year);
    assertThat(isLeapYear).isTrue();
  }

  @Test
  void year_1700_is_not_a_leap_year() {
    LeapYear leapYear = new LeapYear();
    boolean isLeapYear = leapYear.isLeapYear(1700);
    assertThat(isLeapYear).isFalse();
  }
}
