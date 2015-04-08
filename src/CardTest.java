import junit.framework.TestCase;

public class CardTest extends TestCase {
  
  public void testCard() {
    Card c1 = new Card(3,2,3,2);
    assertEquals("3GSD",c1.toString());
    
    Card c2 = new Card(1,3,1,3);
    assertEquals("1POS",c2.toString());
    
    Card c3 = new Card(2,1,2,1);
    assertEquals("2RTO",c3.toString());  
  }
  
  public void testTrueSet() {
    Card c1 = new Card(1,2,3,2);
    Card c2 = new Card(2,3,1,3);
    Card c3 = new Card(3,1,2,1);
    assertEquals(true, c1.isSet(c2, c3));
 }
  
  public void testFalseSet() {
    Card c1 = new Card(1,3,3,1);
    Card c2 = new Card(3,3,3,3);
    Card c3 = new Card(3,2,1,3);
    assertEquals(false, c1.isSet(c2, c3));
  }
}