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
    Card card1 = new Card(3, 2, 2, 1);
    //a card with numbers between 1 and 3
    assertEquals(3, card1.getQuantity());
    assertEquals(2, card1.getColor());
    assertEquals(2, card1.getShading());
    assertEquals(1, card1.getShape());
    
    Card card2 = new Card(4, 5, 6, 7);
   //a card with numbers greater than 3
    assertEquals(1, card2.getQuantity());
    assertEquals(2, card2.getColor());
    assertEquals(3, card2.getShading());
    assertEquals(1, card2.getShape());
    
    Card card3 = new Card(0, -1, -2, -3);
    //a card with numbers lower than 1
    assertEquals(3, card3.getQuantity());
    assertEquals(2, card3.getColor());
    assertEquals(1, card3.getShading());
    assertEquals(3, card3.getShape());
  }
  
  public void testCardEquals()
  {
   Card card1 = new Card(1, 2, 3, 1);
   Card card2 = new Card(1, 2, 3, 1);
   Card card3 = new Card(4, 5, 6, 7);
   Card card4 = new Card(-2, -1, 0, -5);
   Card card5 = new Card(1, 1, 1, 1);
   
   assertEquals(true, card1.equals(card2));
   assertEquals(true, card1.equals(card3));
   assertEquals(true, card1.equals(card4));
   assertEquals(true, card2.equals(card3));
   assertEquals(true, card2.equals(card4));
   assertEquals(true, card3.equals(card4));
   
   assertEquals(false, card5.equals(card1));
   assertEquals(false, card5.equals(card2));
   assertEquals(false, card5.equals(card3));
   assertEquals(false, card5.equals(card4));
   
  }
  
  public void testCardString()
  {
    Card card1 = new Card(1, 1, 1, 2);
    Card card2 = new Card(3, 2, 3, 2);
    Card card3 = new Card(4, 5, 6, 7);
    Card card4 = new Card(0, -1, -2, -3);
    
    assertEquals("1ROD", card1.toString());
    assertEquals("3GSD", card2.toString());
    assertEquals("1GSO", card3.toString());
    assertEquals("3GOS", card4.toString());
  }
  
  public void testCardSet()
  {
   Card card1 = new Card(1, 1, 1, 1);
   Card card2 = new Card(2, 1, 1, 1);
   Card card3 = new Card(3, 1, 1, 1);
   Card card4 = new Card(2, 2, 2, 2);
   Card card5 = new Card(3, 3, 3, 3);
   
   assertEquals(true, card1.isSet(card2, card3));
   assertEquals(true, card1.isSet(card4, card5));
   assertEquals(false, card1.isSet(card2, card4));
   assertEquals(true, card3.isSet(card2, card1));
   assertEquals(true, card2.isSet(card1, card3));
   assertEquals(false, card2.isSet(card1, card4));
   assertEquals(false, card4.isSet(card1, card2));
   assertEquals(false, card4.isSet(card3, card2));
   
  }  
}