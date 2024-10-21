import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LeapYearTests {

  @Test
  void year_2008_is_leap_year_because_its_divisible_by_4() {
    LeapYear leapYear = new LeapYear();
    boolean isLeapYear = leapYear.isLeapYear(2008);
    assertThat(isLeapYear).isTrue();
  }

  @Test
  void year_2012_is_leap_year_because_its_divisible_by_4() {
    LeapYear leapYear = new LeapYear();
    boolean isLeapYear = leapYear.isLeapYear(2012);
    assertThat(isLeapYear).isTrue();
  }

  @Test
  void year_2016_is_leap_year_because_its_divisible_by_4() {
    LeapYear leapYear = new LeapYear();
    boolean isLeapYear = leapYear.isLeapYear(2016);
    assertThat(isLeapYear).isTrue();
  }
}
