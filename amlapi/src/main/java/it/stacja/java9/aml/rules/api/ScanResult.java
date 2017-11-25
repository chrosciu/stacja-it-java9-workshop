package it.stacja.java9.aml.rules.api;

public class ScanResult {
    enum Status {
        OK, FAILED
    }

    private final Status status;

    private ScanResult(Status status) {
        this.status = status;
    }

    public static ScanResult ok() {
        return new ScanResult(Status.OK);
    }

    public static ScanResult failed() {
        return new ScanResult(Status.FAILED);
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status.toString();
    }
}
