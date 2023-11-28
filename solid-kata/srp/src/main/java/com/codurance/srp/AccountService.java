package com.codurance.srp;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

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
        printTransactions(transactionRepository.all());
    }


    private void printTransactions(List<Transaction> allTransactions) {
        final AtomicInteger balance = new AtomicInteger(0);
        allTransactions.stream()
                .map(transaction -> statementPrinter.statementLine(transaction, balance.addAndGet(transaction.amount()), this))
                .collect(toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(line -> statementPrinter.printLine(line));
    }


    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }


}