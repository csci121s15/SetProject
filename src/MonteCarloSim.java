public class MonteCarloSim
{
  public static void main(String[] args)
  {
    int numGames = 10000;
    double setsAtStart = 0.0;
    double cardsLeft = 0;
    
    for(int i=0; i<numGames; i++)
    {
      Game g = new Game();
      setsAtStart += g.numSets();
      while (g.isGameOver() == false)
      {
        g.playRound();
      }
      cardsLeft += g.numCards();
    }
    
    System.out.println("Average Sets in One Round: " + (setsAtStart/numGames));
    System.out.println("Average Cards Left after One Game: " + (cardsLeft/numGames));
  }
}
