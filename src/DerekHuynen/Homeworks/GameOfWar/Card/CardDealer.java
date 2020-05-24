/**
 * CardDealer class.
 * Homework Assignment: GameOfWar
 *
 * @author Julien Delane
 * @author Derek Huynen
 * @version 1.00 28/01/2020
 */

package DerekHuynen.Homeworks.GameOfWar.Card;


import DerekHuynen.Homeworks.GameOfWar.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Singleton Class that deal the cards to the players.
 */
public class CardDealer {

    /**
     * Total number of cards in a deck.
     */
    private static final int NUMBER_OF_CARDS = Suits.values().length * Ranks.values().length;

    /**
     * The generated deck.
     */
    private ArrayList<Card> deck = new ArrayList<>();

    /**
     * Instance of this class.
     */
    private static CardDealer instance;

    /**
     * Private constructor that fulfil the deck of card.
     */
    private CardDealer() {
        //For each on every card color and power to create a deck of 52 cards
        Arrays.asList(Suits.values())
                .forEach(cardColor -> Arrays.asList(Ranks.values())
                        .forEach(cardPower -> deck.add(new Card(cardColor, cardPower))));
        Collections.shuffle(deck);
    }

    /**
     * Get the instance of this singleton.
     *
     * @return CardDealer instance
     */
    public static CardDealer getInstance() {
        if (instance == null) {
            instance = new CardDealer();
        }
        return instance;
    }

    /**
     * Deal the cards to all players.
     *
     * @param players, players to deal cards to.
     */
    public void dealCards(ArrayList<Player> players) {
        int numberOfPLayer = players.size();
        Random randomNumberGenerator = new Random();
        deck.forEach(card -> {
            int randomNumber;
            do {
                randomNumber = (randomNumberGenerator.nextInt() & Integer.MAX_VALUE) % numberOfPLayer;
            } while (players.get(randomNumber).getNumberOfCards() == CardDealer.NUMBER_OF_CARDS / numberOfPLayer);

            players.get(randomNumber).addCard(card);
        });
    }

}
