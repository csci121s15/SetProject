import junit.framework.TestCase;

public class TestTable extends TestCase {
  
  public void testEmptyTable() {
    Table t = new Table();
    
    assertEquals(0, t.numCards());
    assertEquals(null, t.getCard(0));
    assertEquals(0, t.numSets());
    
  }

  public void testOneCardTable() {
    Table t = new Table();
    Card c1 = new Card(1, 1, 1, 1);
    
    t.add(c1);
    
    assertEquals(1, t.numCards());
    assertEquals(c1, t.getCard(0));
    assertEquals(0, t.numSets());
    
  }
  
  public void testTwoCardTable() {
    Table t = new Table();
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    
    t.add(c1);
    t.add(c2);
    
    assertEquals(2, t.numCards());
    assertEquals(c1, t.getCard(1));
    assertEquals(c2, t.getCard(0));
    assertEquals(0, t.numSets());
    
  }
  
  public void testOneSetCardTable() {
    Table t = new Table();
    Card c1 = new Card(1, 1, 1, 2);
    Card c2 = new Card(2, 1, 1, 1);
    Card c3 = new Card(3, 1, 1, 3);
    
    t.add(c2);
    t.add(c1);
    t.add(c3);
    
    assertEquals(3, t.numCards());
    assertEquals(c1, t.getCard(1));
    assertEquals(c2, t.getCard(2));
    assertEquals(c3, t.getCard(0));
    assertEquals(1, t.numSets());
    
  }
  
  public void testNoSetCardTable() {
    Table t = new Table();
    Card c1 = new Card(1, 2, 1, 2);
    Card c2 = new Card(2, 1, 1, 1);
    Card c3 = new Card(3, 1, 1, 3);
    
    t.add(c2);
    t.add(c1);
    t.add(c3);
    
    assertEquals(3, t.numCards());
    assertEquals(c1, t.getCard(1));
    assertEquals(c2, t.getCard(2));
    assertEquals(c3, t.getCard(0));
    assertEquals(0, t.numSets());
    
  }
  
  public void testOneSetFiveCardsCardTable() {
    Table t = new Table();
    Card c1 = new Card(1, 2, 1, 2);
    Card c2 = new Card(2, 1, 1, 1);
    Card c3 = new Card(3, 3, 1, 3);
    Card c4 = new Card(3, 2, 1, 1);
    Card c5 = new Card(2, 2, 2, 2);
    
    t.add(c1);
    t.add(c2);
    t.add(c3);
    t.add(c4);
    t.add(c5);
    
    assertEquals(5, t.numCards());
    assertEquals(c1, t.getCard(4));
    assertEquals(c2, t.getCard(3));
    assertEquals(c3, t.getCard(2));
    assertEquals(c4, t.getCard(1));
    assertEquals(c5, t.getCard(0));
    assertEquals(1, t.numSets());
    
  }
}
