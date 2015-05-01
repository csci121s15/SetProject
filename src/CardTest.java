import junit.framework.TestCase; 

public class CardTest extends TestCase {
  public void testNewCardAllSame() {
    Card a = new Card(1, 1, 1, 1);
    Card b = new Card(2, 2, 2, 2);
    Card c = new Card(3, 3, 3, 3);
    
    assertEquals(1, a.getQuantity());
    assertEquals(1, a.getColor());
    assertEquals(1, a.getShading());
    assertEquals(1, a.getShape());
    
    assertEquals(2, b.getQuantity());
    assertEquals(2, b.getColor());
    assertEquals(2, b.getShading());
    assertEquals(2, b.getShape());
    
    assertEquals(3, c.getQuantity());
    assertEquals(3, c.getColor());
    assertEquals(3, c.getShading());
    assertEquals(3, c.getShape());
  }
  
  public void testNewCardFix1() {
    Card a = new Card(4, 1, 1, 1);
    Card b = new Card(1, 4, 1, 1);
    Card c = new Card(1, 1, 4, 1);
    Card d = new Card(1, 1, 1, 4);
    
    assertEquals(2, a.getQuantity());
    assertEquals(1, a.getColor());
    assertEquals(1, a.getShading());
    assertEquals(1, a.getShape());
    
    assertEquals(1, b.getQuantity());
    assertEquals(2, b.getColor());
    assertEquals(1, b.getShading());
    assertEquals(1, b.getShape());
    
    assertEquals(1, c.getQuantity());
    assertEquals(1, c.getColor());
    assertEquals(2, c.getShading());
    assertEquals(1, c.getShape());
    
    assertEquals(1, d.getQuantity());
    assertEquals(1, d.getColor());
    assertEquals(1, d.getShading());
    assertEquals(2, d.getShape());
  }
  
  public void testNewCardFixNegative() {
    Card a = new Card(-3, 1, 1, 1);
    Card b = new Card(1, -3, 1, 1);
    Card c = new Card(1, 1, -3, 1);
    Card d = new Card(1, 1, 1, -3);
    
    assertEquals(1, a.getQuantity());
    assertEquals(1, a.getColor());
    assertEquals(1, a.getShading());
    assertEquals(1, a.getShape());
    
    assertEquals(1, b.getQuantity());
    assertEquals(1, b.getColor());
    assertEquals(1, b.getShading());
    assertEquals(1, b.getShape());
    
    assertEquals(1, c.getQuantity());
    assertEquals(1, c.getColor());
    assertEquals(1, c.getShading());
    assertEquals(1, c.getShape());
    
    assertEquals(1, d.getQuantity());
    assertEquals(1, d.getColor());
    assertEquals(1, d.getShading());
    assertEquals(1, d.getShape());
  }
  
  public void testNewCardFixAll() {
    Card a = new Card(-3, 4, 7, 6);
    
    assertEquals(1, a.getQuantity());
    assertEquals(2, a.getColor());
    assertEquals(2, a.getShading());
    assertEquals(1, a.getShape());
  }
  
  public void testNewCardisSetTrue() {
    Card a = new Card(1, 1, 1, 1);
    Card b = new Card(1, 2, 1, 1);
    Card c = new Card(1, 3, 1, 1);
    
    assertTrue(a.isSet(b, c));
  }
  
  public void testNewCardisSetFalse() {
    Card a = new Card(1, 1, 1, 1);
    Card b = new Card(2, 2, 2, 2);
    Card c = new Card(3, 3, 3, 3);
    
    assertTrue(a.isSet(b, c));
  }
  

  public void testNewCardtoString() {
    Card a = new Card(-1, 1, 1, 3);
    Card b = new Card(1, 2, 3, 2);
    Card c = new Card(2, 5, 10, -6);
    
    assertEquals("3ROS", a.toString());
    assertEquals("1GSD", b.toString());
    assertEquals("2PTO", c.toString());
  }
  
    
}
