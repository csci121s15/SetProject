import junit.framework.TestCase;

public class DeckTest extends TestCase {
  public void testDeck() {
    Deck d = new Deck();
    
    assertEquals(81, d.cards.size());
  }
  
  public void testHasNext() {
    Deck d = new Deck();
    
    assertEquals(true, d.hasNext());
  }
  
  public void testOtherConstructor() {
    Deck d = new Deck("3cards.txt");
    
    assertEquals("1ROO", d.getNext().toString());
    assertEquals(true, d.hasNext());
    
    assertEquals("2GTD", d.getNext().toString());
    assertEquals(true, d.hasNext());
    
    assertEquals("3PSS", d.getNext().toString());
    assertEquals(false, d.hasNext());
  }
}