import junit.framework.TestCase;
public class GameTest extends TestCase {
  public void testThisGame() {
    Game g = new Game();
    assertEquals(g.numCards(), 12);
  }
}
