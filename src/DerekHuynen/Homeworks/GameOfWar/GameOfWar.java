/**
 * GameOfWar class.
 * Homework Assignment: GameOfWar
 *
 * @author Julien Delane
 * @author derek Huynen
 * @version 1.00 29/01/2020
 */

package DerekHuynen.Homeworks.GameOfWar;



import DerekHuynen.Homeworks.GameOfWar.Card.CardDealer;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class that handle the game management.
 */
public class GameOfWar {

    /**
     * Number of card draw face down when a war happen.
     */
    private static final int NUMBER_OF_CARD_DRAW_WHEN_WAR = 3;

    /**
     * Number of player.
     */
    private static final int NUMBER_OF_PLAYER = 2;

    /**
     * Number of round after the party will automatically end.
     */
    private final int maxRound;

    /**
     * Array that contains all player.
     */
    private ArrayList<Player> pLayers = new ArrayList<>();

    /**
     * Default constructor.
     */
    public GameOfWar() {
        this.maxRound = 100;
    }

    /**
     * Constructor with max round.
     *
     * @param maxRound, number of round after the party will automatically end
     */
    public GameOfWar(int maxRound) {
        this.maxRound = maxRound;
    }

    /**
     * Initialize everything so the game can work properly.
     */
    public void setupGameOfWar() {
        for (int i = 0; i != NUMBER_OF_PLAYER; i++) {
            pLayers.add(new Player(i + 1));
        }

        CardDealer cardDealer = CardDealer.getInstance();
        cardDealer.dealCards(pLayers);
    }

    /**
     * Start the game.
     */
    public void startGameOfWar() {
        Player winner;
        int numberOfRound = 0;

        //loop that handle the game
        while (!isGameFinished() && numberOfRound < maxRound) {
            pLayers.forEach(player -> player.playACard(true));

            winner = determineRoundWinner();
            //handle the war cases
            while (winner == null) {
                System.out.println("war");
                if (!war()) {
                    printEndOfGame(getTheWinner());
                    return ;
                }
                winner = determineRoundWinner();
            }
            System.out.println("pLayer " + winner.getPlayerId() + " wins the round");
            for (Player player : pLayers) {
                winner.addCard(player.getAllPlayingCard());
            }

            numberOfRound++;
        }
        printEndOfGame(getTheWinner());
    }

    /**
     * Draw cards for the war.
     *
     * @return false is someone loose, otherwise true
     */
    private boolean war() {
        for (int i = 0; i != NUMBER_OF_CARD_DRAW_WHEN_WAR; i++) {
            pLayers.forEach( player -> player.playACard(false));
        }
        pLayers.forEach( player -> player.playACard(true));

        for (Player pLayer: pLayers) {
            if ((pLayer.getPlayingCardNumber() - 1) % (NUMBER_OF_CARD_DRAW_WHEN_WAR + 1) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that determine the winner of the round.
     *
     * @return the winner of the round if null it's a tie
     */
    private Player determineRoundWinner() {
        Player winner = pLayers.get(0);
        boolean isTie = true;

        for (int i = 1; i != NUMBER_OF_PLAYER; i++) {
            if (winner.compare(pLayers.get(i)) < 0) {
                winner = pLayers.get(i);
                isTie = false;
            } else if (winner.compare(pLayers.get(i)) != 0) {
                isTie = false;
            }
        }

        if (isTie) {
            return null;
        } else {
            return winner;
        }
    }

    /**
     * Get the winner of the game.
     *
     * @return the winner of the game
     */
    private Player getTheWinner() {
        for (Player player : pLayers) {
            if (player.getNumberOfCards() > 0) {
                return player;
            }
        }
        return null;
    }

    /**
     * Print end of the game messages.
     *
     * @param winner of the game
     */
    private void printEndOfGame(Player winner) {
        if (winner == null) {
            System.out.println("game over\nIt's a tie");
        } else {
            System.out.println("game over\nplayer " + winner.getPlayerId() + " wins the game");
        }
    }

    /**
     * isGameFinished.
     *
     * @return true if the game is finished, false otherwise
     */
    private boolean isGameFinished() {
        int countPlayerWithCard = 0;

        for (Player player : pLayers) {
            if (player.getNumberOfCards() != 0) {
                countPlayerWithCard++;
            }
        }
        return countPlayerWithCard < 2;
    }

    /**
     * Compare this object to another.
     *
     * @param o, object to compare to
     * @return true if they are identical otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameOfWar gameOfWar = (GameOfWar) o;
        return maxRound == gameOfWar.maxRound &&
                Objects.equals(pLayers, gameOfWar.pLayers);
    }

    /**
     * toString method put an object as a string.
     *
     * @return the object as a string
     */
    @Override
    public String toString() {
        return "GameOfWar{" +
                "maxRound=" + maxRound +
                ", pLayers=" + pLayers +
                '}';
    }
}
