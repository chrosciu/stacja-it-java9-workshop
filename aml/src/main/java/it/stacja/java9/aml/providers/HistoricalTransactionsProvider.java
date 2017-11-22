package it.stacja.java9.aml.providers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HistoricalTransactionsProvider {
    public List<Optional<BigDecimal>> getBiggestTransactionsFromLast12Months(String firstName, String lastName) {
        return Stream
                .iterate(1, i -> i+1)
                .limit(12)
                .map(i -> i % 2 == 0 ? BigDecimal.valueOf(i*1000) : null)
                .map(Optional::ofNullable)
                .collect(Collectors.toList());
    }
}
