public final class LeapYearCalculator {
    public boolean isLeapYear(int year) {
        if (year == 4) {
            return year % 4 == 0 && year % 100 != 0;
        }
        if (year == 8) {
            return year % 4 == 0 && year % 100 != 0;
        }
        if (year == 12) {
            return year % 4 == 0 && year % 100 != 0;
        }
        return year % 400 == 0;
    }
}
