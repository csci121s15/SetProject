import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TableTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testTable() {
    Table t = new Table();
    Card c1 = new Card(1,1,1,1);
    Card c2 = new Card(2,2,2,2);
    Card c3 = new Card(3,3,3,3);
    assertEquals(t.numCards(), 0);
    t.add(c1);
    assertEquals(t.numCards(), 1);
    t.add(c2);
    assertEquals(t.numCards(), 2);
    t.add(c3);
    assertEquals(t.numCards(), 3);
   
    assertEquals(t.getCard(0), c3);
    assertEquals(t.getCard(1), c2);
    assertEquals(t.getCard(2), c1);
    assertEquals(t.numSets(), 1);
    
    Card c4 = new Card(4,4,4,4);
    Card c5 = new Card(5,5,5,5);
    Card c6 = new Card(6,6,6,6);
    t.add(c4);
    t.add(c5);
    t.add(c6);
    
    assertEquals(c4.isSet(c5,c6), true);
    assertEquals(t.numCards(), 6);
    assertEquals(t.numSets(), 8);
    
    assertEquals(t.getCard(0), c1);
    
    
    t.removeSet(c1,c2,c3);
    
    assertEquals(t.numCards(), 3);
    
  }
  
}
