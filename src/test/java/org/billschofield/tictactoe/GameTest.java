package org.billschofield.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {

    private Board board;
    private Game game;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        game = new Game(board, printStream, bufferedReader, playerOne, playerTwo);
    }

    @Test
    public void shouldDrawTheBoardTwiceWhenTheGameStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1");
        game.start();

        verify(board, times(2)).draw();
    }

    @Test
    public void shouldPromptPlayerOneToMoveWhenTheGameStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1");
        game.start();

        verify(printStream).println("Player 1, enter a number indicating where you want to mark the board");
    }


}

