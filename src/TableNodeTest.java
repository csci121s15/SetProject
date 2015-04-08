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
  public void testTableNode()
  {
    Card card = new Card(1, 1, 1, 1);
    TableNode node = new TableNode(card);
    
    assertEquals(null, node.getNext());
    assertEquals(true, node.getCard().equals(card));
    
    Card card2 = new Card(1, 1, 1, 2);
    TableNode node2 = new TableNode(card2);
    node.setNext(node2);
    
    assertEquals(true, node.getCard().equals(card));
    assertEquals(true, node.getNext().getCard().equals(card2));
    assertEquals(null, node.getNext().getNext());
    
    Card card3 = new Card(1, 1, 1, 3);
    node2 = new TableNode(card3);
    node.setNext(node2);
    
    assertEquals(true, node.getCard().equals(card));
    assertEquals(true, node.getNext().getCard().equals(card3));
    
  }
}
