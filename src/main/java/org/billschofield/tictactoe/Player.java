package org.billschofield.tictactoe;

import static org.billschofield.tictactoe.Board.boardString;

public class Player {

  public static int mark(int location, String currentPlayer) {
    if(currentPlayer == "Player 1"){
      boardString = boardString.replace(String.valueOf(location), "X");
    } else {
      boardString = boardString.replace(String.valueOf(location), "O");
    }

    return location;
  }


}
