package it.stacja.java9.aml.services;

import java.util.concurrent.TimeUnit;

public class LongRunningChecks {
    public enum STATUS {
        OK, FAILED, TIMEOUT
    }

    public static STATUS check5sec() {
        sleepSec(5);

        return STATUS.OK;
    }

    public static STATUS check10sec() {
        sleepSec(10);

        return STATUS.OK;
    }

    public static STATUS check15sec() {
        sleepSec(15);

        return STATUS.OK;
    }

    private static void sleepSec(int numberOfSeconds) {
        try {
            TimeUnit.SECONDS.sleep(numberOfSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
