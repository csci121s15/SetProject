import junit.framework.TestCase;

public class DeckTest extends TestCase {
  public void testZeroArgumentConstructor(){  
    Deck deck = new Deck();
    int count = 0;
    while(deck.hasNext()){
      deck.getNext();
      count += 1;
    }
    assertEquals(81, count);
  }
  
  public void testHasNext(){
    Deck deck = new Deck("testDeck.dat");
    // this deck has four cards
    assertTrue(deck.hasNext());
    deck.getNext();
    assertTrue(deck.hasNext());
    deck.getNext();
    assertTrue(deck.hasNext());
    deck.getNext();
    assertTrue(deck.hasNext());
    deck.getNext();
    assertFalse(deck.hasNext());
  }
  
  public void testShuffle(){
    //get five decks
    Deck deck1 = new Deck();
    Deck deck2 = new Deck();
    Deck deck3 = new Deck();
    Deck deck4 = new Deck();
    Deck deck5 = new Deck();
  
    //get top card
    Card card1 = deck1.getNext();
    Card card2 = deck2.getNext();
    Card card3 = deck3.getNext();
    Card card4 = deck4.getNext();
    Card card5 = deck5.getNext();
    
    //make sure they are not all equal
    assertFalse(card1.equals(card2) && card1.equals(card3) && 
                card1.equals(card4) && card1.equals(card5));
    
  }
  
  public void testGetNext(){
    
    Deck deck = new Deck("testDeck.dat");
    assertEquals(new Card(1,1,1,1), deck.getNext());
    assertEquals(new Card(2,3,1,2), deck.getNext());
    assertEquals(new Card(2,2,1,3), deck.getNext());
    assertEquals(new Card(3,3,2,2), deck.getNext());
 }
}