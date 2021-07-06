package org.billschofield.tictactoe;

public class Player {

    public String playerOne = "Player 1";
    public String playerTwo = "Player 2";
    public String currentPlayer = playerOne;


    public int nextMove() {

        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }

        return 0;
    }
}
