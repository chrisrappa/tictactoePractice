package org.billschofield.tictactoe;

import java.io.PrintStream;

import static org.billschofield.tictactoe.Board.boardString;

public class Player {

  private String symbol;
  private PrintStream printStream;
  private String name;

  public Player(String symbol, PrintStream printStream, String name) {
    this.symbol = symbol;
    this.printStream = printStream;
    this.name = name;
  }

  public void makeMove(int location) {
    printStream.println(name + ", enter a number indicating where you want to mark the board");
    board.mark(location, symbol);
  }
}
