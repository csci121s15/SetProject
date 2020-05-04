import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class DeckTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testOneCard() {
    Deck d = new Deck("oneCard.dat");
    
      assertTrue(d.hasNext());
      assertEquals("1GSO", d.getNext().toString());
      assertFalse(d.hasNext());
  }
  public void testOneSet() {
    Deck d = new Deck("oneSet.dat");
    
    assertTrue(d.hasNext());
    assertEquals("1ROO", d.getNext().toString());
    assertTrue(d.hasNext());
    assertEquals("1GTD", d.getNext().toString());
    assertTrue(d.hasNext());
    assertEquals("1PSS", d.getNext().toString());
    assertFalse(d.hasNext());
  }
  public void testNoSet() {
    Deck d = new Deck("noSet.dat");
    
    assertTrue(d.hasNext());
    assertEquals("1GSO", d.getNext().toString());
    assertTrue(d.hasNext());
    assertEquals("1GOO", d.getNext().toString());
    assertTrue(d.hasNext());
    assertEquals("1ROO", d.getNext().toString());
    assertFalse(d.hasNext());
  }
  public void testSixCardsWithOneSet() {
    Deck d = new Deck("sixCards.dat");
    
    assertTrue(d.hasNext());
    assertEquals("1ROO", d.getNext().toString());
    assertTrue(d.hasNext());
    assertEquals("2GTD", d.getNext().toString());
    assertTrue(d.hasNext());
    assertEquals("3PSS", d.getNext().toString());
    assertTrue(d.hasNext());
    assertEquals("1GSO", d.getNext().toString());
    assertTrue(d.hasNext());
    assertEquals("1RTD", d.getNext().toString());
    assertTrue(d.hasNext());
    assertEquals("3GOD", d.getNext().toString());
    assertFalse(d.hasNext());
  }
}
