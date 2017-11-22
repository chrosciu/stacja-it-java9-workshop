package it.stacja.java9.aml.providers;

import it.stacja.java9.aml.rules.api.Transaction;

import java.util.List;

public interface TransactionProvider {
    List<Transaction> getTransactions();
}
