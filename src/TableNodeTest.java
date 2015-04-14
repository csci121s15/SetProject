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
  
  public void testNodeWithMultipleCards() {
    Card card1 = new Card(1, 2, 1, 2);
    TableNode tipTopNode1 = new TableNode(card1);
    assertEquals(card1, tipTopNode1.getCard());
    assertEquals(true, tipTopNode1.getCard().equals(card1));
    
    Card card2 = new Card(2, 3, 2, 3);
    TableNode tipTopNode2 = new TableNode(card2);
    assertEquals(card2, tipTopNode2.getCard());
    assertEquals(true, tipTopNode2.getCard().equals(card2));
    
    Card card3 = new Card(1, 3, 1, 3);
    TableNode tipTopNode3 = new TableNode(card3);
    assertEquals(card3, tipTopNode3.getCard());
    assertEquals(true, tipTopNode3.getCard().equals(card3));
    
    Card card4 = new Card(1, 2, 3, 1);
    TableNode tipTopNode4 = new TableNode(card4);
    assertEquals(card4, tipTopNode4.getCard());
    assertEquals(true, tipTopNode4.getCard().equals(card4));
    
    Card card5 = new Card(2, 3, 1, 2);
    TableNode tipTopNode5 = new TableNode(card5);
    assertEquals(card5, tipTopNode5.getCard());
    assertEquals(true, tipTopNode5.getCard().equals(card5));
    
    Card card6 = new Card(1, 1, 1, 1);
    TableNode tipTopNode6 = new TableNode(card6);
    assertEquals(card6, tipTopNode6.getCard());
    assertEquals(true, tipTopNode6.getCard().equals(card6));
    
  }
    

  public void testNewNodeWithOneCard() {
    Card superCard = new Card(1, 2, 3, 1);
    TableNode tipTopNode = new TableNode(superCard);
    
    assertEquals(null, tipTopNode.getNext());
    assertEquals(superCard, tipTopNode.getCard());
    assertEquals(true, tipTopNode.getCard().equals(superCard));
    
  }
}
