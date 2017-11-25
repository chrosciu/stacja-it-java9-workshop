package it.stacja.java9.aml.providers;

import it.stacja.java9.aml.rules.api.Transaction;
//import it.stacja.tinyspring.Element;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

//@Element
public class LocalTransactionProvider implements TransactionProvider {
    public List<Transaction> getTransactions() {
        return Arrays.asList(
                new Transaction("Jan", "Kowalski",
                        "Grazyna", "Kowalska",
                        BigDecimal.valueOf(10)
                ),
                new Transaction("John", "Doe",
                        "Hannibal", "Lecter",
                        BigDecimal.valueOf(1000000)
                ),
                new Transaction("Bruce", "Wayne",
                        "Peter", "Parker",
                        BigDecimal.valueOf(1)
                )
        );
    }
}
