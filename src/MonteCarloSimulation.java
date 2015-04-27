public class MonteCarloSimulation {
  public static void main(String[] args) {
    int numGames = 0;
    float averageRounds = 0;
    int numRounds = 0;
    int gameRuns = 100000;
    
    for (int i = 0; i < gameRuns; i++) {
      Game g = new Game();
      
      while (!g.isGameOver()) {
        g.playRound();
        numRounds += 1;
      }
      numGames += 1;
    }
    averageRounds = numRounds / numGames;
    System.out.println("The average number of rounds per Set game: " + averageRounds);
  }
}