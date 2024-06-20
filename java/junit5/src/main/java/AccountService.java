import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountService {
    private final Calendar calendar;
    private final Console console;
    private final TransactionRepository transactionRepository;

    public AccountService(Calendar calendar, Console console, TransactionRepository transactionRepository) {
        this.calendar = calendar;
        this.console = console;
        this.transactionRepository = transactionRepository;
    }

    public void printStatement() {
        console.println("date || credit || debit || balance");
        List<StatementLine> lines = buildLinesWithBalances();
        for (StatementLine line : reverse(lines)) {
            console.println(StatementLineFormatter.formatStatementLine(line));
        }
    }

    private List<StatementLine> buildLinesWithBalances() {
        List<StatementLine> lines = new ArrayList<>();
        int balance = 0;
        for (Transaction t : transactionRepository.getTransactions()) {
            balance += t.getAmount();
            lines.add(new StatementLine(t, balance));
        }
        return lines;
    }

    private static List<StatementLine> reverse(List<StatementLine> lines) {
        List<StatementLine> reversedLines = new ArrayList<>(lines);
        Collections.reverse(reversedLines);
        return reversedLines;
    }

    public void deposit(int amount) {
        LocalDate date = calendar.today();
        transactionRepository.addTransaction(new Transaction(date, amount));
    }

    public void withdraw(int amount) {
        LocalDate date = calendar.today();
        transactionRepository.addTransaction(new Transaction(date, -amount));
    }
}
