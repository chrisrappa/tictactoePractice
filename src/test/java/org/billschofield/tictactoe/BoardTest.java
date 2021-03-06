package org.billschofield.tictactoe;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    @Test
    public void shouldDrawThreeByThreeMatrixWhenBoardDraw() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.draw();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

    @Test
    public void WhenPlayerOneEnters2ThenPosition2IsReplacedWithAnX(){
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        Player player = new Player();
        board.mark(5, player.currentPlayer);
        board.draw();

        verify(printStream).println(
            "1|2|3\n" +
            "-----\n" +
            "4|X|6\n" +
            "-----\n" +
            "7|8|9");
    }

    @Test
    public void AfterPlayerOneMakesAnXPromptAsksForPlayerTwoMoveAndMakesAnO(){
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.draw();
        board.mark(5, "One");
        board.draw();
        board.mark(4, "Two");

        verify(printStream).println(
            "1|2|3\n" +
            "-----\n" +
            "O|X|6\n" +
            "-----\n" +
            "7|8|9");
    }

}