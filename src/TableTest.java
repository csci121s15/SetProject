import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TableTest extends TestCase {
  
  public void testNewTable() {
    Table rhino = new Table();
    
    assertEquals(null, rhino.getCard(0));
    assertEquals(0, rhino.numCards());
    assertEquals(0, rhino.numSet());
      
  }
  
}
