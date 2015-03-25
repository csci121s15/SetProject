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
  public void testCardQueeries()
  {
    Card card1 = new Card(1, 2, 2, 1);
    
    assertEquals(1, card1.getQuantity());
    assertEquals(2, card1.getColor());
    assertEquals(2, card1.getShading());
    assertEquals(1, card1.getShape());
  }
  
  public void testCardOverflow()
  {
   Card card1 = new Card(4, 5, 6, 7);
   
   assertEquals(1, card1.getQuantity());
   assertEquals(2, card1.getColor());
   assertEquals(3, card1.getShading());
   assertEquals(1, card1.getShape());
  }
  
}
