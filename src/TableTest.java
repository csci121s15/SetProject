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
    public void testAddCards() {
    Table t = new Table();
    
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 2, 1, 1);
    Card c3 = new Card(1, 3, 1, 1);
    
    t.add(c1);
    assertEquals(1, t.numCards());
    t.add(c2);
    assertEquals(2, t.numCards());
    t.add(c3);
    assertEquals(3, t.numCards());
  }
    public void testRemoveOneSet() {
   Table t = new Table();
    
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 2, 1, 1);
    Card c3 = new Card(1, 3, 1, 1);  
    Card c4 = new Card(3, 1, 3, 1);
    
    t.add(c1);
    t.add(c2);
    t.add(c3);
    t.add(c4);
   
    assertEquals(1, t.numSets());
    assertEquals(4, t.numCards());
    assertTrue(c1.isSet(c2, c3));
    
    t.removeSet(c1, c2, c3); 
    }
    public void testGetCard() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    Card c3 = new Card(3, 3, 3, 3);
    
    Table z = new Table();
    
    z.add(c1);
    z.add(c2);
    z.add(c3);
    
    assertEquals("3PSS", z.getCard(0).toString());
    assertEquals("2GTD", z.getCard(1).toString());
    assertEquals("1ROO", z.getCard(2).toString());
  }
}
