package DerekHuynen.Labs.Momento;

/**
 * Time
 * Lab Assignment: Memento
 *
 * @author Derek Huynen
 * @version 1.00
 */
public enum Time {
    EIGHT, EIGHT_THIRTY, NINE, NINE_THIRTY, TEN, TEN_THIRTY, ELEVEN, ELEVEN_THIRTY, NOON, TWELVE_THIRTY,
    ONE, ONE_THIRTY, TWO, TWO_THIRTY, THREE, THREE_THIRTY, FOUR, FOUR_THIRTY, FIVE, FIVE_THIRTY, SIX;

    public String toString () {
        String result = "";
        String[] words = this.name().toLowerCase().replace("_", " ").split(" ");

        for(String word : words ) {
            result += " " + word.substring(0, 1).toUpperCase() + word.substring(1);

        }
        return result.trim();
    }
}