package it.stacja.java9.aml.providers;

import it.stacja.java9.aml.rules.api.Transaction;

import java.util.List;

@Deprecated(forRemoval = true)
public class OldTransactionProvider implements TransactionProvider {
    public List<Transaction> getTransactions() {
        throw new UnsupportedOperationException();
    }
}
