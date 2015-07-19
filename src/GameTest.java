import junit.framework.TestCase;


public class GameTest extends TestCase {
  

  public void testGame() {
    Game game = new Game();
    assertEquals(12, game.numCards());
  }
  
  public void testGameFromFile() {
    Game game = new Game("3cards1setMilestone.dat");
    assertEquals(3, game.numCards());
    game.playRound();
    assertEquals(0, game.numCards());
  }
  
  //public void testGameFullDeck() {
    //Game game = new Game("
    
  
}
