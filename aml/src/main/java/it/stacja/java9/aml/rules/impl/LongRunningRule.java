package it.stacja.java9.aml.rules.impl;

import it.stacja.java9.aml.rules.api.Rule;
import it.stacja.java9.aml.rules.api.ScanResult;
import it.stacja.java9.aml.rules.api.Transaction;
import it.stacja.java9.aml.services.LongRunningChecks;
import it.stacja.java9.aml.util.Log;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongRunningRule implements Rule {
    private static final int TIMEOUT = 12;
    private static final ScheduledThreadPoolExecutor delayer = new ScheduledThreadPoolExecutor(1, r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);

        return t;
    });

    @Override
    public ScanResult scan(Transaction transaction) {
        Log.log("Running LongRunningRule with id: " + this.getRunId());

        CompletableFuture<Object> fastService = CompletableFuture
                .anyOf(CompletableFuture.supplyAsync(LongRunningChecks::check5sec), timeoutAfter(TIMEOUT, TimeUnit.SECONDS));

        CompletableFuture<Object> mediumService = CompletableFuture
                .anyOf(CompletableFuture.supplyAsync(LongRunningChecks::check10sec), timeoutAfter(TIMEOUT, TimeUnit.SECONDS));

        CompletableFuture<Object> slowService = CompletableFuture
                .anyOf(CompletableFuture.supplyAsync(LongRunningChecks::check15sec), timeoutAfter(TIMEOUT, TimeUnit.SECONDS));


        final List<LongRunningChecks.STATUS> statuses =  Stream
                .of(fastService, mediumService, slowService)
                .map(CompletableFuture::join)
                .map(o -> (LongRunningChecks.STATUS)o)
                .collect(Collectors.toList());

        // statuses.forEach(Log::log);

        return statuses.contains(LongRunningChecks.STATUS.FAILED) ? ScanResult.failed() : ScanResult.ok();
    }

    public CompletableFuture<LongRunningChecks.STATUS> timeoutAfter(long timeout, TimeUnit unit) {
        CompletableFuture<LongRunningChecks.STATUS> result = new CompletableFuture<>();
        delayer.schedule(() -> result.complete(LongRunningChecks.STATUS.TIMEOUT), timeout, unit);
        return result;
    }

    @Override
    public String getName() {
        return "LongRunningRule";
    }
}
