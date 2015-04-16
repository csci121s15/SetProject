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
   public void testNumSet() {
    Table tipTop = new Table();
    Card card1 = new Card(1, 2, 1, 2);
    tipTop.add(card1);
    assertEquals(0, tipTop.numSets());
    
    Card card2 = new Card(3, 1, 3, 1);
    tipTop.add(card2);
    assertEquals(0, tipTop.numSets());
    
    Card card3 = new Card(2, 2, 2, 2);
    tipTop.add(card3);
    assertEquals(0, tipTop.numSets());
  }
  
  
  public void testNewTableThatIsEmpty() {
    Table tipTop = new Table();
    
    Card card1 = new Card(1, 2, 3, 1);
    Card card2 = new Card(2, 3, 1, 2);
    Card card3 = new Card(3, 1, 2, 3);
    
    assertEquals(null, tipTop.getCard(0));
    assertEquals(0, tipTop.numCards());
    assertEquals(tipTop.numCards(), 0);

  }
  
  public void testACardInTable() {
    Table tipTop = new Table();
    Card card = new Card(1, 2, 3, 1);
    tipTop.add(card);
    
    assertEquals(true, tipTop.getCard(0).equals(card));
    assertEquals(null, tipTop.getCard(1));
    assertEquals(null, tipTop.getCard(4));
    
    assertEquals(1, tipTop.numCards());
  }
  
  

  
  
}
