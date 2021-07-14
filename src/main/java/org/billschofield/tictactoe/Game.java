package org.billschofield.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.*;

public class Game {
    private final Board board;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Player playerOne;
    private final Player playerTwo;
    private Player currentPlayer;


    public Game(Board board, PrintStream printStream, BufferedReader bufferedReader, Player playerOne, Player playerTwo) {
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = playerOne;
    }

    public void start() {
        while(board.calculateAvailableMoves() != 0){
            board.draw();
            int playerMove = determinePlayerMove();
            currentPlayer.makeMove(playerMove);
            determinePlayerTurn();
        }
        board.draw();
    }

    private int determinePlayerMove() {
        printStream.println(currentPlayer.name + ", enter a number indicating where you want to mark the board");


        String locationString = readLine();
        return parseInt(locationString);
    }

    private void determinePlayerTurn(){
        if(currentPlayer == playerOne){
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
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
