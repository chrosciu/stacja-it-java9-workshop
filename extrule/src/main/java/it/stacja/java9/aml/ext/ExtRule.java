package it.stacja.java9.aml.ext;

import it.stacja.java9.aml.rules.api.Rule;
import it.stacja.java9.aml.rules.api.ScanResult;
import it.stacja.java9.aml.rules.api.Transaction;

//public class ExtRule {
//}

public class ExtRule implements Rule {
    @Override
    public ScanResult scan(Transaction transaction) {
        return ScanResult.ok();
    }

    @Override
    public String getName() {
        return "ExtRule";
    }
}
