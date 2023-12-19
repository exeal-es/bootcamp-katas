import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StatementPrinterShould {

  private Console console;
  private ConsoleStatementPrinter statementPrinter;

  @BeforeEach
  void setUp() {
    console = Mockito.mock(Console.class);
    statementPrinter = new ConsoleStatementPrinter(console);
  }

  @Test
  public void printHeader() {
    final List<Transaction> transactions = Collections.emptyList();
    statementPrinter.print(transactions);

    Mockito.verify(console).println("Date || Amount || Balance");
  }

  @Test
  public void printTransaction() {
    final Transaction transaction =
        new Transaction(LocalDate.of(2012, 1, 14), 500, 2500, TransactionType.WITHDRAW);
    final List<Transaction> transactions = List.of(transaction);

    statementPrinter.print(transactions);

    Mockito.verify(console).println("14/01/2012 || -500 || 2500");
  }
}
