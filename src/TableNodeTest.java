import junit.framework.TestCase;

public class TableNodeTest extends TestCase {
  public void testTableNode() {
    
    Card card1 = new Card(2, 3, 3, 1);
    TableNode n1 = new TableNode(card1);
    assertEquals(null, n1.getNext());
    assertEquals(card1, n1.getCard());
    
    Card card2 = new Card(1, 2, 3, 1);
    TableNode n2 = new TableNode(card2);
    assertEquals(null, n1.getNext());
    assertEquals(card2, n2.getCard());
    
    Card card3 = new Card(1, 2, 2, 2);
    TableNode n3 = new TableNode(card3);
    assertEquals(null, n1.getNext());
    assertEquals(card3, n3.getCard());
  }
  
}
