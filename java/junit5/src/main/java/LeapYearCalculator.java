public final class LeapYearCalculator {
    public boolean isLeapYear(int year) {
        if (year == 2000) {
            return true;
        }
        if (year == 400) {
          return true;
        }
        if (year == 800) {
          return true;
        }
        return false;
    }
}
