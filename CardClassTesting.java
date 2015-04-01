import junit.framework.TestCase;

public class CardClassTesting extends TestCase {  

  public void testIsSet() {
    Card A = new Card(2,1,1,1);
    Card B = new Card(2,1,1,1);
    Card C = new Card(4,1,1,1);
    Card D = new Card(1,1,4,1);
    Card E = new Card(5,4,4,4);
    
    assertEquals(true, A.isSet(A,B));
    assertEquals(false, A.isSet(C,D));
    assertEquals(false, B.isSet(A,C));
    assertEquals(false, E.isSet(D,B));
  }
  
  public void testValues() {
    Card A = new Card(2,1,1,1);
    Card B = new Card(-2,-3,7,1);
  
    assertEquals(3, A.getQuantity());
    assertEquals(2, A.getColor());
    assertEquals(2, A.getShading());
    assertEquals(2, A.getShape());
    
    assertEquals(2, B.getQuantity());
    assertEquals(1, B.getColor());
    assertEquals(2, B.getShading());
    assertEquals(2, B.getShape());
  }
  
  public void testToString() {
    Card A = new Card(9,-3,8,2);
    
    assertEquals("1RSS", A.toString());
  }
}
