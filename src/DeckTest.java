import junit.framework.TestCase;

public class DeckTest extends TestCase {
  public void testoneCard() {
    Deck d = new Deck("oneCard.dat");
    
    assertTrue(d.hasNext());
    assertEquals("1GSO", d.getNext().toString());
    assertFalse(d.hasNext());
  }
  
  public void testoneSetTrue() {
    Deck d = new Deck("oneSetTrue.dat");
    Card c = d.getNext();
    assertTrue(d.hasNext());
    Card c2 = d.getNext();
    assertTrue(d.hasNext());
    Card c3 = d.getNext();
    assertFalse(d.hasNext());
   
    assertEquals("1ROO", c.toString());
    assertEquals("1GOO", c2.toString());
    assertEquals("1POO", c3.toString());
    
    assertTrue(c.isSet(c2, c3));
    
  }
  
  public void testoneSetFalse() {
    Deck d = new Deck("oneSetFalse.dat");
    Card c = d.getNext();
    assertTrue(d.hasNext());
    Card c2 = d.getNext();
    assertTrue(d.hasNext());
    Card c3 = d.getNext();
    assertFalse(d.hasNext());
    
    
    assertEquals("1ROO", c.toString());
    assertEquals("2GTD", c2.toString());
    assertEquals("3PSO", c3.toString());
    
    assertFalse(c.isSet(c2, c3));
  }
  
}
