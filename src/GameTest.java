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
  public void testInitialGame() 
  {
    Game game = new Game();
    
    assertEquals(12, game.numCards());
  }
  
  public void testEmptyGame()
  {
    Game game = new Game("emptydeck.txt");
    
    assertEquals(0, game.numCards());
    assertEquals(0, game.numSets());
  }
  
  public void testOneCardGame()
  {
    Game game = new Game("onedeck.txt");
    
    assertEquals(1, game.numCards());
    assertEquals(0, game.numSets());
  }
  
  public void testGameWithSetInitial()
  {
    Game game = new Game("DeckTester.txt");
    
    assertEquals(4, game.numCards());
    assertEquals(1, game.numSets());
  }
  
  public void testRoundOneSetEmptyDeck()
  {
    Game game = new Game("DeckTester.txt");
    
    assertEquals(4, game.numCards());
    assertEquals(1, game.numSets());
    
    game.playRound();
    
    assertEquals(1, game.numCards());
    assertEquals(0, game.numSets());
  }
  
  public void testRoundTwoSetsEmptyDeck()
  {
    Game game = new Game("twoSetsSixCards.txt");
    
    assertEquals(6, game.numCards());
    assertEquals(2, game.numSets());
    
    game.playRound();
    
    assertEquals(3, game.numCards());
    assertEquals(1, game.numSets());
    
    game.playRound();
    
    assertEquals(0, game.numCards());
    assertEquals(0, game.numSets());
  }
  
  public void testNoSetsOnTable()
  {
    Game game = new Game("FullTableAndSets.txt");
      
    assertEquals(12, game.numCards());
    
    game.playRound();
    
    assertEquals(12, game.numCards());
    
    game.playRound();
    
    assertEquals(9, game.numCards());
  }
}
