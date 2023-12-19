public class AccountService {

	private final Clock clock;
	private final Console console;

	public AccountService(Clock clock, Console console) {
		this.clock = clock;
		this.console = console;
	}

	void deposit(int amount) {

	}

	void withdraw(int amount) {

	}

	void printStatement() {
		StatementPrinter statementPrinter = new StatementPrinter(console);
		statementPrinter.print();
	}
}
