import junit.framework.TestCase;

public class CardTest extends TestCase {

  public void testConstructorAndGetters(){ 
    int expectedQuantity = 2;
    int expectedColor = 1;
    int expectedShape = 3;
    int expectedShading = 2; 
    
    Card card = new Card(expectedQuantity, expectedColor, expectedShading, expectedShape); 
    
    assertEquals(expectedQuantity, card.getQuantity());
    assertEquals(expectedColor, card.getColor()); 
    assertEquals(expectedShading, card.getShading());
    assertEquals(expectedShape, card.getShape());
  }
  
  public void testConstructorModulo(){
    int expectedQuantity = 2;
    int expectedColor = 1;
    int expectedShape = 3;
    int expectedShading = 3; 
    
    Card card = new Card(4, 6, 11, -10);
    
    assertEquals(expectedQuantity, card.getQuantity());
    assertEquals(expectedColor, card.getColor()); 
    assertEquals(expectedShading, card.getShading());
    assertEquals(expectedShape, card.getShape());
  }

  public void testToString(){
    Card card = new Card(1,1,2,3);
    assertEquals("1RTS", card.toString());
    Card card2 = new Card(2,3,3,1);
    assertEquals("2PSO", card2.toString()); 
    Card card3 = new Card(3,2,2,2);
    assertEquals("3GTD", card3.toString());
  }
   
  public void testIsSet(){
    Card card0 = new Card(1,1,3,1);
    Card card1 = new Card(1,2,2,1);
    Card card2 = new Card(1,3,1,1);
    Card card3 = new Card(2,1,3,3);
    Card card4 = new Card(3,1,3,2);
    
    assertTrue(card0.isSet(card2, card1));
    assertTrue(card0.isSet(card3, card4)); 
    assertFalse(card0.isSet(card1, card3)); 
    assertFalse(card0.isSet(card2, card4)); 
    
  }
  
  public void testIsSetTransitive(){ 
    Card card0 = new Card(1,1,3,1);
    Card card1 = new Card(1,2,2,1);
    Card card2 = new Card(1,3,1,1);
    Card card3 = new Card(2,1,3,3);
  
    assertTrue(card0.isSet(card2, card1));
    assertTrue(card1.isSet(card0, card2)); 
    assertTrue(card2.isSet(card1, card0)); 
    assertFalse(card0.isSet(card2, card3));  
    assertFalse(card2.isSet(card0, card3));
    assertFalse(card3.isSet(card2, card0));
  }
}