/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;

/**
 *
 * @author 991764920
 */

public class WarGame extends Game {

    private GroupOfCards deck;

    public WarGame(String name) {
        super(name);
        this.deck = new GroupOfCards(52);
    }

    @Override
    public void play() {
        // Shuffle the deck
        deck.shuffle();
        ArrayList<Card> cards = deck.getCards();
        
        // Deal cards to players
        ArrayList<Player> players = getPlayers();
        int numPlayers = players.size();
        
        for (int i = 0; i < cards.size(); i++) {
            WarPlayer player = (WarPlayer) players.get(i % numPlayers);
            player.getHand().getCards().add(cards.get(i));
        }

        // Play rounds until one player has all the cards
        boolean gameContinues = true;
        while (gameContinues) {
            ArrayList<Card> playedCards = new ArrayList<>();
            WarPlayer roundWinner = null;
            Card highestCard = null;

            // Each player plays one card
            for (Player player : players) {
                WarPlayer warPlayer = (WarPlayer) player;
                if (!warPlayer.getHand().getCards().isEmpty()) {
                    Card playedCard = warPlayer.getHand().getCards().remove(0);
                    playedCards.add(playedCard);
                    System.out.println(warPlayer.getName() + " played " + playedCard);

                    if (highestCard == null || ((PlayingCard) playedCard).getRank() > ((PlayingCard) highestCard).getRank()) {
                        highestCard = playedCard;
                        roundWinner = warPlayer;
                    }
                }
            }

            if (roundWinner != null) {
                roundWinner.incrementScore();
                roundWinner.getHand().getCards().addAll(playedCards);
                System.out.println(roundWinner.getName() + " wins the round and takes the cards.");
            }

            // Check if the game is over
            for (Player player : players) {
                WarPlayer warPlayer = (WarPlayer) player;
                if (warPlayer.getHand().getCards().size() == deck.getSize()) {
                    gameContinues = false;
                    break;
                }
            }
        }

        // Declare the winner
        declareWinner();
    }

    @Override
    public void declareWinner() {
        ArrayList<Player> players = getPlayers();
        WarPlayer winner = null;
        int maxCards = -1;

        for (Player player : players) {
            WarPlayer warPlayer = (WarPlayer) player;
            if (warPlayer.getHand().getCards().size() > maxCards) {
                maxCards = warPlayer.getHand().getCards().size();
                winner = warPlayer;
            }
        }

        System.out.println("The winner is " + winner.getName() + " with " + winner.getHand().getCards().size() + " cards.");
    }
}
