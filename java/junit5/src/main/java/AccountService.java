import java.util.List;

public class AccountService {

	private final AccountRepository accountRepository;
	private final StatementPrinter statementPrinter;
	private final Clock clock;
	private final Console console;

	public AccountService(AccountRepository accountRepository, StatementPrinter statementPrinter,
			Clock clock, Console console) {
		this.accountRepository = accountRepository;
		this.statementPrinter = statementPrinter;
		this.clock = clock;
		this.console = console;
	}

	void deposit(int amount) {

	}

	void withdraw(int amount) {

	}

	void printStatement() {
		final List<Transaction> transactions = accountRepository.getTransactions();
		statementPrinter.print(transactions);
	}
}
