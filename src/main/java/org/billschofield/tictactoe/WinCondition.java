package org.billschofield.tictactoe;

import java.util.List;

public class WinCondition {

  Game game;
  Player currentPlayer;
  Board board;

  int i;
  int k;
  List<String> boardLocations = board.boardLocations;

  public WinCondition(Game game) {
    this.game = game;
  }


  public Boolean HorizontalWin(){
    currentPlayer = game.determinePlayerTurn();
    String playerSymbol = currentPlayer.symbol;

//    This is just a loop through the board to check for dupes
//
    for(int j = i + 1; k < boardLocations.size(); j++){
      if (j != i && boardLocations.get(j) == boardLocations.get(i)) {
        return true;
      }
    }

    return false;
  }

  private Boolean VerticalWin(){

    return false;
  }

  private Boolean DiagonalWin(){

    return false;
  }

}
