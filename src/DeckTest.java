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
    int i = 0;
    
    while (deck.hasNext())
    {
     deck.getNext();
     i += 1;
    }
    
    assertEquals(81, i);
  }
  
   public void testCostumDeckCreation()
  {
     Deck deck = new Deck("DeckTester.dat");
     Card card1 = new Card(1, 1, 1, 1);
     Card card2 = new Card(1, 1, 1, 2);
     Card card3 = new Card(1, 1, 1, 3);
     Card card4 = new Card(1, 1, 2, 1);
     
     assertEquals(true, deck.hasNext());
     assertEquals(true, deck.getNext().equals(card1));
     
     assertEquals(true, deck.hasNext());
     assertEquals(true, deck.getNext().equals(card2));
     
     assertEquals(true, deck.hasNext());
     assertEquals(true, deck.getNext().equals(card3));
     
     assertEquals(true, deck.hasNext());
     assertEquals(true, deck.getNext().equals(card4));
     
     assertEquals(false, deck.hasNext());
     assertEquals(null, deck.getNext());
  }
   
   public void testEmptyDeck()
   {
    Deck deck = new Deck("emptydeck.txt");
    
    assertEquals(false, deck.hasNext());
    assertEquals(null, deck.getNext());
   }
   
   public void testOneDeck()
   {
    Deck deck = new Deck("onedeck.txt");
    Card card = new Card(1, 1, 1, 1);
    
    assertEquals(true, deck.hasNext());
    assertEquals(true, deck.getNext().equals(card));
    
    assertEquals(false, deck.hasNext());
    assertEquals(null, deck.getNext());
   }
}

