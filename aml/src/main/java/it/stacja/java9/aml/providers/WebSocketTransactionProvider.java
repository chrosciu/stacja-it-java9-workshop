package it.stacja.java9.aml.providers;

import it.stacja.java9.aml.rules.api.Transaction;

import java.util.List;

public class WebSocketTransactionProvider implements TransactionProvider {
    @Override
    public List<Transaction> getTransactions() {
        throw new UnsupportedOperationException("TO BE IMPLEMENTED");
    }
}
