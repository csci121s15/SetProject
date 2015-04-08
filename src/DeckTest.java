import junit.framework.TestCase;

public class DeckTest extends TestCase {

  public void testDeck() {
    Deck d = new Deck();
    
    int num = 0;
      while (d.hasNext() == true) {
      d.getNext();
      num += 1;
      }

    assertEquals(81, num);
  }
  
  public void testFile() {
    Deck d = new Deck("deck.dat");
    
    int num = 0;
      while (d.hasNext() == true) {
      num += 1;
      d.getNext();
      }
      
    assertEquals(9, num);
  }

  public void testEmpty() {
    Deck d = new Deck("empty.dat");
    
    int num = 0;
      while (d.hasNext() == true) {
      num += 1;
      d.getNext();
      }
      
    assertFalse(d.hasNext());
    assertEquals(null, d.getNext());
  }
}
