package com.codurance.srp;

public class StatementPrinter {
    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void printLine(String line) {
        console.printLine(line);
    }
}