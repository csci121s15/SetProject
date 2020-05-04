public class GameAverage {
  public static void main(String[] args) {
    
    float setSum = 0;
    float cardSum = 0;
    
    for (int i = 0; i < 1000000; i++) {
      Game g = new Game();
      setSum += g.numSets();
      
      while (g.isGameOver() == false) {
        g.playRound();
      }
      cardSum += g.numCards();
    }
    System.out.println ("Average number of sets from 12 cards: " + setSum/1000000);
    System.out.println ("Average number of remaining cards at the end of a game: " + cardSum/1000000);
  }
}