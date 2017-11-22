package it.stacja.java9.aml.rules.impl;

import it.stacja.java9.aml.providers.HistoricalTransactionsProvider;
import it.stacja.java9.aml.rules.api.Rule;
import it.stacja.java9.aml.rules.api.ScanResult;
import it.stacja.java9.aml.rules.api.Transaction;
import it.stacja.java9.aml.util.Log;

import java.util.Optional;

public class HistoricalTransactionsRule implements Rule {
    @Override
    public ScanResult scan(Transaction transaction) {
        Log.log("Running HistoricalTransactionsRule with id: " + this.getRunId());
        
        boolean biggestTransactionEver = new HistoricalTransactionsProvider()
                .getBiggestTransactionsFromLast12Months(transaction.getSenderFirstName(), transaction.getSenderLastName())
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .allMatch(hist -> hist.compareTo(transaction.getAmount()) < 0);

        return biggestTransactionEver ? ScanResult.failed() : ScanResult.ok();
    }

    @Override
    public String getName() {
        return "HistoricalTransactionsRule";
    }
}
