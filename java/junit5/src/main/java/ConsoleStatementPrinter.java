import java.util.List;

public class ConsoleStatementPrinter implements StatementPrinter {

	private final Console console;

	public ConsoleStatementPrinter(Console console) {

		this.console = console;
	}


	public void print(List<Transaction> transactions) {
		console.println("Date || Amount || Balance");
	}
}
