package org.billschofield.tictactoe;

public class Player {

    String playerOne = "Player 1";
    String playerTwo = "Player 2";
    String currentPlayer = playerOne;

    public int nextMove() {

        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }

        return 0;
    }
}
