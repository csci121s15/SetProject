import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class GameTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testGame() {
    Game g = new Game();
    assertEquals(g.numCards(), 12);
    assertFalse(g.isGameOver());
  }
  
  public void noSetsFirstTwelve()
  {
    Game g = new Game("15cards0setsin12Milestone.dat");
    assertEquals(0, g.numSets());
    assertEquals(12, g.numCards());
    
    g.playRound();
    
    assertEquals(15, g.numCards());
  }
  
  public void testNoSetsFirstFifteen()
  {
    Game g = new Game("18cards0setsin15Milestone.dat");
    
    assertEquals(0, g.numSets());
    assertEquals(12, g.numCards());
    
    g.playRound();
    
    assertEquals(0, g.numSets());
    assertEquals(15, g.numCards());
    
    g.playRound();
    
    assertEquals(9, g.numSets());
    assertEquals(18, g.numCards());
  }
  
  public void testBackToTwelveAfterFifteen()
  {
    Game g = new Game("15cards0setsin12Milestone.dat");
    g.playRound();
    
    assertEquals(15, g.numCards());
    
    g.playRound();
    assertEquals(12, g.numCards());
  }
  
  public void testBackToFifteenAfterEighteen()
  {
    Game g = new Game("18cards0setsin15Milestone.dat");
    g.playRound();
    g.playRound();
    
    assertEquals(18, g.numCards());
    
    g.playRound();
    assertEquals(15, g.numCards());
  }
  
  public void testDeckNotMultipleOfThree()
  {
    Game g = new Game("14cardsMilestone.dat");
    assertEquals(12, g.numCards());
    // when we play a round, there is a set, but there are 
    // only 2 more cards available.
    g.playRound();
    
    assertEquals(11, g.numCards());
  }
  
  public void testDeckLessThanTwelve()
  {
    Game g = new Game("7cardsMilestone.dat");
    
    assertEquals(7, g.numCards());
    g.playRound();
    
    assertEquals(4, g.numCards());
  }
  
  public void testGameOverEmptyTable()
  {
    Game g = new Game("12cards4setsMilestone.dat");
    
    assertEquals(12, g.numCards());
    assertEquals(4, g.numSets());
    
    g.playRound();
    assertEquals(9, g.numCards());
    assertEquals(3, g.numSets());
    
    g.playRound();
    assertEquals(6, g.numCards());
    assertEquals(2, g.numSets());
    
    g.playRound();
    assertEquals(3, g.numCards());
    assertEquals(1, g.numSets());
    
    g.playRound();
    assertEquals(0, g.numCards());
    assertTrue(g.isGameOver());
  }

  public void test14Sets()
  {
    Game g = new Game("14in12Milestone.dat");
    
    assertEquals(12, g.numCards());
    assertEquals(14, g.numSets());
    assertFalse(g.isGameOver());
    
    g.playRound();
    assertEquals(9, g.numCards());
    assertFalse(g.isGameOver());
    
    g.playRound();
    assertEquals(6, g.numCards());
    assertFalse(g.isGameOver());

    g.playRound();
    assertEquals(3, g.numCards());
    assertTrue(g.isGameOver());
  }
  
  public void testRemoveAdd()
  {
    Game g = new Game("15cardsMilestone.dat");
    
    assertEquals(12, g.numCards());
    assertEquals(3, g.numSets());
    assertFalse(g.isGameOver());
    
    g.playRound();
    
    assertEquals(12, g.numCards());
    assertEquals(3, g.numSets());
    assertFalse(g.isGameOver());
    
    g.playRound();
    assertEquals(9, g.numCards());
    assertEquals(1, g.numSets());
    assertFalse(g.isGameOver());
    
    g.playRound();
    assertEquals(6, g.numCards());
    assertEquals(0, g.numSets());
    assertTrue(g.isGameOver());
  }
}

  

