import junit.framework.TestCase;

public class GameTest extends TestCase {
  
  public void testGameWithFilename(){
    Game x = new Game("testDeck.txt");
    
    assertEquals(4, x.numCards());
  }
  
  public void testGameWithManyCards(){
   Game x = new Game("testDeck2.txt");
   
   assertEquals(12, x.numCards());
  }
  
  public void testNumSets(){
   Game x = new Game("testDeck2.txt");
   
   assertEquals(8, x.numSets());
    
  }
  
  public void testGameOver(){
   Game x = new Game("testDeck.txt");
   
   assertTrue(x.isGameOver());
  }
  
  public void testGameNotOver(){
   Game x = new Game("testDeck2.txt");
   
   assertFalse(x.isGameOver());
  }
  
  public void testPlayRoundFourSet(){
   Game x = new Game("testdeck1.txt"); 
   assertEquals(12, x.numCards());
   assertEquals(4, x.numSets());
   assertEquals(false,x.isGameOver());
  }
  
  public void testPlayRoundNoSets(){
   Game x = new Game("testgamenosets.txt");
   assertEquals(12,x.numCards());
   assertEquals(0, x.numSets());
   assertEquals(true,x.isGameOver());
    
  }
  public void testPlayRound15(){
   Game x = new Game("testgame3.txt");
   assertEquals(12, x.numCards());
   assertEquals(3,x.numSets());
   assertEquals(false,x.isGameOver());
    
  }
  

}