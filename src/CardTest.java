import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class CardTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testAllOnes() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 1, 1);
    
    assertEquals(c1, c2);
  }
  
  public void testThreeCards() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 1, 1);
    Card c3 = new Card(1, 1, 1, 1);
    
    assertEquals(c1, c2);
    assertEquals(c1, c3);
    assertEquals(c2, c3);
  }
  public void testIsSet() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 1, 1);
    Card c3 = new Card(1, 1, 1, 1);
    
    assertTrue(c1.isSet(c2,c3));
  }
  public void testNotSet() {
    Card c1 = new Card(1, 2, 3, 1);
    Card c2 = new Card(2, 3, 3, 1);
    Card c3 = new Card(2, 3, 3, 3);
    
    assertFalse(c1.isSet(c2,c3));
  }
  public void testToString() {
    Card c1 = new Card(1, 2, 3, 1);
    
    assertEquals("1GSO", c1.toString());
  }
  public void testInvalidNumbers() {
    Card c1 = new Card(8, 7, 6, 4);
    
    assertEquals("3GOD", c1.toString());
  }
  public void testNegativeNumbers() {
    Card c1 = new Card(-8, -7, -6, -4);
    
    assertEquals("2POS", c1.toString());
  }
  public void testNegativeAndPositiveNumbers() {
    Card c1 = new Card(-8, 3, -6, 4);
    
    assertEquals("2POD", c1.toString());
  }
}
