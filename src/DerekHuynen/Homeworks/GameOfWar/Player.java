/**
 * Player class.
 * Homework Assignment: GameOfWar
 *
 * @author Julien Delane
 * @author Derek Huynen
 * @version 1.00 29/01/2020
 */

package DerekHuynen.Homeworks.GameOfWar;



import DerekHuynen.Homeworks.GameOfWar.Card.Card;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class that represent a player.
 */
public class Player {

    /**
     * Id of the player to print in the terminal.
     */
    private int playerId;

    /**
     * Player's cards.
     */
    private ArrayList<Card> playerCards = new ArrayList<>();

    /**
     * Card that are actually in a war or round.
     */
    private ArrayList<Card> cardPlaying = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Player() {
    }

    /**
     * Constructor with playerId.
     *
     * @param playerId, id of the player
     */
    public Player(final int playerId) {
        this.playerId = playerId;
    }

    /**
     * Add a card to the player's deck.
     *
     * @param card to add
     */
    public void addCard(Card card) {
        playerCards.add(card);
    }

    /**
     * Add a list of card to the player's deck.
     *
     * @param cards list to add
     */
    public void addCard(ArrayList<Card> cards) {
        playerCards.addAll(cards);
    }

    /**
     * Get the number of cards of this player.
     *
     * @return number of cards
     */
    public int getNumberOfCards() {
        return playerCards.size();
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
        Player player = (Player) o;
        return Objects.equals(playerCards, player.playerCards);
    }

    /**
     * toString method put an object as a string.
     *
     * @return the object as a string
     */
    @Override
    public String toString() {
        return "Player{" +
                "playerCards=" + playerCards +
                '}';
    }

    /**
     * Remove the first card in the player's deck of the player and put it inside the currently playing deck.
     *
     * @param showTheCard, if true print the card suit and rank otherwise doesn't show the suit and rank
     */
    public void playACard(boolean showTheCard) {
        Card card = playerCards.remove(0);
        if (showTheCard) {
            System.out.println("player " + playerId + " plays Card is " + card.toString());
        } else {
            System.out.println("player " + playerId + " plays Card is XX");
        }
        cardPlaying.add(0, card);
    }

    /**
     * Compare two player's card.
     *
     * @param player, player to compare to
     * @return 0 if equal, > 0 if our card is stronger, < 0 if the other card is stronger
     */
    public int compare(Player player) {
        return this.cardPlaying.get(0).compare(player.getCurrentPlayingCard());
    }

    /**
     * Get the card that is face up.
     *
     * @return the face up card
     */
    public Card getCurrentPlayingCard() {
        return cardPlaying.get(0);
    }

    /**
     * Get all the played card.
     *
     * @return all the played card during this round
     */
    public ArrayList<Card> getAllPlayingCard() {
        ArrayList<Card> cards = new ArrayList<>(cardPlaying);
        cardPlaying.clear();
        return cards;
    }

    /**
     * Get the number of card that has been play so far during this round.
     *
     * @return size
     */
    public int getPlayingCardNumber() {
        return cardPlaying.size();
    }

    /**
     * GetPlayerId.
     *
     * @return playerId
     */
    public int getPlayerId() {
        return playerId;
    }
}
