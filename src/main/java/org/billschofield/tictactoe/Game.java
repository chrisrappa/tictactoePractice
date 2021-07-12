package org.billschofield.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

public class Game {
    private final Board board;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Player player1;
    private final Player player2;
    private Player currentPlayerObject;

    private String currentPlayer = "Player 1";
    private int playerMove = 0;
    private int numTries = 0; // ends turn if this number grows to 1, resets on every turn.
    private int totalInvalidEntries = 0; // This will end the game only if both players forfeit their turns one after the other.
    private boolean playerForfeit = false; // When switched to true, the board won't print for next player's turn
    private final List<Integer> availableMoves;


    public Game(Board board, PrintStream printStream, BufferedReader bufferedReader, Player player1, Player player2, List<Integer> availableMoves) {
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayerObject = player1;
        this.availableMoves = availableMoves;
    }

    public void start() {
        handlePlayersAndTurns();
        printStream.println("It is a tie! Start another game.");
    }

    public void handlePlayersAndTurns() {
        while(!board.isFull()){
                numTries = 0;
                if(!playerForfeit){
                    board.draw(); // only draws board if last player didn't forfeit turn.
                }
                runPlayerTurn();
                determinePlayerTurn();
        }
    }

    private void determinePlayerTurn() {
//        switch (currentPlayer){
//            case "Player 1":
//                currentPlayer = "Player 2";
//                break;
//            default:
//                currentPlayer = "Player 1";
//        }

        if(currentPlayerObject == player1){
            currentPlayerObject = player2;
        } else {
            currentPlayerObject = player1;
        }

    }

    public void runPlayerTurn(){
        inputPlayerMove();
        successfulMove();
        unsuccessfulMove();
    }

    private void unsuccessfulMove() {
        if(numTries < 1){
            printStream.println("Invalid entry, please try again");
            totalInvalidEntries += 1;
            numTries += 1;
            runPlayerTurn();
        } else {
            printStream.println("Too many tries, you have forfeited your turn.");
            playerForfeit = true; // won't reprint the board if switching to next player due to forfeit turn.
            handlePlayersAndTurns();
        }
    }

    private void successfulMove() {
        if(availableMoves.contains(playerMove)){

            currentPlayerObject.makeMove(playerMove);
            availableMoves.remove((Integer) playerMove);
            totalInvalidEntries = 0; // reset after successful move
            playerForfeit = false; // reset after player forfeit so next round doesn't end the game
            handlePlayersAndTurns();
        }
    }

    private void inputPlayerMove() {
        String locationString = readLine();
        playerMove = parseInt(locationString);
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
