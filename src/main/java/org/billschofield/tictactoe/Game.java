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

    List<String> locationList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");


    public Game(Board board, PrintStream printStream, BufferedReader bufferedReader, Player player) {
        this.board = board;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.player = player;
    }

    public void start() {


        board.draw();
        int playerMove = determinePlayerMove();
        // String locationToChange = locationList.get(playerMove - 1);
        runNewRound();

    }

    public void runNewRound() {
        int playerMove = determinePlayerMove();

//        For some reason the implemention of lists alone is causing the tests
//        to fail

        String locationToChange = locationList.get(playerMove - 1);
//        board.draw();

        if(locationToChange != "X" && locationToChange != "O"){
//            // locationList.set(playerMove - 1, "X");

            board.mark(playerMove, player.currentPlayer);
            board.mark(player.nextMove(), player.currentPlayer);
            board.draw();
//            runNewRound();
        } else {
            System.out.println("You have entered a duplicate, try again");
            board.draw();
//            runNewRound();
        }
    }



    private int determinePlayerMove() {
        printStream.println(player.currentPlayer + ", enter a number indicating where you want to mark the board");
        String locationString = readLine();
        int playerMove = parseInt(locationString);
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
