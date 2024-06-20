import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TransactionFormatter {
    public static String formatTransaction(Transaction t) {
        String formatDate = t.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int credit = t.getCredit();
        int debit = t.getDebit();
        int balance = t.getAmount();
        String formatCredit = formatNumberWithTwoDecimals(credit);
        String formatDebit = formatNumberWithTwoDecimals(debit);
        String formatBalance = formatNumberWithTwoDecimals(balance);
        return String.format("%s || %s || %s || %s", formatDate, formatCredit, formatDebit, formatBalance);
    }

    public static String formatNumberWithTwoDecimals(int amount) {
        if (amount == 0) {
            return "";
        }
        return String.format(Locale.US, "%.2f", (double) amount);
    }
}