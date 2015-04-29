public class MonteCarloSim
{  
  public static void main(String[] args)
  {
    double nBeginingSets = 0;
    double nEndSets = 0;
    double nBeginCards = 0;
    
    for (int i = 0; i < 1000000; i++)
    {
      Game game = new Game();
      nBeginCards += game.numCards();
      nBeginingSets += game.numSets();
      
      while (!game.isGameOver())
      {
       game.playRound(); 
      }
      
      nEndSets += game.numCards();
    }
   
    System.out.println(nBeginingSets/1000000);
    System.out.println(nEndSets/1000000);
    System.out.println(nBeginCards/1000000);
  }
}