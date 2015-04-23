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
  public void testGameMethods() {
    Game g = new Game("4cards.dat");
    assertEquals(4, g.numCards());
    assertEquals(0, g.numSets());
    
    Game g2 = new Game("16cards.dat");
    assertEquals(12, g2.numCards());
    assertEquals(4, g2.numSets());
    
    Game g3 = new Game("0cards.dat");
    assertEquals(0, g3.numCards());
    assertEquals(0, g3.numSets());
    
    Game g4 = new Game();
    assertEquals(12, g4.numCards());
    
    Game g5 = new Game("12cards0setsMileStone.dat");
    assertEquals(12, g5.numCards());
    assertEquals(0, g5.numSets());
  }
  
  public void testOneRound() {
    Game g = new Game("4cards.dat");
    g.playRound();
    assertTrue(g.isGameOver());
    
    Game g2 = new Game("0cards.dat");
    g2.playRound();
    assertTrue(g2.isGameOver());
    
    Game g3 = new Game("16cards.dat");
    g3.playRound();
    assertFalse(g3.isGameOver());
    
    Game g4 = new Game();
    g4.playRound();
    assertFalse(g4.isGameOver());
    
    // This test only passes with a modified file that adds 3 extra cards
    Game g5 = new Game("12cards0setsMileStone.dat"); 
    g5.playRound();
    assertEquals(15, g5.numCards());
    
  }
  
  public void testAllRounds() {
    Game g = new Game("4cards.dat");
    g.playRound();
    assertTrue(g.isGameOver());
    while(!(g.isGameOver())) {
      g.playRound();
    }
    assertTrue(g.isGameOver());
    
    Game g2 = new Game("0cards.dat");
    g2.playRound();
    assertTrue(g2.isGameOver());
    while(!(g2.isGameOver())) {
      g2.playRound();
    }
    assertTrue(g2.isGameOver());
    
    Game g3 = new Game("16cards.dat");
    g3.playRound();
    assertFalse(g3.isGameOver());
    while(!(g3.isGameOver())) {
      g3.playRound();
    }
    assertTrue(g3.isGameOver());
    
    
    Game g4 = new Game();
    while(!(g4.isGameOver())) {
      g4.playRound();
    }
    assertTrue(g4.isGameOver());
    
    Game g5 = new Game("12cards0setsMilestone.dat");
    while(!(g5.isGameOver())) {
      g5.playRound();
    }
    assertTrue(g4.isGameOver());
    
    Game g6 = new Game("12cards14setsMilestone.dat");
    while(!(g6.isGameOver())) {
      g6.playRound();
    }
    assertTrue(g6.isGameOver());    
    
  }
}
