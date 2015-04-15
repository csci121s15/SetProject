import junit.framework.TestCase;


public class TableTest extends TestCase {
  
  public void testTablewWithCards() {
    Table t = new Table();
    
    t.add(new Card(1, 1, 1, 1));
    assertEquals(1, t.numCards());
    
    t.add(new Card(2, 1, 1, 1));
    assertEquals(2, t.numCards());
    
    t.add(new Card(3, 1, 1, 1));
    assertEquals(3, t.numCards());
    
    
    t.add(new Card(2, 2, 2, 2));
    assertEquals(4, t.numCards());
    
    assertEquals(1, t.numSets());
    assertEquals(new Card(1, 1, 1, 1), t.getCard(0));
  }
 
  public void testTableWithoutCards() {
    Table t = new Table();
    assertEquals(0, t.numCards());
    assertEquals(0, t.numSets());
  }
}
