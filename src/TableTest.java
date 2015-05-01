import junit.framework.TestCase;

public class TableTest extends TestCase {
  
  public void testEmptyTable(){
   Table x = new Table();
   
   assertEquals(0, x.numCards());
   assertEquals(null, x.getCard(0));
   assertEquals(0, x.numSets());
    
  }
  
  public void testOneCard(){
   Table y = new Table();
   Card card1 = new Card (1,3,3,2);
   
   y.add(card1);
    
   assertEquals(1, y.numCards());
   assertEquals(card1, y.getCard(0));
   assertEquals(0, y.numSets());
  }
  
  public void testTwoCards(){
   Table k = new Table();
   Card card1 = new Card (1,1,1,1);
   Card card2 = new Card (2,2,2,1);
   
   k.add(card1);
   k.add(card2);
   
   assertEquals(2, k.numCards());
   assertEquals(card2, k.getCard(0));
   assertEquals(card1, k.getCard(1));
   assertEquals(0, k.numSets());
    
  }
  
  public void testManyCards(){
    Table z = new Table();
    Card c1 = new Card (1,2,2,2);
    Card c2 = new Card (1,1,1,1);
    Card c3 = new Card (1,1,1,3);
    Card c4 = new Card (1,2,3,1);
    Card c5 = new Card (1,1,1,2);
    
    z.add(c1);
    z.add(c2);
    z.add(c3);
    z.add(c4);
    z.add(c5);
    
    assertEquals(5, z.numCards());
    assertEquals(c5, z.getCard(0));
    assertEquals(c4, z.getCard(1));
    assertEquals(c3, z.getCard(2));
    assertEquals(c2, z.getCard(3));
    assertEquals(c1, z.getCard(4));
    assertEquals(1, z.numSets());
    
}
  public void testRemoveSetNotSet(){
    Table z = new Table();
    Card c1 = new Card (1,2,2,2);
    Card c2 = new Card (1,1,1,1);
    Card c3 = new Card (1,1,1,3);
   
    
    z.add(c1);
    z.add(c2);
    z.add(c3);
    z.removeSet(c1,c2,c3);
    
    assertEquals(3, z.numCards());
  }
  
  public void testRemoveSetNotOnTable(){
    Table z = new Table();
    Card c1 = new Card (1,1,1,2);
    Card c2 = new Card (1,1,1,1);
    Card c3 = new Card (1,1,1,3);
   
    
    z.add(c1);
    z.add(c2);
    z.removeSet(c1,c2,c3);
    
    assertEquals(2, z.numCards());
  }
  
  public void testRemoveSet(){
    Table z = new Table();
    Card c1 = new Card (1,1,1,2);
    Card c2 = new Card (1,1,1,1);
    Card c3 = new Card (1,1,1,3);
   
    
    z.add(c1);
    z.add(c2);
    z.add(c3);
    z.removeSet(c1,c2,c3);
    
    assertEquals(0, z.numCards());
  } 
  
  public void testRemoveSetSameOrder(){
    Table z = new Table();
    Card c1 = new Card (1,1,1,2);
    Card c4 = new Card (3,3,3,1);
    Card c2 = new Card (1,1,1,1);
    Card c5 = new Card (2,2,2,2);
    Card c3 = new Card (1,1,1,3);
   
    
    z.add(c1);
    z.add(c4);
    z.add(c2);
    z.add(c5);
    z.add(c3);
    
    z.removeSet(c1,c2,c3);
    
    assertEquals(2, z.numCards()); 
    assertEquals(c5, z.getCard(0));
    assertEquals(c4, z.getCard(1));
  }
  
  public void testNumSets(){
    Table e = new Table();
    Card c1 = new Card (1,1,1,1);
    Card c2 = new Card (1,1,1,2);
    Card c3 = new Card (1,1,1,3);
    Card c4 = new Card (1,1,2,3);
    Card c5 = new Card (2,2,2,2);
    
    e.add(c1);
    e.add(c2);
    e.add(c3);
    e.add(c4);
    e.add(c5);
    
    assertEquals(5, e.numCards());
    assertEquals(c1, e.getCard(4));
    assertEquals(c2, e.getCard(3));
    assertEquals(c3, e.getCard(2));
    assertEquals(c4, e.getCard(1));
    assertEquals(c5, e.getCard(0));
    assertEquals(1, e.numSets());
    
  }
  
  public void testNumSetsTwo(){
    Table e = new Table();
    Card c1 = new Card (1,1,1,1);
    Card c2 = new Card (1,1,1,2);
    Card c3 = new Card (1,1,1,3);
    Card c4 = new Card (1,1,2,3);
    Card c5 = new Card (2,2,2,2);
    Card c6 = new Card (2,2,2,1);
    Card c7 = new Card (2,2,2,3);
    
    e.add(c1);
    e.add(c2);
    e.add(c3);
    e.add(c4);
    e.add(c5);
    e.add(c6);
    e.add(c7);
    
    assertEquals(7, e.numCards());
    assertEquals(c1, e.getCard(6));
    assertEquals(c2, e.getCard(5));
    assertEquals(c3, e.getCard(4));
    assertEquals(c4, e.getCard(3));
    assertEquals(c5, e.getCard(2));
    assertEquals(c6, e.getCard(1));
    assertEquals(c7, e.getCard(0));
    assertEquals(2, e.numSets());
    
  }
}