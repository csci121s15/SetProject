import junit.framework.TestCase;
public class GameTest extends TestCase {
  public void testConstructorRuns() {
    Game g = new Game();
    assertEquals(12, g.numCards());
  }
  
  public void testOtherConstructor() {
    Game g = new Game("15cards19setsMilestone.dat");
    
    assertEquals(12, g.numCards());
    assertEquals(14, g.numSets());
  }
  
  public void testPlayRound() {
    Game g = new Game("15cards19setsMilestone.dat");
    g.playRound();
    
    assertEquals(12, g.numCards());
  }
  
  public void testIsGameOver() {
    Game g = new Game("empty game.txt");
    
    assertEquals(true, g.isGameOver());
  }
}
  
                                      