public class Main {
  public static void main(String[] args) {
    //Number of games played in order to find the average, I used 100,000//
    int numGames = 100000;
    
    //Tried these as an int and a float, the float gave a more accurate number.//
    //randomCollection is the sum for the average number of sets in random collection.//
    //cardsLeft is the sum for the average number of cards left at end of game.//
    float randomCollection = 0;
    float cardsLeft = 0;
    
    //For loop in order to state how many rounds to play (100,000).//
    for (int i = 0; i < 100000; i++) {
      Game setGame = new Game();
      randomCollection += setGame.numSets();
      
      
      //need the while loop to check to make sure game is not over, that playRound can play for 100,000 games.//
      while (setGame.isGameOver() == false) {
        setGame.playRound();
      }
      
      cardsLeft += setGame.numCards();
    }
    
    //Printing out each average for the sum divided by the number of games played.//
    System.out.println("Average number of sets in a random collection of 12 cards is:" + randomCollection/100000);
    
    System.out.println("Average number of cards left at the end of the game are:" + cardsLeft/100000);
  }
}
    
  