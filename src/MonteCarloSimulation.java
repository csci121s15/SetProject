public class MonteCarloSimulation {

  public static void main(String[] args) {
    int games = 0;
    double totalSets = 0;
    double totalCards = 0;
    double avgNumSets = 0;
    double avgNumCards = 0;
    
    for(int i = 0; i < 10000; i++) {
      Game game = new Game();
      games += 1;
      
      // What is the average number of sets in a random collection of 12 cards from the deck?
      totalSets += game.numSets();
      avgNumSets = totalSets / games;

      
      while(!(game.isGameOver())) {
        game.playRound();
      }
      
      //What is the average number of cards left at the end of the game?
      totalCards += game.numCards();
      avgNumCards = totalCards / games;
    }
      
      System.out.println(avgNumSets);
      System.out.println(avgNumCards);
  }
}