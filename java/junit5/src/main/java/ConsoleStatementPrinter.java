import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConsoleStatementPrinter implements StatementPrinter {

  private final Console console;

  public ConsoleStatementPrinter(Console console) {

    this.console = console;
  }

  public void print(List<Transaction> transactions) {
    console.println("Date || Amount || Balance");
    if (transactions.isEmpty()) {
      return;
    }

    final Transaction transaction = transactions.get(0);
    console.println(
        DateTimeFormatter.ofPattern("dd/MM/yyyy").format(transaction.getDate())
            + " || "
            + "-" + transaction.getAmount()
            + " || "
            + transaction.getBalance());
  }
}
