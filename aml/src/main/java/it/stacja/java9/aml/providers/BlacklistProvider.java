package it.stacja.java9.aml.providers;

import java.util.Arrays;
import java.util.List;

public class BlacklistProvider implements AutoCloseable {

    /**
     * Returns a list of known bad guys sorted descending from the worst one.
     * @return the sorted list of bad guys
     */
    public List<BadGuy> getBadGuys() {
        /*
            Add information about the caller
         */
        
        return Arrays.asList(
                new BadGuy("Lord", "Voldemort", 10),
                new BadGuy("Hannibal", "Lecter", 5),
                new BadGuy("Janusz", "Kowalski", 3)
        );
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing BlacklistProvider");
    }

    public static class BadGuy {
        private final String firstName;
        private final String lastName;
        private final long score;

        BadGuy(String firstName, String lastName, long score) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.score = score;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public long getScore() {
            return score;
        }
    }
}
