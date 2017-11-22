package it.stacja.java9.aml.rules.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public interface Rule {

    ScanResult scan(Transaction transaction);

    String getName();

    default String getRunId() {
        try {
            SecureRandom secureRandom = new SecureRandom();

            String randomNum = Integer.toString(secureRandom.nextInt());

            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes =  sha.digest(randomNum.getBytes());

            StringBuilder result = new StringBuilder();
            char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};
            for (byte b : hashedBytes) {
                result.append(digits[(b & 0xf0) >> 4]);
                result.append(digits[b & 0x0f]);
            }

            return result.toString();
        }
        catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
}
