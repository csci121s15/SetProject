import junit.framework.TestCase;

public class TableNodeTest extends TestCase
{
  Card card1 = new Card(1,1,1,1);
  TableNode node1 = new TableNode(card1);
  Card card2 = new Card(1,2,3,4);
  TableNode node2 = new TableNode(card2);
  
  public void testGetCard()
  {
    assertEquals(card1,node1.getCard());
    assertEquals(card2,node2.getCard());
  }
  
  public void testGetNext()
  {
    assertEquals(null,node1.getNext());
    assertEquals(null,node2.getNext());
  }
  
  public void testSetNext()
  {
    node1.setNext(node2);
    node2.setNext(null);
    
    assertEquals(node2,node1.getNext());
    assertEquals(null,node2.getNext());
  }
}
