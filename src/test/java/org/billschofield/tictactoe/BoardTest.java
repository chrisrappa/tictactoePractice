package org.billschofield.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private ArrayList<String> boardLocations;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        boardLocations = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        board = new Board(printStream, boardLocations);
    }

    @Test
    public void shouldDrawThreeByThreeMatrixWhenBoardDraw() {

        board.draw();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

    @Test
    public void shouldDrawPlayerSymbolWhenPlayerMakesMove(){

        board.drawPlayerMark(3, "X");
        String expected = "X";
        assertEquals (expected, boardLocations.get(2));
    }

}