public class MonteCarloSimulation {
  
  public static void main(String[] args) {
    
    double avgSets = 0;
    int a = 0;
    while (a <= 1000001) {
      Game g1 = new Game();
      avgSets += g1.numSets();
    }
    System.out.println("Avg # of sets is " + avgSets);
  
    double avgCards = 0;
    int b = 0;
    while (b <= 100001) {
      Game g2 = new Game();
      while(g2.isGameOver() == false) {
        g2.playRound();
      }
      avgCards += g2.numCards();
      a++;
    }
    System.out.println("Avg # of cards is " + avgCards);
  }
}
      