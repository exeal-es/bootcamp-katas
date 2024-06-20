import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AccountService {
    private final Calendar calendar;
    private final Console console;

    private List<Transaction> transactions = new ArrayList<>();

    public AccountService(Calendar calendar, Console console) {
        this.calendar = calendar;
        this.console = console;
    }

    public void printStatement() {
        console.println("date || credit || debit || balance");
        if (!transactions.isEmpty()) {
            printTransaction(transactions.get(0));
        }
    }

    private void printTransaction(Transaction t) {
        String formatDate = t.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int amount = t.getAmount();
        int credit = t.getAmount() >= 0 ? amount : 0;
        int debit = t.getAmount() < 0 ? -amount : 0;
        int balance = amount;
        String formatCredit = formatNumberWithTwoDecimals(credit);
        String formatDebit = formatNumberWithTwoDecimals(debit);
        String formatBalance = formatNumberWithTwoDecimals(balance);
        console.println(String.format("%s || %s || %s || %s", formatDate, formatCredit, formatDebit, formatBalance));
    }

    private static String formatNumberWithTwoDecimals(int amount) {
        if (amount == 0) {
            return "";
        }
        return String.format(Locale.US, "%.2f", (double)amount);
    }

    public void deposit(int amount) {
        LocalDate date = calendar.today();
        transactions.add(new Transaction(date, amount));
    }

    public void withdraw(int amount) {
        LocalDate date = calendar.today();
        transactions.add(new Transaction(date, -amount));
    }
}
