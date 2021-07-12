package org.billschofield.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private PrintStream printStream;
    private List<String> boardLocations;


    public Board(PrintStream printStream, ArrayList<String> boardLocations) {
        this.printStream = printStream;
        this.boardLocations = boardLocations;
    }

// The only job the board has is to print the board

    public void draw() {
        printStream.println(
                boardLocations.get(0) + " | " + boardLocations.get(1) + " | " +boardLocations.get(2) + "\n" +
                "---------\n" +
                boardLocations.get(3) + " | " + boardLocations.get(4) + " | " +boardLocations.get(5) + "\n" +
                "---------\n" +
                boardLocations.get(6) + " | " + boardLocations.get(7) + " | " +boardLocations.get(8) + "\n" +
                "---------\n");
    }

    public boolean isFull() {
    }
}
