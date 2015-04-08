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
  public void testEmptyTable()
  {
    Table table = new Table();

    assertEquals(null, table.getCard(0));
    assertEquals(0, table.numCards());
  }
  
  public void testTableOne()
  {
   Table table = new Table();
   Card card = new Card(1, 1, 1, 1);
   table.add(card);
   
   assertEquals(true, table.getCard(0).equals(card));
   assertEquals(1, table.numCards());
   assertEquals(null, table.getCard(1));
   assertEquals(null, table.getCard(4));
  }
  
  public void testTableTwoCards()
  {
    Table table = new Table();
    Card card1 = new Card(1, 1, 1, 1);
    Card card2 = new Card(1, 1, 1, 2);
    table.add(card1);
    table.add(card2);
    
    assertEquals(true, table.getCard(0).equals(card2));
    assertEquals(true, table.getCard(1).equals(card1));
    assertEquals(null, table.getCard(2));
    assertEquals(null, table.getCard(33));
  }
  
}
