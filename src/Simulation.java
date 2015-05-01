public class Simulation {
  public static void main(String[] args) {
    
    int numSets = 0;
    int numEndingCards = 0;
    int numGames = 0;
    
    while (numGames < 1000001) {
      
      Game game = new Game();
      numSets += game.numSets();
      while(game.isGameOver() == false) {
        game.playRound();
      }
      numEndingCards += game.numCards();
      numGames++;
        
    }
    
    System.out.println("the average number of sets in a random collection of 12 cards is: " + numSets/numGames);
    System.out.println("The average number of cards left at the end of a game is: " + numEndingCards/numGames);
  }
}
        
          
        
        
    