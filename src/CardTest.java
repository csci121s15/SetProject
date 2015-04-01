import junit.framework.TestCase;


public class CardTest extends TestCase {

  public void testNewCard() {
    Card z1 = new Card( 1, 2, 3, 3);
    
    assertEquals(1, z1.getQuantity());
    assertEquals(2, z1.getColor());
    assertEquals(3, z1.getShading());
    assertEquals(3, z1.getShape());
  }
  public void testTwoCards() {
    Card z1 = new Card(1,1,1,1);
    Card z2 = new Card(1,1,1,1);
    
    assertEquals(z1, z2); 
  }
  public void testSameColor() {
    Card z1 = new Card(6, 2, 3, 3);
    Card z2 = new Card(5, 2, 4, 2);
    Card z3 = new Card(4, 2, 3, 1);
    
    assertEquals(false, z1.isSet(z2,z3));
  }
  public void testSameShape() {
    Card z1 = new Card(1, 2, 3, 3);
    Card z2 = new Card(2, 2, 3, 3);
    Card z3 = new Card(3, 2, 3, 3);
    
    assertEquals(true, z1.isSet(z2,z3));
  }
  public void testSameShading() {
    Card z1 = new Card(12, 3, 3, 3);
    Card z2 = new Card(12, 3, 3, 2);
    Card z3 = new Card(12, 3, 3, 1);
    
    assertEquals(true, z1.isSet(z2,z3));
  }
  public void testNegativeValue() {
    Card z1 = new Card(6, 2, 3, -34);
    
    assertEquals(1, z1.getQuantity());
    assertEquals(2, z1.getColor());
    assertEquals(3, z1.getShading());
    assertEquals(3, z1.getShape());
  }
  public void testtoString() {
    Card z1 = new Card(2, 2, 2, 2);
    
    assertEquals("2GTD", z1.toString());
  }
}
