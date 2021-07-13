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


    public Game(Board board, PrintStream printStream, BufferedReader bufferedReader, Player playerOne, Player playerTwo) {
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        board.draw();
        int playerMove = determinePlayerMove();
        playerOne.makeMove(playerMove);
        board.drawPlayerMark(playerMove, playerOne.symbol);
        board.draw();
    }

    private int determinePlayerMove() {
        printStream.println("Player 1, enter a number indicating where you want to mark the board");
        String locationString = readLine();
        return parseInt(locationString);
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
