public class Game {
  private Table t;
  private Deck d;
  
  public Game() {
    d = new Deck();
    t = new Table();
    
    for (int i = 0; i < 12; i++) {
      t.add(d.getNext());
    }
  }
  
  public Game(String filename) {
    d = new Deck(filename);
    t = new Table();
    
    for (int i = 0; i <= 12; i++) {
      if (d.hasNext() == true) {
        t.add(d.getNext());
      }
      
      if (t.numCards() == 12) {
        return;
      }
    }
  }
  
  public void playRound() {
    boolean foundSet = false;
    if(t.numSets() == 0 && d.hasNext() != false) {
      for (int i = 0; i < 3; i++) {
        t.add(d.getNext());
      }
      return;
    }
    for (int i = 0; i < numCards() - 2; i++) {
      if (foundSet) 
        break;
      for (int j = i + 1; j < numCards() - 1; j++) {
        if (foundSet)
          break;
        for (int k = j + 1; k < numCards(); k++) {
          Card c1 = t.getCard(i);
          Card c2 = t.getCard(j);
          Card c3 = t.getCard(k);
          
          if (c1.isSet(c2, c3)) {
            t.removeSet(c1, c2, c3);
            foundSet = true;
            break;
          }
        }
      }
    }
    if(t.numCards() < 12 && d.hasNext() == true) {
      for (int l = 0; l < 3; l++) {
        if (d.hasNext() == true) 
          t.add(d.getNext());
      }
    }
  }
  
  
  
  
  public int numSets() {
    return t.numSets();
  }
  
  public int numCards() {
    return t.numCards();
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
