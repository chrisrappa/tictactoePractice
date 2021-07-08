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
    private Player player;

    @Before
    public void setUp() {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        player = mock(Player.class);
        game = new Game(board, printStream, bufferedReader, player);
    }

    @Test
    public void shouldDrawTheBoardWhenTheGameStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        game.start();

        verify(board, times(2)).draw();
    }

    @Test
    public void shouldPromptPlayerOneToMoveWhenTheGameStarts() throws IOException {
        when(game.determinePlayerTurn()).thenReturn("Player 1");

        game.determinePlayerTurn();
        game.handlePlayersAndTurns();

        verify(printStream).println("Player 1, enter a number indicating where you want to mark the board");
    }


    @Test
    public void shouldMarkTheBoardWherePlayerOneMoves() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        when(player.mark(1, "Player 1")).thenReturn(1);

        player.mark(1, "Player 1");

        verify(player).mark(1, "Player 1");

    }


    @Test
    public void shouldChangeWhichPlayersTurnItIsEveryTimeAMoveIsMade() throws IOException {


    }
}