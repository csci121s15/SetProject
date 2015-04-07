import junit.framework.TestCase;

public class DeckTest extends TestCase {

  public void test4cards() {
    Deck d = new Deck("4cards.dat");
    assertEquals(4, d.cards.size());
//    System.out.println(d.cards);
  }
  
  public void test0cards() {
    Deck d = new Deck("0cards.dat");
    assertEquals(0, d.cards.size());
//    System.out.println(d.cards);
  }
  
  public void testGenCards() {
    Deck d = new Deck();
    assertEquals(81, d.cards.size());
//    System.out.println(d.cards);
    
    int quantity = 0;
    int color = 0;
    int shading = 0;
    int shape = 0;
    while(d.hasNext()) {
      Card c = d.getNext();
      if(c.getQuantity() == 1) { 
         quantity++;
      }
      if(c.getColor() == 1) {
        color++;
      }
      if(c.getShading() == 1) {
        shading++;
      }
      if(c.getShape() == 1) {
        shape++;
      }
    }
    assertEquals(27, quantity);
    assertEquals(27, color);
    assertEquals(27, shading);
    assertEquals(27, shape);
  }
}
