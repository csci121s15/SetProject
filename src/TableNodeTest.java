import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TableNodeTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testTableNode() {
    Card c = new Card(1,1,1,1);
    Card c2 = new Card(2,2,2,2);
    TableNode t = new TableNode(c);
    TableNode t2 = new TableNode(c2);
    Table table = new Table();
    
    
    assertEquals(t.getNext(), null);
    t.setNext(t2);
    assertEquals(t.getNext(), t2);
    assertEquals(t.getCard(), c);
  }
  
}
