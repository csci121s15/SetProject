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
  public void test1RoundGame() {
    Game g = new Game();
    
    assertEquals(g.numCards(), 12);
    g.playRound();
    assertEquals(g.numCards(), 12);
  }
  
  public void testWith81CardsDeck(){
    Game g = new Game("81cards.txt");
    
    assertEquals(g.numCards(), 12);
    g.playRound();
    assertEquals(g.numCards(), 12);
  }
  
  public void testWith3CardsDeck(){
    Game g = new Game("3cards.txt");
    
    assertEquals(g.numCards(), 3);
    g.playRound();
    assertEquals(g.numCards(), 0);
  }

  
}
