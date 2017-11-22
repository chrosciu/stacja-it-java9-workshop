package it.stacja.java9workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello from Java 8");

        List<String> lotOfStrings = new ArrayList<>(100_000_0);

        System.out.println("Starting data generation");

        for(int i  = 0; i < 100_000_0; i++) {
            lotOfStrings.add(new String("test string " + i));
        }

        System.out.println("Finished data generation. Waiting for input.");

        System.in.read();

        System.out.println(lotOfStrings.size());
    }
}
