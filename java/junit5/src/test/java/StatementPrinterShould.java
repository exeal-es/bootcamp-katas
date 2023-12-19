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

		Mockito.verify(console)
			.println("Date || Amount || Balance");
	}

	@Test
	public void printStatement() {

	}
}
