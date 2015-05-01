import junit.framework.TestCase;

public class TableNodeTest extends TestCase {
  
  public void testTableNodeCards() {
    Card card1 = new Card(1, 3, 3, 2);
    TableNode node1 = new TableNode(card1);
    assertEquals(null, node1.getNext());
    assertEquals(card1, node1.getCard());
    
    Card card2 = new Card(1, 3, 1, 2);
    TableNode node2 = new TableNode(card2);
    assertEquals(null, node2.getNext());
    assertEquals(card2, node2.getCard());
    
    Card card3 = new Card(1, 3, 2, 2);
    TableNode node3 = new TableNode(card3);
    assertEquals(null, node3.getNext());
    assertEquals(card3, node3.getCard());
  }
}