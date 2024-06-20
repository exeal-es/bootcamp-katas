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
            Transaction t = transactions.get(0);
            String formatDate = t.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            console.println(String.format(Locale.US, "%s || %.2f || %s || %.2f", formatDate, (double)t.getCredit(), "", (double)t.getBalance()));
        }
    }

    public void deposit(int amount) {
        LocalDate date = calendar.today();
        int credit = amount;
        int debit = 0;
        int balance = amount;
        transactions.add(new Transaction(date, credit, debit, balance));
    }
}
