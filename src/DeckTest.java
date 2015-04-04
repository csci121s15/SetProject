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
  public void testDeckCreation()
  {
    Deck deck = new Deck();
    
    assertEquals(0, deck.getNextCardIndex());
    assertEquals(81, deck.size());
    
    assertEquals(true, deck.contains(new Card(1, 1, 1, 1)));
    assertEquals(true, deck.contains(new Card(1, 1, 1, 2)));
    assertEquals(true, deck.contains(new Card(1, 1, 1, 3)));
    assertEquals(true, deck.contains(new Card(1, 1, 2, 1)));
    assertEquals(true, deck.contains(new Card(1, 1, 2, 2)));
    assertEquals(true, deck.contains(new Card(1, 1, 2, 3)));
    assertEquals(true, deck.contains(new Card(1, 1, 3, 1)));
    assertEquals(true, deck.contains(new Card(1, 1, 3, 2)));
    assertEquals(true, deck.contains(new Card(1, 1, 3, 3)));
    assertEquals(true, deck.contains(new Card(1, 2, 1, 1)));
    assertEquals(true, deck.contains(new Card(1, 2, 1, 2)));
    assertEquals(true, deck.contains(new Card(1, 2, 1, 3)));
    assertEquals(true, deck.contains(new Card(1, 2, 2, 1)));
    assertEquals(true, deck.contains(new Card(1, 2, 2, 2)));
    assertEquals(true, deck.contains(new Card(1, 2, 2, 3)));
    assertEquals(true, deck.contains(new Card(1, 2, 3, 1)));
    assertEquals(true, deck.contains(new Card(1, 2, 3, 2)));
    assertEquals(true, deck.contains(new Card(1, 2, 3, 3)));
    assertEquals(true, deck.contains(new Card(1, 3, 1, 1)));
    assertEquals(true, deck.contains(new Card(1, 3, 1, 2)));
    assertEquals(true, deck.contains(new Card(1, 3, 1, 3)));
    assertEquals(true, deck.contains(new Card(1, 3, 2, 1)));
    assertEquals(true, deck.contains(new Card(1, 3, 2, 2)));
    assertEquals(true, deck.contains(new Card(1, 3, 2, 3)));
    assertEquals(true, deck.contains(new Card(1, 3, 3, 1)));
    assertEquals(true, deck.contains(new Card(1, 3, 3, 2)));
    assertEquals(true, deck.contains(new Card(1, 3, 3, 3)));
    
    assertEquals(true, deck.contains(new Card(2, 1, 1, 1)));
    assertEquals(true, deck.contains(new Card(2, 1, 1, 2)));
    assertEquals(true, deck.contains(new Card(2, 1, 1, 3)));
    assertEquals(true, deck.contains(new Card(2, 1, 2, 1)));
    assertEquals(true, deck.contains(new Card(2, 1, 2, 2)));
    assertEquals(true, deck.contains(new Card(2, 1, 2, 3)));
    assertEquals(true, deck.contains(new Card(2, 1, 3, 1)));
    assertEquals(true, deck.contains(new Card(2, 1, 3, 2)));
    assertEquals(true, deck.contains(new Card(2, 1, 3, 3)));
    assertEquals(true, deck.contains(new Card(2, 2, 1, 1)));
    assertEquals(true, deck.contains(new Card(2, 2, 1, 2)));
    assertEquals(true, deck.contains(new Card(2, 2, 1, 3)));
    assertEquals(true, deck.contains(new Card(2, 2, 2, 1)));
    assertEquals(true, deck.contains(new Card(2, 2, 2, 2)));
    assertEquals(true, deck.contains(new Card(2, 2, 2, 3)));
    assertEquals(true, deck.contains(new Card(2, 2, 3, 1)));
    assertEquals(true, deck.contains(new Card(2, 2, 3, 2)));
    assertEquals(true, deck.contains(new Card(2, 2, 3, 3)));
    assertEquals(true, deck.contains(new Card(2, 3, 1, 1)));
    assertEquals(true, deck.contains(new Card(2, 3, 1, 2)));
    assertEquals(true, deck.contains(new Card(2, 3, 1, 3)));
    assertEquals(true, deck.contains(new Card(2, 3, 2, 1)));
    assertEquals(true, deck.contains(new Card(2, 3, 2, 2)));
    assertEquals(true, deck.contains(new Card(2, 3, 2, 3)));
    assertEquals(true, deck.contains(new Card(2, 3, 3, 1)));
    assertEquals(true, deck.contains(new Card(2, 3, 3, 2)));
    assertEquals(true, deck.contains(new Card(2, 3, 3, 3)));
    
    assertEquals(true, deck.contains(new Card(3, 1, 1, 1)));
    assertEquals(true, deck.contains(new Card(3, 1, 1, 2)));
    assertEquals(true, deck.contains(new Card(3, 1, 1, 3)));
    assertEquals(true, deck.contains(new Card(3, 1, 2, 1)));
    assertEquals(true, deck.contains(new Card(3, 1, 2, 2)));
    assertEquals(true, deck.contains(new Card(3, 1, 2, 3)));
    assertEquals(true, deck.contains(new Card(3, 1, 3, 1)));
    assertEquals(true, deck.contains(new Card(3, 1, 3, 2)));
    assertEquals(true, deck.contains(new Card(3, 1, 3, 3)));
    assertEquals(true, deck.contains(new Card(3, 2, 1, 1)));
    assertEquals(true, deck.contains(new Card(3, 2, 1, 2)));
    assertEquals(true, deck.contains(new Card(3, 2, 1, 3)));
    assertEquals(true, deck.contains(new Card(3, 2, 2, 1)));
    assertEquals(true, deck.contains(new Card(3, 2, 2, 2)));
    assertEquals(true, deck.contains(new Card(3, 2, 2, 3)));
    assertEquals(true, deck.contains(new Card(3, 2, 3, 1)));
    assertEquals(true, deck.contains(new Card(3, 2, 3, 2)));
    assertEquals(true, deck.contains(new Card(3, 2, 3, 3)));
    assertEquals(true, deck.contains(new Card(3, 3, 1, 1)));
    assertEquals(true, deck.contains(new Card(3, 3, 1, 2)));
    assertEquals(true, deck.contains(new Card(3, 3, 1, 3)));
    assertEquals(true, deck.contains(new Card(3, 3, 2, 1)));
    assertEquals(true, deck.contains(new Card(3, 3, 2, 2)));
    assertEquals(true, deck.contains(new Card(3, 3, 2, 3)));
    assertEquals(true, deck.contains(new Card(3, 3, 3, 1)));
    assertEquals(true, deck.contains(new Card(3, 3, 3, 2)));
    assertEquals(true, deck.contains(new Card(3, 3, 3, 3)));
  }
  
   public void testCostumDeckCreation()
  {
     Deck deck = new Deck("DeckTester.dat");
     Card card1 = new Card(1, 1, 1, 1);
     Card card2 = new Card(1, 1, 1, 2);
     Card card3 = new Card(1, 1, 1, 3);
     Card card4 = new Card(1, 1, 2, 1);
     
     assertEquals(4, deck.size());
     assertEquals(0, deck.getNextCardIndex());
     
     assertEquals(true, deck.hasNext());
     assertEquals(true, deck.getNext().equals(card1));
     assertEquals(1, deck.getNextCardIndex());
     
     assertEquals(true, deck.hasNext());
     assertEquals(true, deck.getNext().equals(card2));
     assertEquals(2, deck.getNextCardIndex());
     
     assertEquals(true, deck.hasNext());
     assertEquals(true, deck.getNext().equals(card3));
     assertEquals(3, deck.getNextCardIndex());
     
     assertEquals(true, deck.hasNext());
     assertEquals(true, deck.getNext().equals(card4));
     
     assertEquals(false, deck.hasNext());
     assertEquals(null, deck.getNext());
  }
}
