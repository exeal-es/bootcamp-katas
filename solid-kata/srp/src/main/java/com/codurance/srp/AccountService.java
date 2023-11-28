package com.codurance.srp;

import java.text.MessageFormat;
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
                .map(transaction -> statementLine(transaction, balance.addAndGet(transaction.amount())))
                .collect(toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(line -> statementPrinter.printLine(line));
    }


    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }


    private String statementLine(Transaction transaction, int balance) {
        return MessageFormat.format("{0} | {1} | {2}", statementPrinter.formatDate(transaction.date()), statementPrinter.formatNumber(transaction.amount()), statementPrinter.formatNumber(balance));
    }


}