import junit.framework.TestCase;

public class TableTest extends TestCase{
  
  public void testEmpty() {
    Table tt = new Table();
    assertEquals(0, tt.numCards());
    assertEquals(null, tt.getCard(0));
    assertEquals(0, tt.numSets());
  }
  
  public void testCards() {
    Table tt = new Table();
    Card card1 = new Card(2, 1, 3, 2);
    tt.add(card1);
    
    Card card2 = new Card(3, 2, 3, 1);
    tt.add(card2);
    
    Card card3 = new Card(1, 2, 2, 3);
    tt.add(card3);
    
    assertEquals(3, tt.numCards());
    assertTrue(tt.getCard(0).equals(card3));
    assertTrue(tt.getCard(1).equals(card2));
    assertTrue(tt.getCard(2).equals(card1)); 
  }
}