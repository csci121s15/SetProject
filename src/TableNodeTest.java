import junit.framework.TestCase;
public class TableNodeTest extends TestCase {
  public void testGetters() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 2, 2);
    Card c3 = new Card(1, 2, 3, 1);
    
    TableNode t1 = new TableNode(c1);
    TableNode t2 = new TableNode(c2);
    TableNode t3 = new TableNode(c3);
    
    t1.setNext(t2);
    t2.setNext(t3);
    
    assertEquals("1ROO", t1.getCard().toString());
    assertEquals("1RTD", t2.getCard().toString());
    assertEquals("1GSO", t3.getCard().toString());
    
    assertEquals("1RTD", t1.getNext().getCard().toString());
    assertEquals("1GSO", t2.getNext().getCard().toString());
  }
}
    
    
    