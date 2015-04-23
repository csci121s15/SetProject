import junit.framework.TestCase;

public class CardTest extends TestCase {

  public void testValues() {
    Card c = new Card(1, 2, 3, 1);

    assertEquals(1, c.getQuantity());
    assertEquals(2, c.getColor());
    assertEquals(3, c.getShading());
    assertEquals(1, c.getShape());
  }
  
  public void testValuesOutOfRange() {
    Card c = new Card(7, 9, -4, 0);
    
    assertEquals(2, c.getQuantity());
    assertEquals(1, c.getColor());
    assertEquals(3, c.getShading());
    assertEquals(1, c.getShape());
  }
  
  // 1 1 1
  public void testSameSet() {
    Card c = new Card(3, 2, 2, 1);
    Card c2 = new Card(1, 3, 1, 1);
    Card c3 = new Card(2, 1, 3, 1);
    
    assertTrue(c.isSet(c2, c3));
  }
  
  // 1 2 3
  public void testRowSet() {
    Card c = new Card(3, 1, 2, 3);
    Card c2 = new Card(1, 2, 1, 2);
    Card c3 = new Card(2, 3, 3, 1);
    
    assertTrue(c.isSet(c2, c3));
  }
    
  public void testNoSet() {
    Card c = new Card(1, 1, 3, 3);
    Card c2 = new Card(1, 2, 1, 1);
    Card c3 = new Card(2, 1, 3, 1);
    
    assertFalse(c.isSet(c2, c3));
  }
  
  public void testString() {
    Card c = new Card(1, 2, 3, 1);
    
    // Should be 1GSO
    assertEquals("1GSO", c.toString());
      
    System.out.println(c);
  }
  
  public void testEqual() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 1, 1);
    
    assertEquals(c1, c2);
  }
}
