public class MCSim{
  public static void main (String[] args){
    
    double setCount = 0;
    double cardCount = 0;
    int sim = 100001;
    
    for (int i = 0; i <= sim; i++){
      
      Game game1 = new Game();
      setCount += game1.numSets();
      
      while (game1.isGameOver()){
        game1.playRound();
      }
    }
    
    System.out.println("The average number of sets from 100,000 random sets of cards is " + setCount / sim);
    
    for (int i = 0; i <= sim; i++){
      
      Game game2 = new Game();
      cardCount += game2.numCards();
      
      while (game2.isGameOver()){
        game2.playRound();
      }
    }   
    
    System.out.println("The average number of cards on the table when the game ends is " + cardCount / sim);
  }
}