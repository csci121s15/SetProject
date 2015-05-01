import junit.framework.TestCase;

public class TableTest extends TestCase {
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
  
 public void testOneSet() {
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
    
    assertEquals(c3, t.getCard(0));
    assertEquals(c2, t.getCard(1));
    assertEquals(c1, t.getCard(2));
    
    assertEquals("1ROO", t.getCard(2).toString());
    
    assertEquals(t.numSets(), 1);
    
    assertTrue(c1.isSet(c2, c3));
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
    assertEquals(1, t.numCards());
 }
   
}
