/**
 * Card class.
 * Homework Assignment: GameOfWar
 *
 * @author Julien Delane
 * @author Derek Huynen
 * @version 1.00 28/01/2020
 */

package DerekHuynen.Homeworks.GameOfWar.Card;

/**
 * Class that represent a card of the game.
 */
public class Card {

    /**
     * Suit of the card.
     * @see Suits
     */
    private Suits suit;

    /**
     * Rank of the card.
     * @see Ranks
     */
    private Ranks rank;

    /**
     * Default constructor.
     */
    public Card() {}

    /**
     * Constructor used to set all variable.
     *
     * @param suit, suit of the card
     * @param rank, rank of the card
     */
    public Card(final Suits suit, final Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Basic card suit getter.
     *
     * @return the suit of the card
     * @see Suits
     */
    public Suits getSuit() {
        return suit;
    }

    /**
     * Basic card rank getter.
     *
     * @see Ranks
     * @return the card rank
     */
    public Ranks getRank() {
        return rank;
    }

    /**
     * toString method put an object as a string.
     *
     * @return the object as a string
     */
    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }

    /**
     * Compare two cards.
     *
     * @param card, card to compare to
     * @return 0 if equal, > 0 if our card is stronger, < 0 if the other card is stronger
     */
    public int compare(final Card card) {
        return this.rank.getValue() - card.rank.getValue();
    }

    /**
     * Compare this object to another.
     *
     * @param o, object to compare to
     * @return true if they are identical otherwise false
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                rank == card.rank;
    }

}
