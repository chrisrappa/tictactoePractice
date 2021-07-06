package org.billschofield.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.*;

public class Game {
    private Board board;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Player player;

    int currentPlayerMoves = 0;

    public Game(Board board, PrintStream printStream, BufferedReader bufferedReader, Player player) {
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.player = player;
    }

    public void start() {

        board.draw();
        board.draw();
        runPlayerTurn();

    }

    public void runPlayerTurn() {

        checkWhichPlayersTurn();
        int playerMove = determinePlayerMove();
        if(board.boardString.contains(String.valueOf(playerMove))){
            int locationToChange = playerMove;
            board.mark(locationToChange, player.currentPlayer);
            player.nextMove();
            start();
        } else {
            currentPlayerMoves += 1;
            if(currentPlayerMoves < 4){
                printStream.println("Invalid Entry, please try again");
                board.draw();
                runPlayerTurn();
            } else {
                printStream.println("You have forfeited your turn");
                player.nextMove();
                currentPlayerMoves = 0;
                start();
            }

        }

    }

    private void checkWhichPlayersTurn() {
        if(player.currentPlayer == "Player 1"){
            printStream.println("Player 1, enter a number indicating where you want to mark the board");
        } else {
            printStream.println("Player 2, enter a number indicating where you want to mark the board");
        }
    }


    private int determinePlayerMove() {

        String locationString = readLine();
        int playerMove = Math.abs(parseInt(locationString));

        return playerMove;
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
