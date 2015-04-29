import junit.framework.TestCase;

public class TestTableNode extends TestCase {
  
  public void testSingleTableNode() {
    Card c = new Card(1, 1, 1, 1);
    TableNode node = new TableNode(c);
    
    assertEquals(null, node.getNext());
    assertEquals(c, node.getCard());
    
  }
  
  public void testTwoTableNodes() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    TableNode n1 = new TableNode(c1);
    TableNode n2 = new TableNode(c2);
    
    assertEquals(null, n1.getNext());
    assertEquals(c1, n1.getCard());
    assertEquals(null, n2.getNext());
    assertEquals(c2, n2.getCard());
    
  }
  
}
