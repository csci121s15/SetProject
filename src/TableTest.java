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
  public void testTableSet() {
    Table tab = new Table();
    
    Card c1 = new Card(1,1,1,1);
    Card c2 = new Card(1,1,1,1);
    Card c3 = new Card(1,1,1,1);
    
    tab.add(c1);
    tab.add(c2);
    tab.add(c3);
    
    assertEquals(3, tab.numCards());
    tab.removeSet(c1,c2,c3);
  }
  
  public void testNumSet(){
    Table tab = new Table();
    Card c1 = new Card(2,1,1,1);
    Card c2 = new Card(3,1,1,1);
    Card c3 = new Card(3,1,1,1);
    
    tab.add(c1);
    tab.add(c2);
    tab.add(c3);
    
    assertEquals(0, tab.numSets());
  }
  
}
