import junit.framework.TestCase;

public class TestGame extends TestCase {

  public void testAutoTable() {
    Game g = new Game();
    
    assertEquals(12, g.numCards());
  }
  
  public void testFileTableUnderTwelveOneSet() {
    Game g = new Game("newDeck.dat");

    assertEquals(5, g.numCards());
    assertEquals(1, g.numSets());
    
    g.playRound();
    
    assertEquals(2, g.numCards());
    assertEquals(0, g.numSets());
    assertTrue(g.isGameOver());
  }
  
  public void testFileTableTwelveOneSet() {
    Game g = new Game("deck1.dat");
    
    assertEquals(12, g.numCards());
    assertEquals(1, g.numSets());
    
    g.playRound();
    
    assertEquals(9, g.numCards());
    assertEquals(0, g.numSets());
    assertTrue(g.isGameOver());
  }
  
  public void testFileTableOverTwelveOneSet() {
    Game g = new Game("datDeck.dat");
    
    assertEquals(12, g.numCards());
    assertEquals(1, g.numSets());
    
    g.playRound();
    
    assertEquals(10, g.numCards());
    assertEquals(0, g.numSets());
    assertTrue(g.isGameOver());
  }
  
  public void testFileTableTwelveTwoSet() {
    Game g = new Game("dick.dat");
    
    assertEquals(12, g.numCards());
    assertEquals(2, g.numSets());
    
    g.playRound();
    
    assertEquals(9, g.numCards());
    assertEquals(1, g.numSets());
    assertFalse(g.isGameOver());
  }
  
  public void testFileTableOverTwelveTwoSet() {
    Game g = new Game("dick2.dat");
    
    assertEquals(12, g.numCards());
    assertEquals(2, g.numSets());
    
    g.playRound();
    
    assertEquals(10, g.numCards());
    assertEquals(1, g.numSets());
    assertFalse(g.isGameOver());
  }
  
  public void testFileTwoOverlappingSets() {
    Game g = new Game("overlap.dat");
    
    assertEquals(5, g.numCards());
    assertEquals(2, g.numSets());
    
    g.playRound();
    
    assertEquals(2, g.numCards());
    assertEquals(0, g.numSets());
    assertTrue(g.isGameOver());
  }

}
