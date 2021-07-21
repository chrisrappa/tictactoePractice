package org.billschofield.tictactoe;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final PrintStream printStream;
    public final ArrayList<String> boardLocations;

    public Board(PrintStream printStream, ArrayList<String> boardLocations) {
        this.printStream = printStream;
        this.boardLocations = boardLocations;
    }


    public void draw() {
        printStream.println(
                MessageFormat.format("{0}|{1}|{2}\n-----\n{3}|{4}|{5}\n-----\n{6}|{7}|{8}",
                        boardLocations.get(0), boardLocations.get(1), boardLocations.get(2),
                        boardLocations.get(3), boardLocations.get(4), boardLocations.get(5),
                        boardLocations.get(6), boardLocations.get(7), boardLocations.get(8))
        );
    }

    public void drawPlayerMark(int location, String symbol) {
        int moveIndex = findMoveIndex(location);
        boolean validMove = isValidMove(location);
        if(validMove == true){
            boardLocations.set(moveIndex, symbol);
            calculateAvailableMoves();
        }
    }

    public boolean isValidMove(int location){
        int moveIndex = findMoveIndex(location);
        if(moveIndex == -1){
            return false;
        }
        return true;
    }

    private int findMoveIndex(int i){
        String locationToString = String.valueOf(i);
        int findStringIndex = boardLocations.indexOf(locationToString);

        return findStringIndex;
    }

//    Board should be the one to say whether a move is valid or not
//    Then it should return this to the game method, handle invalid move

    public int calculateAvailableMoves(){
        int availableMoves = 0;
        for(int i = 0; i < boardLocations.size(); i++){
            if(!boardLocations.get(i).equals("X") && !boardLocations.get(i).equals("O")){
                availableMoves += 1;
            }
        }
        return availableMoves;
    }
}
