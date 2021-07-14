package org.billschofield.tictactoe;

import java.io.PrintStream;

public class Player {

    String symbol;
    PrintStream printStream;
    String name;
    Board board;


    public Player(String symbol, PrintStream printStream, String name, Board board){
        this.symbol = symbol;
        this.printStream = printStream;
        this.name = name;
        this.board = board;
    }

    public void makeMove(int location) {
        board.drawPlayerMark(location, symbol);
    }

}
