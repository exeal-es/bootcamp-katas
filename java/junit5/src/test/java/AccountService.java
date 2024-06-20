import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
            console.println(TransactionFormatter.formatTransaction(transactions.get(0)));
        }
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
