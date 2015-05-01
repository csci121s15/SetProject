public class MonteCarloSim
{  
  public static void main(String[] args)
  {
    double nStartSets = 0;
    double nEndingSets = 0;
    double nCards = 0;
    
    for (int i = 0; i < 1000000; i++)
    {
      Game game = new Game();
      nCards += game.numCards();
      nStartSets += game.numSets();
      
      while (!game.isGameOver())
      {
       game.playRound(); 
      }
      
      nEndingSets += game.numCards();
    }
   
    System.out.println(nStartSets/1000000);
    System.out.println(nEndingSets/1000000);
    System.out.println(nCards/1000000);
  }
}