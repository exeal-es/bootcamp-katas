import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class StatementLineFormatter {
    public static String formatStatementLine(StatementLine line) {
        String formatDate = line.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String formatCredit = formatNumberWithTwoDecimals(line.getCredit());
        String formatDebit = formatNumberWithTwoDecimals(line.getDebit());
        String formatBalance = formatNumberWithTwoDecimals(line.getBalance());
        return String.format("%s || %s || %s || %s", formatDate, formatCredit, formatDebit, formatBalance);
    }

    public static String formatNumberWithTwoDecimals(int amount) {
        if (amount == 0) {
            return "";
        }
        return String.format(Locale.US, "%.2f", (double) amount);
    }
}