package org.billschofield.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static BufferedReader bufferedReader;

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        Board board = new Board(printStream, new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9")));
        Player X = new Player("X", printStream, "Player 1", board);
        Player O = new Player("O", printStream, "Player 2", board);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Game game = new Game(board, printStream, bufferedReader, X, O);
        game.start();

//  Need to create a class called WinCondition that takes in the current board
//  And checks to see if the same symbol is present between 1 & 3, 4 & 6, or 7 & 9
//  A primitive obsessed way to do with would be if(board.get(0) == board.get(1) && board.get(1) == board.get(2)
//  Then current player wins, but that's gross. Find a way to use objects instead.

    }
}
