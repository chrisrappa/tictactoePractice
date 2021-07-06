package org.billschofield.tictactoe;

public class Player {

    public String playerOne;
    public String playerTwo;
    public String currentPlayer;


    public Player() {
        playerOne = "Player 1";
        playerTwo = "Player 2";
        currentPlayer = playerOne;
    }

    public int nextMove() {

        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }

        return 0;
    }
}
