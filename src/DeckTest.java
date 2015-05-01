import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class DeckTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testEmptyDeck() {
    Deck d = new Deck("EmptyDeck.txt");
    assertEquals(d.hasNext(), false);
  }
  
  public void testAllCards() {
    Deck d = new Deck("81cards.txt");
    for (int i=0; i<81; i++) {     
      assertEquals(d.hasNext(), true);
      d.getNext();
    }
    d.getNext();
    assertEquals(d.hasNext(), false);
  }
  
  public void test3Cards() {
    Deck d = new Deck("3cards.txt");
    for (int i=0; i<3; i++) {
      assertEquals(d.hasNext(), true);
      d.getNext();
    }
    d.getNext();
    assertEquals(d.hasNext(), false);
  }
  
  
}
