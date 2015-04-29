import junit.framework.TestCase;

public class CardTest extends TestCase {

  public void testOneCard() {
    Card c = new Card(1, 1, 1, 1);
    
    assertEquals(1, c.getQuantity());
    assertEquals(1, c.getColor());
    assertEquals(1, c.getShading());
    assertEquals(1, c.getShape());
    assertEquals("1ROO", c.toString());
  }
  
  public void testInvalidValues() {
    Card c = new Card(-2, 4, 8, 0);
    
    assertEquals(2, c.getQuantity());
    assertEquals(2, c.getColor());
    assertEquals(3, c.getShading());
    assertEquals(1, c.getShape());
    assertEquals("2GSO", c.toString());
  }
  
  public void testMixedValidityValues() {
    Card c = new Card(2, 1, 5, 0);
    
    assertEquals(2, c.getQuantity());
    assertEquals(1, c.getColor());
    assertEquals(3, c.getShading());
    assertEquals(1, c.getShape());
    assertEquals("2RSO", c.toString());
  }
  
  public void testNotSet() {
    Card c1 = new Card(2, 1, 5, 0);
    Card c2 = new Card(1, 1, 3, 2);
    Card c3 = new Card(2, 1, 1, 1);
    
    assertEquals(2, c1.getQuantity());
    assertEquals(1, c1.getColor());
    assertEquals(3, c1.getShading());
    assertEquals(1, c1.getShape());
    assertEquals("2RSO", c1.toString());
    
    assertEquals(1, c2.getQuantity());
    assertEquals(1, c2.getColor());
    assertEquals(3, c2.getShading());
    assertEquals(2, c2.getShape());
    assertEquals("1RSD", c2.toString());
    
    assertEquals(2, c3.getQuantity());
    assertEquals(1, c3.getColor());
    assertEquals(1, c3.getShading());
    assertEquals(1, c3.getShape());
    assertEquals("2ROO", c3.toString());
    
    assertFalse(c1.isSet(c2, c3));
  }
  
  public void testSet() {
    Card c1 = new Card(2, 1, 2, 3);
    Card c2 = new Card(2, 1, 3, 2);
    Card c3 = new Card(2, 1, 1, 1);
    
    assertEquals(2, c1.getQuantity());
    assertEquals(1, c1.getColor());
    assertEquals(2, c1.getShading());
    assertEquals(3, c1.getShape());
    assertEquals("2RTS", c1.toString());
    
    assertEquals(2, c2.getQuantity());
    assertEquals(1, c2.getColor());
    assertEquals(3, c2.getShading());
    assertEquals(2, c2.getShape());
    assertEquals("2RSD", c2.toString());
    
    assertEquals(2, c3.getQuantity());
    assertEquals(1, c3.getColor());
    assertEquals(1, c3.getShading());
    assertEquals(1, c3.getShape());
    assertEquals("2ROO", c3.toString());
    
    assertTrue(c1.isSet(c2, c3));
  }
}
