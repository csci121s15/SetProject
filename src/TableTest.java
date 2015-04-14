import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TableTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testTable() {
    Table t = new Table();
    Card c1 = new Card(1,1,1,1);
    Card c2 = new Card(2,2,2,2);
    Card c3 = new Card(3,3,3,3);
    t.add(c1);
    t.add(c2);
    t.add(c3);
   
    assertEquals(t.getCard(0), c3);
    assertEquals(t.getCard(1), c2);
    assertEquals(t.getCard(2), c1);
    
  }
  
}
