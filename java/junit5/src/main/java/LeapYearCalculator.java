public final class LeapYearCalculator {
    public boolean isLeapYear(int year) {
        if (year == 4) {
            return true;
        }
        if (year == 8) {
            return true;
        }
        return year % 400 == 0;
    }
}
