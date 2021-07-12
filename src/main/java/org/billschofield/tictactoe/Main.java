package org.billschofield.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        Board board = new Board(printStream, new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9")));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Player x = new Player("X", printStream, "Player 1");
        Player o = new Player("O", printStream, "Player 2");
        ArrayList<Integer> availableMoves = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Game game = new Game(board, printStream, bufferedReader, x, o, availableMoves);
        game.start();
    }

//    Make sure to update FAQ in Drive

//    Notes after Bill Meeting
//    You want to use objects for things instead of being primitive obsessed
//    Be more clear about what each entity's job is and keep encapsulation prinicples in mind
//    Make code flexible by doing dependency injection like above where we pass in arguments
//    to player .
//    When intellij highlights things it's an oppurtunity for simplification


}
