import junit.framework.TestCase;

public class CardTest extends TestCase {
  
  public void testIsSet() {
    Card c1 = new Card(1, 1, 1, 2);
    Card c2 = new Card(1, 2, 2, 2);
    Card c3 = new Card(1, 3, 3, 2);
    assertEquals(true, c1.isSet(c2, c3));  
  }
  
  public void testIsntSet() {
    Card c1 = new Card(2, 1, 1, 2);
    Card c2 = new Card(1, 2, 2, 2);
    Card c3 = new Card(1, 3, 3, 2);
    assertEquals(false, c1.isSet(c2, c3));
  }
  
  public void testToString() {
    Card c = new Card(2, 1, 2, 3);
    assertEquals("2RTS", c.toString());
  }
}
