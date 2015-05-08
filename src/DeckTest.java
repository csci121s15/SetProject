import junit.framework.TestCase;

public class DeckTest extends TestCase
{
  Deck d1 = new Deck();
  Card c1 = new Card(1,1,1,1);
  
  public void testHasNext()
  {
    assertEquals(true,d1.hasNext());
    while(d1.getNext() != null)
    {
      c1 = d1.getNext();
    }
    assertEquals(false,d1.hasNext());
  }
  public void testGetNext()
  {
    while(d1.hasNext() == true)
    {
      c1 = d1.getNext();
    }
    assertEquals(null,d1.getNext());
  }
}
