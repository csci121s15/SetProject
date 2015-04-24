public class Game {
  Table t;
  Deck d;
  
  public Game() {
    t = new Table();
    d = new Deck();
    
    for (int a = 0; a < 12; a++) {
      t.add(d.getNext());
    }
  }
  
  public Game(String filename) {
    t = new Table();
    d = new Deck(filename);
    
    while (d.hasNext()) {
      t.add(d.getNext());
      if (t.numCards() > 11) {
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
    if (t.numSets() == 0 && d.hasNext()) {
      for (int c = 0; c < 3; c++) {
        if (d.hasNext()) {
          t.add(d.getNext());
        }
        else {
          return;
        }
      }
    }
      
    if (t.numSets() != 0) {
      for (int i = 0; i < (t.numCards() - 2); i++) {
        for (int j = i + 1; j < (t.numCards() - 1); j++) {
          for (int k = j + 1; k < t.numCards(); k++) {
            if (t.getCard(k).isSet(t.getCard(i), t.getCard(j))) {
              t.removeSet(t.getCard(k), t.getCard(i), t.getCard(j));
              if (t.numCards() < 12 && d.hasNext()) {
                for (int c = 0; c < 3; c++) {
                  if (d.hasNext()) {
                    t.add(d.getNext());
                  }
                  else {
                    return;
                  }
                }
              }
              return;
            }
          }
        }
      }
    }
  }

  public boolean isGameOver() {
    if (!d.hasNext() && t.numSets() == 0) {
      return true;
    }
    
    else {
      return false;
    }
  }
}
  