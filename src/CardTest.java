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
  public void test123()
  {
    //testing when everything is different
    Card card1 = new Card(1, 1, 1, 1);
    assertEquals(card1.getQuantity(), 1);
    assertEquals(card1.getColor(), 1);
    assertEquals(card1.getShading(), 1);
    assertEquals(card1.getShape(), 1);
    assertEquals(card1.toString(), "1ROO");
    Card card2 = new Card(2, 2, 2, 2);
    assertEquals(card2.getQuantity(), 2);
    assertEquals(card2.getColor(), 2);
    assertEquals(card2.getShading(), 2);
    assertEquals(card2.getShape(), 2);
    assertEquals(card2.toString(), "2GTD");
    Card card3 = new Card(3, 3, 3, 3);
    assertEquals(card3.getQuantity(), 3);
    assertEquals(card3.getColor(), 3);
    assertEquals(card3.getShading(), 3);
    assertEquals(card3.getShape(), 3);
    assertEquals(card3.toString(), "3PSS");
    assertEquals(card1.isSet(card2, card3), true);
  }
  public void testStupidNumbers()
  {
    //testing when all shading is different
    Card negCard = new Card(-3, -33, -333, -3333);
    assertEquals(negCard.getQuantity(), 1);
    assertEquals(negCard.getColor(), 1);
    assertEquals(negCard.getShading(), 1);
    assertEquals(negCard.getShape(), 1);
    assertEquals(negCard.toString(), "1ROO");
    Card lrgCard = new Card(2147483647, 172831, 7910, 457);
    assertEquals(lrgCard.getQuantity(), 2);
    assertEquals(lrgCard.getColor(), 2);
    assertEquals(lrgCard.getShading(), 3);
    assertEquals(lrgCard.getShape(), 2);
    assertEquals(lrgCard.toString(), "2GSD");
    Card ranCard = new Card(24, 0, -2147483648, 2);
    assertEquals(ranCard.getQuantity(), 1);
    assertEquals(ranCard.getColor(), 1);
    assertEquals(ranCard.getShading(), 2);
    assertEquals(ranCard.getShape(), 2);
    assertEquals(ranCard.toString(), "1RTD"); 
    assertEquals(negCard.isSet(lrgCard, ranCard), false);
  }
  
  public void test3()
  {
    //testing when all the same
    Card card4 = new Card(3, 3, 3, 3);
    assertEquals(card4.getQuantity(), 3);
    assertEquals(card4.getColor(), 3);
    assertEquals(card4.getShading(), 3);
    assertEquals(card4.getShape(), 3);
    assertEquals(card4.toString(), "3PSS");
    Card card5 = new Card(3,3,3,3);
    assertEquals(card5.getQuantity(), 3);
    assertEquals(card5.getColor(), 3);
    assertEquals(card5.getShading(), 3);
    assertEquals(card5.getShape(), 3);
    assertEquals(card5.toString(), "3PSS");
    Card card6 = new Card(3,3,3,3);
    assertEquals(card6.getQuantity(), 3);
    assertEquals(card6.getColor(), 3);
    assertEquals(card6.getShading(), 3);
    assertEquals(card6.getShape(), 3);
    assertEquals(card6.toString(), "3PSS");
    assertEquals(card4.isSet(card5, card6), true);
  }
  
  public void test2()
  {
    Card card1 = new Card(2, 2, 2, 2);
    assertEquals(card1.getQuantity(), 2);
    assertEquals(card1.getColor(), 2);
    assertEquals(card1.getShading(), 2);
    assertEquals(card1.getShape(), 2);
    assertEquals(card1.toString(), "2GTD");
    Card card2 = new Card(2, 2, 2, 2);
    assertEquals(card2.getQuantity(), 2);
    assertEquals(card2.getColor(), 2);
    assertEquals(card2.getShading(), 2);
    assertEquals(card2.getShape(), 2);
    assertEquals(card2.toString(), "2GTD");
    Card card3 = new Card(2, 2, 2, 2);
    assertEquals(card3.getQuantity(), 2);
    assertEquals(card3.getColor(), 2);
    assertEquals(card3.getShading(), 2);
    assertEquals(card3.getShape(), 2);
    assertEquals(card3.toString(), "2GTD");
    assertEquals(card1.isSet(card2, card3), true);
  }
  
  public void test1()
  {
    Card card1 = new Card(1, 1, 1, 1);
    assertEquals(card1.getQuantity(), 1);
    assertEquals(card1.getColor(), 1);
    assertEquals(card1.getShading(), 1);
    assertEquals(card1.getShape(), 1);
    assertEquals(card1.toString(), "1ROO");
    Card card2 = new Card(1, 1, 1, 1);
    assertEquals(card2.getQuantity(), 1);
    assertEquals(card2.getColor(), 1);
    assertEquals(card2.getShading(), 1);
    assertEquals(card2.getShape(), 1);
    assertEquals(card2.toString(), "1ROO");
    Card card3 = new Card(1, 1, 1, 1);
    assertEquals(card3.getQuantity(), 1);
    assertEquals(card3.getColor(), 1);
    assertEquals(card3.getShading(), 1);
    assertEquals(card3.getShape(), 1);
    assertEquals(card3.toString(), "1ROO");
    assertEquals(card1.isSet(card2, card3), true);
  }
  
  public void testAgainWheeee()
  {
    Card card1 = new Card(3, 3, 1, 2);
    assertEquals(card1.getQuantity(), 3);
    assertEquals(card1.getColor(), 3);
    assertEquals(card1.getShading(), 1);
    assertEquals(card1.getShape(), 2);
    assertEquals(card1.toString(), "3POD");
    Card card2 = new Card(1, 2, 3, 3);
    assertEquals(card2.getQuantity(), 1);
    assertEquals(card2.getColor(), 2);
    assertEquals(card2.getShading(), 3);
    assertEquals(card2.getShape(), 3);
    assertEquals(card2.toString(), "1GSS");
    Card card3 = new Card(2, 1, 2, 1);
    assertEquals(card3.getQuantity(), 2);
    assertEquals(card3.getColor(), 1);
    assertEquals(card3.getShading(), 2);
    assertEquals(card3.getShape(), 1);
    assertEquals(card3.toString(), "2RTO");
    assertEquals(card1.isSet(card2, card3), true);
  }
  
  public void testAgainAgain()
  {
    Card card1 = new Card(3, 3, 1, 23);
    assertEquals(card1.getQuantity(), 3);
    assertEquals(card1.getColor(), 3);
    assertEquals(card1.getShading(), 1);
    assertEquals(card1.getShape(), 3);
    assertEquals(card1.toString(), "3POS");
    Card card2 = new Card(1, 2, 3, 3);
    assertEquals(card2.getQuantity(), 1);
    assertEquals(card2.getColor(), 2);
    assertEquals(card2.getShading(), 3);
    assertEquals(card2.getShape(), 3);
    assertEquals(card2.toString(), "1GSS");
    Card card3 = new Card(2, 1, 2, 1);
    assertEquals(card3.getQuantity(), 2);
    assertEquals(card3.getColor(), 1);
    assertEquals(card3.getShading(), 2);
    assertEquals(card3.getShape(), 1);
    assertEquals(card3.toString(), "2RTO");
    assertEquals(card1.isSet(card2, card3), false);
  }
  
  public void testEqualsMethod()
  {
    Card card1 = new Card(1, 1, 1, 1);
    Card card2 = new Card(1, 1, 1, 1);
    Card card3 = new Card(2, 2, 2, 2);
    
    assertTrue(card1.equals(card2));
    assertTrue(card2.equals(card1));
    assertFalse(card1.equals(card3));
    assertFalse(card3.equals(card1));   
    assertFalse(card2.equals(card3));
    assertFalse(card3.equals(card2));
  }
  
}