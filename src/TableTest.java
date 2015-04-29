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
    
    Card c1 = new Card(1,2,3,2);
    t.add(c1);
    
    Card c2 = new Card(2,3,1,3);
    t.add(c2);
    
    Card c3 = new Card(1,3,2,3);
    t.add(c3);
    
    assertEquals(3, t.numCards());
    assertEquals(true, t.getCard(0).equals(c3));
    assertEquals(true, t.getCard(1).equals(c2));
    assertEquals(true, t.getCard(2).equals(c1));
  }
  
}
