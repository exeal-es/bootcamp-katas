public class StatementPrinter {

	private final Console console;

	public StatementPrinter(Console console) {

		this.console = console;
	}


	public void print() {
		console.println("Date || Amount || Balance");
	}
}
