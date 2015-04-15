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

  public void testSingleNode() {
    TableNode node = new TableNode(null);
    assertEquals(null, node.getNext());
    assertEquals(null, node.getCard());
  }
  
  public void testTwoNodes() {
    TableNode node = new TableNode(null);
    Card card = new Card(3, 1, 1, 2);
    TableNode node2 = new TableNode(card);
    node.setNext(node2);
    assertEquals(node2, node.getNext());
    assertEquals(card, node2.getCard());
  }
}