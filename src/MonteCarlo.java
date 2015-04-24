public class MonteCarlo{
  public static void main(String[] args){
    
    // used to answer our two questions
    
    //will run a large number of independent experiments
    //then take average of experiments
    //this number is an estimate of the quantity measured
    //the more experiements run the better the estimate
    
    //first question:
    //What is the average number of sets in a random collection of 12 cards from the deck?
    //count how many sets in a group of 12 random cards from a deck
    //each experiment should use a different deck
    //to keep experiment independent
    
    //second question:
    //What is the average number of cards left at the end of the game?
    //one experiment is one game played with a random deck
    //when gameover you count the number of cards on table
    
    //use a main class
    
    
    //1st Question:
    double avgNumberOfSets = 0;
    int i = 0;
    while(i<=1000000){
      Game g = new Game();
      avgNumberOfSets += g.numSets();
      i++;   
    }
    System.out.println("The average Number of Sets in " + (i-1) + " sets of random cards is " + avgNumberOfSets/(i-1));
    
    
    //2nd question:
    double avgNumberOfCards = 0;
    int j = 0;
    while(j<=1000000){  /// this takes about 9 minutes..
      Game g2 = new Game();
      while(g2.isGameOver() == false) {
        g2.playRound();   
      }
      avgNumberOfCards += g2.numCards();
      j++;
    }
    System.out.println("The average Number of Cards left on the table at the end of a game after " + (j-1) + " games is " + avgNumberOfCards/(j-1));
    
    
  
  
  
  //end of class
  }
}