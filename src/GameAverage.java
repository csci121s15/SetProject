public class GameAverage
{  
  public static void main(String[] args)
  {
    double beginningSets = 0;
    double endingCards = 0;
    double beginningCards = 0;
    
    for (int i = 0; i < 1000000; i++)
    {
      Game game = new Game();
      beginningCards += game.numCards();
      beginningSets += game.numSets();
      
      while (!game.isGameOver())
      {
       game.playRound(); 
      }
      
      endingCards += game.numCards();
    }
   
    System.out.println(beginningCards/1000000);
    System.out.println(beginningSets/1000000);
    System.out.println(endingCards/1000000);
  }
}