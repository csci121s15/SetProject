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
  public void testDeckWorks() {
    Deck d = new Deck();
    assertEquals(81, d.cards.size());
   
  }
 
  public void testHasNext() {
    Deck d = new Deck();
    assertEquals(true, d.hasNext());
  }
  
  public void testEachCardsPosition() {
    Deck d = new Deck("3cards.dat");
    
    Card card1 = new Card(1, 2, 3, 1);
    assertEquals(true, d.hasNext());
    assertEquals(true, card1.equals(d.getNext()));
    
    Card card2 = new Card(2, 1, 3, 2);
    assertEquals(true, d.hasNext());
    assertEquals(true, card2.equals(d.getNext()));
    
    Card card3 = new Card(3, 3, 1, 2);
    assertEquals(true, d.hasNext());
    assertEquals(true, card3.equals(d.getNext()));
    
  }
  
}
