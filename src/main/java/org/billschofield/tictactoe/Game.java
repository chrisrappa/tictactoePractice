package org.billschofield.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.*;

public class Game {
    private Board board;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Player player;

    public Game(Board board, PrintStream printStream, BufferedReader bufferedReader, Player player) {
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.player = player;
    }

    public String currentPlayer = "";
    int playerMove = 0;
    int numTries = 0; // ends turn if this number grows to 1, resets on every turn.
    int totalInvalidEntries = 0; // This will end the game only if both players forfeit their turns one after the other.
    boolean playerForfeit = false; // When switched to true, the board won't print for next player's turn

    List<Integer> locationNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    ArrayList<Integer> availableMoves = new ArrayList<>(locationNumbers);

    public void start() {
        handlePlayersAndTurns();
        printStream.println("It is a tie! Start another game.");
    }

    public void handlePlayersAndTurns() {
        if(totalInvalidEntries < 2 && availableMoves.size() > 0){
                determinePlayerTurn();
                printStream.println(currentPlayer + ", enter a number indicating where you want to mark the board");
                numTries = 0;
                if(playerForfeit == false){
                    board.draw(); // only draws board if last player didn't forfeit turn.
                }
                runPlayerTurn();
        }

        return;
    }

    public String determinePlayerTurn() {
        switch (currentPlayer){
            case "Player 1":
                currentPlayer = "Player 2";
                break;
            default:
                currentPlayer = "Player 1";
        }

        return currentPlayer;
    }

    public void runPlayerTurn(){
        inputPlayerMove();
        successfulMove();
        unsuccessfulMove();
        return;
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
            Player.mark(playerMove, currentPlayer);
            availableMoves.remove(availableMoves.indexOf(playerMove));
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
