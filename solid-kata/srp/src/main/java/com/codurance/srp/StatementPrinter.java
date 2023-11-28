package com.codurance.srp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class StatementPrinter {
    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void printLine(String line) {
        console.printLine(line);
    }

    void printHeader() {
        final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
        printLine(STATEMENT_HEADER);
    }

    String formatNumber(int amount) {
        final String AMOUNT_FORMAT = "#.00";
        DecimalFormat decimalFormat = new DecimalFormat(AMOUNT_FORMAT, DecimalFormatSymbols.getInstance(Locale.UK));
        return decimalFormat.format(amount);
    }
}