package com.codurance.srp;

public class AccountService {

    private final StatementPrinter statementPrinter;

    private TransactionRepository transactionRepository;
    private Clock clock;

    public AccountService(TransactionRepository transactionRepository, Clock clock, Console console) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
        statementPrinter = new StatementPrinter(console);
    }

    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }


    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }

    public void printStatement() {
        statementPrinter.printHeader();
        statementPrinter.printTransactions(transactionRepository.all());
    }

    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }


}