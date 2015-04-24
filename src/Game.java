public class Game {
  private Deck d;
  private Table t;
  
  public Game() {
    d = new Deck();
    t = new Table();
    
    for (int i = 0; i < 12; i++) {
      t.add(d.getNext());
    }
  }
  
  public Game(String filename) {
    // uses a preset deck
    d = new Deck(filename);
    t = new Table();
    
    while (d.hasNext() == true) {
      t.add(d.getNext());
      
      if (t.numCards() == 12) {
        return;
      }
    }
  }
  
  public int numSets() {
    return t.numSets();
  }
  
  public int numCards() {
    return t.numCards();
  }
  
  public void playRound() {
    if (t.numSets() == 0 && d.hasNext() == true) {
      for (int i = 0; i < 3; i++) {
        if (d.hasNext() == false) {
          return;
        }
        t.add(d.getNext());
      }
      return;
    }
    
    if (t.numSets() > 0 && d.hasNext() == true) {
      for (int i = 0; i < t.numCards() - 2; i++) {
        for (int j = i + 1; j < t.numCards() - 1; j++) {
          for (int h = j + 1; h < t.numCards(); h++) {
            
            Card c1 = t.getCard(i);
            Card c2 = t.getCard(j);
            Card c3 = t.getCard(h);
            
            if (c1.isSet(c2,c3)) {
              t.removeSet(c1,c2,c3);
            }
            
            if (numCards() < 12 && d.hasNext() == true) {
              for (int e = 0; e < 3; e++) {
                t.add(d.getNext());
              }
              return;
            }
          }
        }
      }
    }
  }
  
  public boolean isGameOver() {
    if (d.hasNext() == false && t.numSets() == 0) {
      return true;
    }
    else {
      return false;
    }
  }
}