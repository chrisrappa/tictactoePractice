package org.billschofield.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.lang.Integer.*;

public class Game {
    private Board board;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Player player;

    int currentPlayerMoves;

    List<String> locationList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
    ArrayList<Integer> numbersEntered = new ArrayList<>();

    public Game(Board board, PrintStream printStream, BufferedReader bufferedReader, Player player) {
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.player = player;
    }

    public void start() {

        currentPlayerMoves = 0;
        board.draw();
        runNewRound();

    }

    public void runNewRound() {

        currentPlayerMoves += 1; //Keep track of how many times this player has input move
        int playerMove = determinePlayerMove();
        System.out.println(playerMove);
        if(numbersEntered.contains(playerMove)){
            System.out.println("You have entered a duplicate, try again");
            if(currentPlayerMoves < 3){
                runNewRound();
            } else {
                start();
            }
        }

        numbersEntered.add(playerMove); // Add player move to an array

        locationList.set(playerMove - 1, "X");
        board.mark(playerMove, player.currentPlayer);
        board.mark(player.nextMove(), player.currentPlayer);
        board.draw();
        runNewRound();
    }



    private int determinePlayerMove() {
        if(player.currentPlayer == "Player 1"){
            printStream.println("Player 1, enter a number indicating where you want to mark the board");
        } else {
            printStream.println("Player 2, enter a number indicating where you want to mark the board");
        }

        String locationString = readLine();
        int playerMove = Math.abs(parseInt(locationString));

        return playerMove;
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
