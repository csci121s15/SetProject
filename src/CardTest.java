import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class CardTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  
  public void testTheSetValues() {
    Card card1 = new Card(1, 1, 1, 1);
    assertEquals(1, card1.getQuantity());
    assertEquals(1, card1.getColor());
    assertEquals(1, card1.getShading());
    assertEquals(1, card1.getShape());
    assertEquals("1ROO", card1.toString());
  }
  
  public void testNegativeSetValues() {
    Card card1 = new Card(-4, -4, -4, -4);
    assertEquals("3PSS", card1.toString());
  }
  
  public void testSetIsLegal() {
    Card card1 = new Card(2, 2, 1, 1);
    Card card2 = new Card(2, 2, 2, 2);
    Card card3 = new Card(2, 2, 3, 3);
    assertEquals(true, card1.isSet(card2, card3));
                   
  }
  
  public void testSetIsNotLegal() {
    Card card1 = new Card(1, 1, 2, 2);
    Card card2 = new Card(2, 1, 2, 2);
    Card card3 = new Card(2, 2, 2, 2);
    assertEquals(false, card2.isSet(card1, card3));
  }
  
  public void testAllCardsSame() {
    Card card1 = new Card(3, 2, 1, 3);
    Card card2 = new Card(3, 2, 1, 3);
    Card card3 = new Card(3, 2, 1, 3);
    assertEquals(true, card3.isSet(card1, card2));
  }
  
  public void testSameColor() {
    Card card1 = new Card(1, 1, 2, 3);
    Card card2 = new Card(2, 1, 1, 2);
    Card card3 = new Card(3, 1, 3, 1);
    assertEquals(true, card1.isSet(card2, card3));
  }
  
  public void testAllRandomCards() {
    Card card1 = new Card(1, 2, 3, 1);
    Card card2 = new Card(2, 3, 1, 2);
    Card card3 = new Card(3, 1, 2, 3);
    assertEquals(true, card2.isSet(card1, card3));
  }
  
  public void testSameShade() {
    Card card1 = new Card(1, 3, 3, 2);
    Card card2 = new Card(2, 2, 3, 2);
    Card card3 = new Card(2, 3, 3, 2);
    assertEquals(false, card3.isSet(card2, card1));
  }
                 
                
                               

}
