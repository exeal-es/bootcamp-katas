import static org.assertj.core.api.Assertions.assertThat;

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

  @ParameterizedTest
  @ValueSource(ints = {1700, 1800, 1900})
  void years_divisible_by_100_are_not_leap_years(int year) {
    LeapYear leapYear = new LeapYear();
    boolean isLeapYear = leapYear.isLeapYear(year);
    assertThat(isLeapYear).isFalse();
  }
}
