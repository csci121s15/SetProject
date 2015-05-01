import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class GameTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void test1RoundGame() {
    Game g = new Game();
    
    assertEquals(g.numCards(), 12);
    g.playRound();
    assertEquals(g.numCards(), 12);
  }
  
  public void testWith81CardsDeck(){
    Game g = new Game("81cards.txt");
    
    assertEquals(g.numCards(), 12);
    assertEquals(g.numSets(), 13);
    g.playRound();
    assertEquals(g.numCards(), 12);
    assertEquals(g.isGameOver(), false);
  }
  
  public void test3cards1set(){
    Game g = new Game("3cards.txt");
    
    assertEquals(g.numCards(), 3);
    g.playRound();
    assertEquals(g.numCards(), 0);
  }
  
  public void testSommerDecks(){
    Game g = new Game("3cards0setsMilestone.dat");
    
    assertEquals(g.numCards(), 3);
    assertEquals(g.numSets(), 0);
    g.playRound();
    assertEquals(g.numCards(), 3);
    assertEquals(g.isGameOver(), true);
    
    Game g1 = new Game("3cards1setMilestone.dat");
    
    assertEquals(g1.numCards(), 3);
    assertEquals(g1.numSets(), 1);
    g1.playRound();
    assertEquals(g1.numCards(), 0);
    assertEquals(g1.isGameOver(), true);
    
    Game g2 = new Game("12cards0setsMilestone.dat");
    
    assertEquals(g2.numCards(), 12);
    assertEquals(g2.numSets(), 0);
    g2.playRound();
    assertEquals(g2.numCards(), 12);
    assertEquals(g2.isGameOver(), true);
    
    Game g3 = new Game("12cards14setsMilestone.dat");
    
    assertEquals(g3.numCards(), 12);
    assertEquals(g3.numSets(), 14);
    g3.playRound();
    assertEquals(g3.numCards(), 9);
    assertEquals(g3.isGameOver(), false);
    assertEquals(g3.numCards(), 9);
    assertEquals(g3.numSets(), 8);
    g3.playRound();
    assertEquals(g3.numCards(), 6);
    assertEquals(g3.isGameOver(), false);
    assertEquals(g3.numSets(), 1);
    assertEquals(g3.isGameOver(), false);
    g3.playRound();
    assertEquals(g3.numCards(), 3);
    assertEquals(g3.numSets(), 0);
    assertEquals(g3.isGameOver(), true);
    assertEquals(g3.numCards(), 3);

    Game g4 = new Game("emptyDeckMilestone.dat");
    
    assertEquals(g4.numCards(), 0);
    assertEquals(g4.numSets(), 0);
    g4.playRound();
    assertEquals(g4.numCards(), 0);
    assertEquals(g4.isGameOver(), true);
    
    Game g5 = new Game("deckMilestone.dat");
    
    assertEquals(g5.numCards(), 3);
    assertEquals(g5.numSets(), 1);
    g5.playRound();
    assertEquals(g5.numCards(), 0);
    assertEquals(g5.isGameOver(), true);
    
  }
  
  

  
}
