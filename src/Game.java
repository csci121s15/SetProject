public class Game {
  Table t = new Table();
  Deck d = new Deck();
  
  public Game() {
    for (int i = 0; i < 12; i++) {
      t.add(d.getNext());
    }
  }
  
  public Game(String filename) {
    d = new Deck(filename);
    while(d.hasNext() && t.numCards() != 12) {
      t.add(d.getNext());
    }
  }
  
  public int numSets() {
    return t.numSets();
  }
  
  public int numCards() {
    return t.numCards();
  }
  
  public void playRound() {
    
    
    
      for (int i = 0; i < t.numCards(); i++) {  
      
        for (int j = i + 1; j < t.numCards(); j++) {   
        
          for (int k = j + 1; k < t.numCards(); k ++) { 
            while (t.numSets() == 1 ){
          
            if (t.getCard(i).isSet(t.getCard(j), t.getCard(k))) {
            
              t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
              if(t.numCards() <= 9) {
                t.add(d.getNext());
                t.add(d.getNext());
                t.add(d.getNext());
                }
              }
            }
          }
        }
      }
    
    if (t.numSets() == 0) {
      t.add(d.getNext());
      t.add(d.getNext());
      t.add(d.getNext());
    }
 }
  
  public boolean isGameOver() {
    if (t.numSets() == 0 && d.hasNext() == false) {
    return true;
    }
    
    else {
      return false;
    }
  }
}