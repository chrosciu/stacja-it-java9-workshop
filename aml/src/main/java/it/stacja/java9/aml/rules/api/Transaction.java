package it.stacja.java9.aml.rules.api;

import it.stacja.java9.aml.providers.BlacklistProvider;

import java.math.BigDecimal;

public class Transaction {
    private final String senderFirstName;
    private final String senderLastName;

    private final String recipientFirstName;
    private final String recipientLastName;

    private final BigDecimal amount;

    public Transaction(String senderFirstName, String senderLastName, String recipientFirstName, String recipientLastName, BigDecimal amount) {
        this.senderFirstName = senderFirstName;
        this.senderLastName = senderLastName;
        this.recipientFirstName = recipientFirstName;
        this.recipientLastName = recipientLastName;
        this.amount = amount;
    }

    public boolean matches(BlacklistProvider.BadGuy badGuy) {
        boolean matchesSender =
                this.senderFirstName.equalsIgnoreCase(badGuy.getFirstName()) &&
                        this.senderLastName.equalsIgnoreCase(badGuy.getLastName());

        boolean matchesRecipient =
                this.recipientFirstName.equalsIgnoreCase(badGuy.getFirstName()) &&
                        this.recipientLastName.equalsIgnoreCase(badGuy.getLastName());

        return matchesSender || matchesRecipient;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public String getRecipientFirstName() {
        return recipientFirstName;
    }

    public String getRecipientLastName() {
        return recipientLastName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("senderFirstName='").append(senderFirstName).append('\'');
        sb.append(", senderLastName='").append(senderLastName).append('\'');
        sb.append(", recipientFirstName='").append(recipientFirstName).append('\'');
        sb.append(", recipientLastName='").append(recipientLastName).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
