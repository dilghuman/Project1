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
public class Main {
    public static void main(String[] args) {
   
    WarGame warGame = new WarGame("WAR Game");

    WarPlayer player1 = new WarPlayer("Player 1");
    WarPlayer player2 = new WarPlayer("Player 2");

    ArrayList<Player> players = new ArrayList<>();
    players.add(player1);
    players.add(player2);
    warGame.setPlayers(players);
    warGame.play();
    }


}
