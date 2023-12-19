import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StatementPrinterShould {

	private Console console;
	private StatementPrinter statementPrinter;


	@BeforeEach
	void setUp() {
		console = Mockito.mock(Console.class);
		statementPrinter = new StatementPrinter(console);
	}

	@Test
	public void printHeader() {

		statementPrinter.print();

		Mockito.verify(console)
			.println("Date || Amount || Balance");
	}

}
