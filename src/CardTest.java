import junit.framework.TestCase;

pubic class CardTest extends TestCase{
  
  public void testIsSet() {
    Card c1 = new Card(1, 2, 1, 3);
    Card c2 = new Card(2, 1, 3, 2);
    Card c3 = new Card(3, 3, 2, 1);
    assertEquals(true, c1.isSet(c2, c3));
  }
  
  public void testNotSet() {
    Card c1 = new Card(1, 1, 1, 3);
    Card c2 = new Card(2, 2, 3, 2);
    Card c3 = new Card(3, 2, 2, 3);
    assertEquals(false, c1.isSet(c2, c3));
  }
}