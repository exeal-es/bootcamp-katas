import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class LeapYearTest {

  @ParameterizedTest
  @CsvSource({"400, true", "800, true", "2000, true", "401, false"})
  public void should_return_leap_year_for_years_divisible_by_400(final int year,
      final boolean expectedResult) {

    final LeapYearCalculator leapYearCalculator = new LeapYearCalculator();
    final boolean isLeapYear = leapYearCalculator.isLeapYear(year);

    assertThat(isLeapYear).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @CsvSource({"1700, false", "1800, false", "1900, false", "2100, false"})
  public void should_not_return_leap_year_for_years_divisible_by_100_and_not_for_400(final int year,
      final boolean expectedResult) {

    final LeapYearCalculator leapYearCalculator = new LeapYearCalculator();
    final boolean isLeapYear = leapYearCalculator.isLeapYear(year);

    assertThat(isLeapYear).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @CsvSource({"4, true", "8, true", "12, true"})
  public void should_return_leap_year_for_years_divisible_by_4_and_not_for_100(final int year,
      final boolean expectedResult) {

    final LeapYearCalculator leapYearCalculator = new LeapYearCalculator();
    final boolean isLeapYear = leapYearCalculator.isLeapYear(year);

    assertThat(isLeapYear).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @CsvSource({"2023, false", "2027, false", "2031, false", "2025, false"})
  public void should_not_return_leap_year_for_years_not_divisible_by_4(final int year,
      final boolean expectedResult) {

    final LeapYearCalculator leapYearCalculator = new LeapYearCalculator();
    final boolean isLeapYear = leapYearCalculator.isLeapYear(year);

    assertThat(isLeapYear).isEqualTo(expectedResult);
  }
}
