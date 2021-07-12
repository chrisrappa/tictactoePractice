package org.billschofield.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class GameTest {

    private Board board;
    private Game game;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Player player1;
    private Player player2;

    private ArrayList<Integer> availableMoves;

    @Before
    public void setUp() {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        availableMoves = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        game = new Game(board, printStream, bufferedReader, player1, player2, availableMoves);
    }

    @Test
    public void shouldDrawTheBoardWhenTheGameStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        game.start();

        verify(board, times(2)).draw();
    }


    @Test
    public void shouldMarkTheBoardWherePlayerOneMoves() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        game.start();

        verify(player1, times(1)).makeMove(1);
    }


    @Test
    public void shouldChangeWhichPlayersTurnItIsEveryTimeAMoveIsMade() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        game.start();

        verify(player2).makeMove(1);
    }

    @Test
    public void removesPlayerMoveFromArrayOfAvailableMoves() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        game.start();

        int expected = 8;
        assert (availableMoves.size() == expected);
    }


}