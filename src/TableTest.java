import junit.framework.TestCase;


public class TableTest extends TestCase {
  public void testNumCards() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    Card c3 = new Card(3, 3, 3, 3);
    
    Table t = new Table();
    
    t.add(c1);
    t.add(c2);
    t.add(c3);
    
    assertEquals(3, t.numCards()); 
  }
  
  public void testRemoveSet() {
   Table t = new Table();
    
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    Card c3 = new Card(3, 3, 3, 3);  
    Card c4 = new Card(1, 2, 3, 1);
    
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
  
  public void testGetCard() {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    Card c3 = new Card(3, 3, 3, 3);
    
    Table t = new Table();
    
    t.add(c1);
    t.add(c2);
    t.add(c3);
    
    assertEquals("1ROO", t.getCard(0).toString());
    assertEquals("2GTD", t.getCard(1).toString());
    assertEquals("3PSS", t.getCard(2).toString());
  }
}
