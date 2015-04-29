public class SetExperiment {
  public static void main(String[] args) {
    double cardSum = 0;
    double setSum = 0;
    
    for(int i = 0; i < 1000; i++) {
      Game g = new Game();
      
      while(g.isGameOver() == false) {
        g.playRound();
      }
      
      setSum += g.numCards();
     }
    System.out.println("Average number of cards at the end: " + setSum / 1000);
    
  for(int j = 0; j < 1000; j++) {
    
    Table t = new Table();
    Deck d = new Deck();
    
    for(int k = 0; k < 12; k++) { 
      t.add(d.getNext());
    }
    
    cardSum += t.numSets();
  }
System.out.println("Average number of sets in 12 random cards: " + cardSum / 1000);
  }
}
      