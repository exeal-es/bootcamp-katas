import javax.swing.plaf.nimbus.State;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        List<StatementLine> lines = new ArrayList<>();
        int balance = 0;
        for (Transaction t : transactions) {
            balance += t.getAmount();
            lines.add(new StatementLine(t, balance));
        }

        List<StatementLine> reversedLines = new ArrayList<>(lines);
        Collections.reverse(reversedLines);
        for (StatementLine line : reversedLines) {
            console.println(TransactionFormatter.formatTransaction(line.getTransaction(), line.getBalance()));
        }
    }

    private static class StatementLine {
        private Transaction transaction;
        private int balance;

        public StatementLine(Transaction transaction, int balance) {

            this.transaction = transaction;
            this.balance = balance;
        }


        public Transaction getTransaction() {
            return transaction;
        }

        public int getBalance() {
            return balance;
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
