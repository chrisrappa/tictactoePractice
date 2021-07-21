package org.billschofield.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.*;

public class Game {
    private final Board board;
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    public final Player playerOne;
    public final Player playerTwo;
    private Player currentPlayer;


    public Game(Board board,
                PrintStream printStream,
                BufferedReader bufferedReader,
                Player playerOne,
                Player playerTwo) {

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
            boolean validMove = handleInvalidMove(playerMove);
            if(validMove){
                currentPlayer.makeMove(playerMove);
                determinePlayerTurn();
            } else {
                printStream.println("Please make a valid move");
            }
        }
        board.draw();
    }

    private boolean handleInvalidMove(int move) {
        boolean checkValidMove = board.isValidMove(move);
        if(!checkValidMove){
            return false;
        }
        return true;
    }

    private int determinePlayerMove() {
        printStream.println(currentPlayer.name + ", enter a number indicating where you want to mark the board");
        String locationString = readLine();
        return parseInt(locationString);
    }

    public Player determinePlayerTurn(){
        if(currentPlayer == playerOne){
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }

        return currentPlayer;
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
