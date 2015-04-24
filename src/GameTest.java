import junit.framework.TestCase;

public class GameTest extends TestCase {

  public void testAutoTable() {
    Game deeznuts = new Game();
    
    assertEquals(12, deeznuts.numCards());
  }
  
}
