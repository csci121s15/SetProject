import junit.framework.TestCase;
public class DeckTest extends TestCase {
  
  public void testWorking() {
    Deck d = new Deck();
    assertEquals(81, d.cards.size());
  }
  
  public void testhasNext() {
    Deck d = new Deck();
    assertTrue(d.hasNext());
  }
  
  public void testDeckCards() {
    Deck d = new Deck();
    Card c1 = new Card(2, 3, 0, 1);
    assertTrue(d.hasNext());
    assertEquals(false, c1.equals(d.getNext()));
    Card c2 = new Card(3, 1, 2, 1);
    assertTrue(d.hasNext());
    assertEquals(false, c2.equals(d.getNext()));
    Card c3 = new Card(1, 3, 2, 1);
    assertTrue(d.hasNext());
    assertEquals(false, c3.equals(d.getNext()));
  }
  
}    
    