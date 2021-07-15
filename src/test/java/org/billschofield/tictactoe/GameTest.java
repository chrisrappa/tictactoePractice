package org.billschofield.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GameTest {

    private Board board;
    private Game game;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    @Before
    public void setUp() {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        currentPlayer = playerOne;
        game = new Game(board, printStream, bufferedReader, playerOne, playerTwo);
    }

    @Test
    public void shouldDrawTheBoardTwiceWhenTheGameStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.calculateAvailableMoves()).thenReturn(1).thenReturn(0);
        when(board.isValidMove(1)).thenReturn(true).thenReturn(false);


        game.start();

        verify(board, times(2)).draw();
    }

    @Test
    public void shouldPromptPlayerOneToMoveWhenTheGameStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.calculateAvailableMoves()).thenReturn(1).thenReturn(0);
        playerOne.name = "Player 1";
        game.start();


        verify(printStream).println("Player 1, enter a number indicating where you want to mark the board");
    }

    @Test
    public void shouldSwitchToPlayer2AfterPlayerOneMovesAndPromptPlayerTwo() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.calculateAvailableMoves()).thenReturn(2).thenReturn(1).thenReturn(0);
        when(board.isValidMove(1)).thenReturn(true);

        playerTwo.name = "Player 2";
        game.start();

        verify(printStream).println("Player 2, enter a number indicating where you want to mark the board");
    }

    @Test
    public void shouldPromptPlayerToTryAgainIfTheyMakeAnInvalidMove() throws IOException {
        when(board.calculateAvailableMoves()).thenReturn(1).thenReturn(0);
        when(bufferedReader.readLine()).thenReturn("-1");

        game.start();

        verify(printStream).println("Please make a valid move");
    }

    @Test
    public void gameShouldOnlyAskBoardToDrawOnceWhenGameIsOver() throws IOException {
        when(board.calculateAvailableMoves()).thenReturn(0);
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.isValidMove(1)).thenReturn(true);

        game.start();

        verify(board, times(1)).draw();
    }
}

