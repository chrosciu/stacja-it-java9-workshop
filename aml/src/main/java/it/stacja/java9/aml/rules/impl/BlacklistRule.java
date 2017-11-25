package it.stacja.java9.aml.rules.impl;

import it.stacja.java9.aml.providers.BlacklistProvider;
import it.stacja.java9.aml.rules.api.Rule;
import it.stacja.java9.aml.rules.api.ScanResult;
import it.stacja.java9.aml.rules.api.Transaction;
import it.stacja.java9.aml.util.Log;

import java.util.Arrays;
import java.util.List;

public class BlacklistRule implements Rule {

    @Override
    public ScanResult scan(Transaction transaction) {
        Log.log("Running BlacklistRule with id: " + this.getRunId());

        BlacklistProvider provider = new BlacklistProvider();
        
        try(provider) {
            return provider
                    .getBadGuys()
                    .stream()
                    //.filter(badGuy -> badGuy.getScore() >= 5)
                    .takeWhile(badGuy -> badGuy.getScore() >= 5)
                    .anyMatch(transaction::matches) ? ScanResult.failed() : ScanResult.ok();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getName() {
        return "BlacklistRule";
    }
}
