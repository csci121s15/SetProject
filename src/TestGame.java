import junit.framework.TestCase;

public class TestGame extends TestCase {

  public void testAutoTable() {
    Game g = new Game();
    
    assertEquals(12, g.numCards());
  }
  
  public void testFileTableUnderTwelve() {
    Game g = new Game("newDeck.dat");

    assertEquals(5, g.numCards());
    assertEquals(1, g.numSets());
    
    g.playRound();
    
    assertEquals(2, g.numCards());
    assertEquals(0, g.numSets());
    assertTrue(g.isGameOver());
  }
  
  public void testFileTableTwelve() {
    Game g = new Game("deck1.dat");
    
    assertEquals(12, g.numCards());
    assertEquals(4, g.numSets());
    
    g.playRound();
    
    assertEquals(9, g.numCards());
    assertEquals(3, g.numSets());
    assertTrue(g.isGameOver());
  }
  
  public void testFileTableOverTwelve() {
    Game g = new Game("datDeck.dat");
    
    assertEquals(12, g.numCards());
    assertEquals(4, g.numSets());
    
    g.playRound();
    
    assertEquals(10, g.numCards());
    assertEquals(3, g.numSets());
    assertFalse(g.isGameOver());
  }
}
