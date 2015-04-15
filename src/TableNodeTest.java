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
  public void testTableNodeCards() {    
    Card c1 = new Card(1, 2, 3, 2);
    TableNode n1 = new TableNode(c1);
    assertEquals(null, n1.getNext());
    assertEquals(c1, n1.getCard());
    
    Card c2 = new Card(2, 3, 1, 3);
    TableNode n2 = new TableNode(c2);
    assertEquals(null, n2.getNext());
    assertEquals(c2, n2.getCard());
    
    Card c3 = new Card(1, 3, 2, 3);
    TableNode n3 = new TableNode(c3);
    assertEquals(null, n3.getNext());
    assertEquals(c3, n3.getCard());
    
   
  }
  
}
