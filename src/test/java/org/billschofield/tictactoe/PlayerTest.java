package org.billschofield.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {

    private Player X;
    private PrintStream printStream;
    private Board board;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        X = new Player("X", printStream, "Player 1", board);
    }

    @Test
    public void shouldTellTheBoardToDrawMarkWhenPlayerAsks() throws IOException {
        X.makeMove(1);
        verify(board).drawPlayerMark(1, "X");
    }

}
