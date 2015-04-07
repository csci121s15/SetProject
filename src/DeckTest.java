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
  public void testDeckCard() {
    Deck d = new Deck("threeCards.dat");
    Card c1 = new Card(0,1,2,1);
    
    assertEquals(true, d.getNext().equals(c1));
    assertEquals(true, d.hasNext());
    
    Card c2 = new Card(1,2,0,2);
    
    assertEquals(true, d.getNext().equals(c2));
    assertEquals(true, d.hasNext());
    
    Card c3 = new Card(2,0,1,0);
    
    assertEquals(true, d.getNext().equals(c3));
    assertEquals(false, d.hasNext());
  }
  
}
