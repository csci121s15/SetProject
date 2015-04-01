import junit.framework.TestCase;
public class CardTest extends TestCase {
  public void testGetters() {
    Card c1 = new Card(6, 5, 4, -3);
    
    assertEquals(1, c1.getQuantity());
    assertEquals(3, c1.getColor());
    assertEquals(2, c1.getShading());
    assertEquals(1, c1.getShape());
  }
  
  public void testEquals() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 1, 1);
    
    assertEquals(c1, c2);
  }
  
  public void testSameQuantities() {
    Card c1 = new Card(15, 32, 105, 21);
    Card c2 = new Card(30, 16, 27, 31);
    Card c3 = new Card(45, 20, 23, 34);
    
    assertEquals(true, c1.isSet(c2, c3));
  }
  
  public void testSameColors() {
    Card c1 = new Card(1, 3, 1, 2);
    Card c2 = new Card(2, 3, 2, 3);
    Card c3 = new Card(2, 3, 2, 3);
    
    assertEquals(true, c1.isSet(c2, c3));
  }
  
  public void testSameShading() {
    Card c1 = new Card(1, 3, 1, 2);
    Card c2 = new Card(2, 2, 1, 3);
    Card c3 = new Card(2, 2, 1, 3);
    
    assertEquals(true, c1.isSet(c2, c3));
  }
  
  public void testSameShape() {
    Card c1 = new Card(1, 3, 1, 2);
    Card c2 = new Card(2, 2, 3, 2);
    Card c3 = new Card(2, 2, 3, 2);
    
    assertEquals(true, c1.isSet(c2, c3));
  }
  
  public void testAllDiffQuantities() {
    Card c1 = new Card(1, 3, 1, 2);
    Card c2 = new Card(2, 2, 2, 3);
    Card c3 = new Card(3, 2, 2, 3);
    
    assertEquals(true, c1.isSet(c2, c3));
  }
  
  public void testAllDiffColors() {
    Card c1 = new Card(1, 3, 1, 2);
    Card c2 = new Card(2, 2, 2, 3);
    Card c3 = new Card(2, 1, 2, 3);
    
    assertEquals(true, c1.isSet(c2, c3));
   }
  
  public void testAllDiffShading() {
    Card c1 = new Card(1, 3, 1, 2);
    Card c2 = new Card(2, 2, 2, 3);
    Card c3 = new Card(2, 2, 3, 3);
    
    assertEquals(true, c1.isSet(c2, c3));
   }
  
  public void testAllDiffShape() {
    Card c1 = new Card(1, 3, 1, 2);
    Card c2 = new Card(2, 2, 3, 1);
    Card c3 = new Card(2, 2, 3, 3);
    
    assertEquals(true, c1.isSet(c2, c3));
   }
  
  public void testNotASet() {
    Card c1 = new Card(15, 3, 1, 2);
    Card c2 = new Card(15, 2, 3, 2);
    Card c3 = new Card(23, 2, 3, 3);
    
    assertEquals(false, c1.isSet(c2, c3));
  }
  
  public void testTwoSameAtts() {
    Card c1 = new Card(2, 3, 1, 2);
    Card c2 = new Card(2, 3, 3, 2);
    Card c3 = new Card(2, 3, 3, 3);
    
    assertEquals(false, c1.isSet(c2, c3));
  }
  
  public void testThreeSameAtts() {
    Card c1 = new Card(12, 90, 21, 25);
    Card c2 = new Card(24, 60, 15, 22);
    Card c3 = new Card(30, 30, 18, 31);
    
    assertEquals(false, c1.isSet(c2, c3));
  }
  
  public void testAnotherNonSet() {
    Card c1 = new Card(6, 1, 1, 2);
    Card c2 = new Card(9, 2, 3, 2);
    Card c3 = new Card(22, 2, 3, 3);
    
    assertEquals(false, c1.isSet(c2, c3));
  }
  
  public void testToString() {
    Card c1 = new Card(6, 1, 1, 2);
    
    assertEquals("1ROD", c1.toString());
  }
  
  public void testAnotherToString() {
    Card c1 = new Card(18, 14, 90, 26);
    
    assertEquals("1POS", c1.toString());
  }
}

  