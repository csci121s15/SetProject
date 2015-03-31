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
  public void testCardWorks() {
    Card c1 = new Card(0,1,2,1);
    assertEquals("0GSD",c1.toString());
    
    Card c2 = new Card(1,2,0,2);
    assertEquals("1POS",c2.toString());
    
    Card c3 = new Card(2,0,1,0);
    assertEquals("2RTO",c3.toString());
    
 
    
    
  }
  
  public void testTruthSet() {
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
