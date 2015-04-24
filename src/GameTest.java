import junit.framework.TestCase;

public class GameTest extends TestCase {

  public void testAutoTable() {
    Game samsung = new Game();
    
    assertEquals(12, samsung.numCards());
  }
  
}
