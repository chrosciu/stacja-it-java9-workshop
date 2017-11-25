module aml {
    //requires tinyspring;
    //exports it.stacja.java9.aml.providers to tinyspring;
    //exports it.stacja.java9.aml.rules.api;
    //opens it.stacja.java9.aml.providers to tinyspring;
    uses it.stacja.java9.aml.rules.api.Rule;
    requires amlapi;
    provides it.stacja.java9.aml.rules.api.Rule with
            it.stacja.java9.aml.rules.impl.BlacklistRule,
            it.stacja.java9.aml.rules.impl.LongRunningRule,
            it.stacja.java9.aml.rules.impl.HistoricalTransactionsRule;
}