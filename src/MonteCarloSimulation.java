public class MonteCarloSimulation {
  public static void main(String[] args) {
    int numRounds = 0;
    float avgNumRounds;
    float avgCardsRemain;
    float avgNumSets;
    int gameRuns = 100000;
    long numSets = 0;
    int numCardsRemain = 0;

    for (int i = 0; i < gameRuns; i++) {
      Game g = new Game();
      
      while (!g.isGameOver()) {
        g.playRound();
        numRounds += 1;
      }
      numCardsRemain += g.numCards();
    }
    
    for (int j = 0; j < gameRuns; j++) {
      Game g = new Game();
      
      g.playRound();
      
      numSets += g.numSets();
      
    }
    avgCardsRemain = numCardsRemain / gameRuns;
    avgNumSets = (float) numSets / gameRuns;
    avgNumRounds = numRounds / gameRuns;
    System.out.println("The average number of rounds per Set game: " + avgNumRounds);
    System.out.println("The average number of cards remaining per Set game: " + avgCardsRemain);
    System.out.println("The average number of sets per table dealt: " + avgNumSets);
  }
}