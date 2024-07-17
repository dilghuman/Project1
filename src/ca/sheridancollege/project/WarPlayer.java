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
public class WarPlayer extends Player {

    private GroupOfCards hand;
    private int score;

    public WarPlayer(String name) {
        super(name);
        this.hand = new GroupOfCards(0);
        this.score = 0;
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }

    @Override
    public void play() {
        ArrayList<Card> handCards = hand.getCards();
        if (!handCards.isEmpty()) {
            Card playedCard = handCards.remove(0);
            System.out.println(getName() + " played " + playedCard);
        } else {
            System.out.println(getName() + " has no more cards to play.");
        }
    }
}
