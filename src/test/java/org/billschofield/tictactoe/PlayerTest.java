package org.billschofield.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

public class PlayerTest {

    private BufferedReader bufferedReader;
    private Player player;
    private PrintStream printStream;


    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        player = new Player("Y", printStream, "Fake Player Name");

    }

    @Test
    public void shouldPromptPlayerOneToMoveWhenTheGameStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        player.makeMove(1);

        verify(printStream).println("Fake Player Name, enter a number indicating where you want to mark the board");
    }

//    @Test
//    public void shouldMoveWhereThePlayerChoose() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("1");
//        int move = playerOne.nextMove();
//
//        assertThat(move, is(1));
//    }
//
//    @Test
//    public void shouldMarkTheBoardWhenThePlayerMovesInLocationOneThousand() throws IOException {
//        when(bufferedReader.readLine()).thenReturn("1000");
//
//        int move = player.nextMove();
//
//        assertThat(move, is(1000));
//    }
}