package org.billschofield.tictactoe;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WinConditionTest extends TestCase {

  private Game game;
  private Player playerOne;
  private Player playerTwo;
  private WinCondition winCondition;


  @Before
  public void setUp(){
    Game game = mock(Game.class);
    playerOne = mock(Player.class);
    playerTwo = mock(Player.class);
    winCondition = new WinCondition(game);
  }

  @Test
  public void whenLocationOneTwoAndThreeMarkedByCurrentPlayerTheyWin(){
    when(game.determinePlayerTurn()).thenReturn(playerOne);
    when(playerOne.symbol).thenReturn("X");

    Boolean expected = true;

    assertEquals(expected, winCondition.HorizontalWin());


  }

  @Test
  public void whenLocationFourFiveAndSixMarkedByCurrentPlayerTheyWin(){



  }

  @Test
  public void whenLocationOneFourAndSevenMarkedByCurrentPlayerTheyWin(){



  }

  @Test
  public void whenLocationThreeSixAndNineMarkedByCurrentPlayerTheyWin(){



  }

  @Test
  public void whenLocationOneFiveAndNineMarkedByCurrentPlayerTheyWin(){



  }

  @Test
  public void whenLocationThreeFiveAndSevenMarkedByCurrentPlayerTheyWin(){



  }

}