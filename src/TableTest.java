import junit.framework.TestCase;
public class TableTest extends TestCase {
  
  public void testNumCards() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 2, 2);
    Card c3 = new Card(1, 2, 3, 1);
    
    Table t = new Table();
    
    t.add(c1);
    t.add(c2);
    t.add(c3);
    
    assertEquals(3, t.numCards());
  }
  
  public void testGetCard() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 2, 2);
    Card c3 = new Card(1, 2, 3, 1);
    
    Table t = new Table();
    
    t.add(c1);
    t.add(c2);
    t.add(c3);
    
    assertEquals("1GSO", t.getCard(0).toString());
    assertEquals("1RTD", t.getCard(1).toString());
    assertEquals("1ROO", t.getCard(2).toString());
  }
  
  public void testRemoveSet() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    Card c3 = new Card(3, 3, 3, 3);
    Card c4 = new Card(3, 2, 1, 1);
    
    Table t = new Table();
    
    t.add(c1);
    t.add(c2);
    t.add(c3);
    t.add(c4);
    
    t.removeSet(c1, c2, c3);
    
    assertEquals(1, t.numCards());
  }
  
  public void testNumSets() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    Card c3 = new Card(3, 3, 3, 3);
    Card c4 = new Card(3, 2, 1, 1);
    
    Table t = new Table();
    
    t.add(c1);
    t.add(c2);
    t.add(c3);
    t.add(c4);
    
    assertEquals(3, t.numSets());
  }
 }