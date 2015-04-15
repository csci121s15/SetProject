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

  public void testEmptyTable() {
    Table table = new Table();
    assertEquals(0, table.numCards());
    assertEquals(null, table.getCard(0));
  }

  public void testSingleNode() {
    Table table = new Table();
    Card card = new Card(2, 1, 1, 3);
    table.add(card);
    assertEquals(1, table.numCards());
    assertEquals(card, table.getCard(0));
    assertTrue(table.findMatch(card));
  }
  
  public void testMultipleNodes() {
    Table table = new Table();
    Card card1 = new Card(2, 1, 1, 3);
    Card card2 = new Card(1, 3, 1, 2);
    Card card3 = new Card(2, 1, 3, 3);
    // Card 4 is not added to the table
    Card card4 = new Card(2, 1, 2, 3);
    table.add(card1);
    table.add(card2);
    table.add(card3);
    assertEquals(3, table.numCards());
    assertEquals(card3, table.getCard(0));
    assertTrue(table.findMatch(card3));
    assertFalse(table.findMatch(card4));
  }
  
  public void testRemoveSet() {    
    Table table = new Table();
    Card card1 = new Card(2, 1, 1, 3);
    Card card2 = new Card(1, 3, 2, 2);
    Card card3 = new Card(3, 2, 3, 1);
    Card card4 = new Card(2, 2, 1, 3);
    Card card5 = new Card(1, 1, 3, 3);
    // Card 6 is not added to the table
    Card card6 = new Card(2, 1, 2, 3);
    table.add(card1);
    table.add(card2);
    table.add(card3);
    table.add(card4);
    table.add(card5);
    //assertEquals(card4, table.findPrev(card3));
    table.removeSet(card1, card2, card3);
    assertEquals(2, table.numCards());
  }

  // Card starting at beginning of list
  public void testRemoveSet2() {    
    Table table = new Table();
    Card card1 = new Card(1, 3, 2, 2);
    Card card2 = new Card(3, 2, 3, 1);
    Card card3 = new Card(2, 2, 1, 3);
    Card card4 = new Card(1, 1, 3, 3);
    Card card5 = new Card(2, 1, 1, 3);
    // Card 6 is not added to the table
    Card card6 = new Card(2, 1, 2, 3);
    table.add(card1);
    table.add(card2);
    table.add(card3);
    table.add(card4);
    table.add(card5);
    //assertEquals(card4, table.findPrev(card3));
    table.removeSet(card1, card2, card5);
    assertEquals(2, table.numCards());
  }
  
  // Assuming sets are not removed
  public void testnumSets() {    
    Table table = new Table();
    Card card1 = new Card(1, 1, 1, 1);
    Card card2 = new Card(2, 2, 2, 2);
    Card card3 = new Card(3, 3, 3, 3);
    Card card4 = new Card(1, 2, 3, 1);
    Card card5 = new Card(2, 3, 1, 2);
    Card card6 = new Card(3, 1, 2, 3);
    
    table.add(card1);
    table.add(card2);
    table.add(card3);
    table.add(card4);
    table.add(card5);
    table.add(card6);
    
    assertEquals(2, table.numSets());
    
  }
}