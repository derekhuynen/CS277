package DerekHuynen.Labs.Momento;

/**
 * Days
 * Lab Assignment: Memento
 *
 * @author Derek Huynen
 * @version 1.00
 */
public enum Days {
    MONDAY_WEDNESDAY, TUESDAY_THURSDAY, FRIDAY, SATURDAY;

    public String toString () {
        String result = "";
        String[] words = this.name().toLowerCase().replace("_", " ").split(" ");

        for(String word : words ) {
            result += " " + word.substring(0, 1).toUpperCase() + word.substring(1);

        }
        return result.trim();
    }
}