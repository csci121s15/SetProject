public class MonteCarlo
{
  public static void main(String[] args)
  {
    float sum = 0;
    float sum2 = 0;
    for(int i = 0; i<10000; i++)
    {
      Game g = new Game();
      sum += g.numSets();
      while(g.isGameOver() == false)
      {
        g.playRound();
      }
      sum2+= g.numCards();
    }
    System.out.println("The average number of sets on the table are: " + sum/10000);
    System.out.print("The average number of cards at the end of the game are: " + sum2/10000);
  }
}