package org.billschofield.tictactoe;

import java.io.PrintStream;

public class Board {
    private PrintStream printStream;


    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public String boardString = (
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");


    public void draw() {
        printStream.println(boardString);
    }

    public void mark(int location, String currentPlayer) {

        if(currentPlayer == "Player 1"){
            boardString = boardString.replace(String.valueOf(location), "X");
        } else {
            boardString = boardString.replace(String.valueOf(location), "O");
        }

    }
}
