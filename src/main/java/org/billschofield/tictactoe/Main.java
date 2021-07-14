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

//        We want to build everything else in the program utilizing abstractions without
//        utilizing anything that is static so that from the main class we can pass down
//        static information through the app tree from here.
//        This enables us to change the client side of the app without breaking any of the
//        Moving parts. What are things that we want to pass down here that we don't want
//        the rest of the app making the decision on?

//        Number of locations on the board or size of the board as well as language of it
//        Number of players in the game
//        Mark symbol for each player in the game

//        What does game need to know about?
//        How many players there are and who's turn it is
//
//        What does board need to know?
//        How many locations and where to print whatever mark

//        What does Player need to know?
//        What symbol mark the board with, how to mark it, and where it can mark the board

    }
}
