import junit.framework.TestCase;

public class DeckTest extends TestCase {

  public void testDeckSize() {
    Deck deck = new Deck();
    assertEquals(81, deck.cards.size());     
  }
}
