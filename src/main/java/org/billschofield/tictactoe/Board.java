package org.billschofield.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public static List<String> boardLocations = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    public static String boardString = (
            boardLocations.get(0) + " | " + boardLocations.get(1) + " | " +boardLocations.get(2) + "\n" +
            "---------\n" +
            boardLocations.get(3) + " | " + boardLocations.get(4) + " | " +boardLocations.get(5) + "\n" +
            "---------\n" +
            boardLocations.get(6) + " | " + boardLocations.get(7) + " | " +boardLocations.get(8) + "\n" +
            "---------\n");
// The only job the board has is to print the board

    public void draw() {
        printStream.println(boardString);
    }

}
