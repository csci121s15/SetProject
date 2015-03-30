import junit.framework.TestCase;

public class CardTest extends TestCase{
  
  public void testCardInt(){
    
    Card c1 = new Card(7,1,1,1);
    
    assertEquals(2, c1.getQuantity());
    assertEquals(2, c1.getColor());
    assertEquals(2, c1.getShading());
    assertEquals(2, c1.getShape());
    
    Card card3 = new Card(0, -1, -2, -3);
    assertEquals(1, card3.getQuantity());
    assertEquals(3, card3.getColor());
    assertEquals(2, card3.getShading());
    assertEquals(1, card3.getShape());
  }
  
  public void testSet(){
    
    Card cardA = new Card(1,1,1,1);
    Card cardB = new Card(2,1,1,1);
    Card cardC = new Card(3,1,1,1);
    Card cardD = new Card(1,1,1,3);    

    assertEquals(true, cardA.isSet(cardB, cardC));
    assertEquals(false, cardA.isSet(cardC, cardD));
  }
  
  public void testCardString(){
    
    Card card1 = new Card(0, 1, 1, 1);
    Card card2 = new Card(-2, -4, 0, -5);
    Card card3 = new Card(-4, -3, -8, 8);
     
    assertEquals("1GTD", card1.toString());
    assertEquals("2POD", card2.toString());
    assertEquals("3RTS", card3.toString());
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
}

  