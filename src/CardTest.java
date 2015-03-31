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
  public void testCardSet() {
    Card c1 = new Card(3,4,2,4);
    Card c2 = new Card(2,-4,2,1);
    Card c3 = new Card(1,1,2,5);
    
    assertTrue(c1.isSet(c2, c3));
    assertEquals("3GTD",c1.toString());
    assertEquals("2PTV",c2.toString());
    assertEquals("1RTQ",c3.toString());
  }
  
}
