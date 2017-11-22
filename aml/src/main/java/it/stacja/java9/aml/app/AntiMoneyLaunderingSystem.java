package it.stacja.java9.aml.app;

import it.stacja.java9.aml.providers.LocalTransactionProvider;
import it.stacja.java9.aml.rules.api.Rule;
import it.stacja.java9.aml.rules.api.Transaction;
import it.stacja.java9.aml.rules.impl.BlacklistRule;
import it.stacja.java9.aml.rules.impl.HistoricalTransactionsRule;
import it.stacja.java9.aml.rules.impl.LongRunningRule;
import it.stacja.java9.aml.util.Log;
import it.stacja.tinyspring.TinySpringContext;

import java.io.IOException;
import java.util.List;

public class AntiMoneyLaunderingSystem {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*
            Add information about the current process
         */

        TinySpringContext tinySpringContext = new TinySpringContext("it.stacja.java9.aml.providers");
        LocalTransactionProvider localTransactionProvider = tinySpringContext.getElement(LocalTransactionProvider.class);
        List<Transaction> transactions = localTransactionProvider.getTransactions();

        checkAgainstRule(transactions, new BlacklistRule());
        checkAgainstRule(transactions, new LongRunningRule());
        checkAgainstRule(transactions, new HistoricalTransactionsRule());
    }

    static void checkAgainstRule(List<Transaction> transactions, Rule rule) {
        Log.log("---Checking " + rule.getName() + " rule---");
        transactions.forEach(t-> {
            Log.log(t);
            Log.log("Scan result: " + rule.scan(t));
            Log.newLine();
        });
        Log.newLine();
    }
}
