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
    for (int i=0; i < 12 && d.hasNext(); i++) {
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
    if (d.hasNext() == true && t.numSets() == 0) {
      for (int r = 0; r < 3; r++) {
        if (d.hasNext() == false)
          return;
        t.add(d.getNext());
      }
      return;
    }
    
    if (d.hasNext() == true && t.numSets() != 0) {
      for (int i = 0; i < t.numCards() - 2; i++) {
        for (int j = i + 1; j < t.numCards() - 1; j++) {
          for (int k = j + 1; k < t.numCards(); k++) {
            if (t.getCard(i).isSet(t.getCard(j), t.getCard(k)) == true) {
              t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
              for (int r = 0; t.numCards() < 12; r++) {
                if (d.hasNext() == false) {
                  return;
                }
                t.add(d.getNext());
              }
              return;
            }
          }
        }
      }
    }
    
    if (t.numCards() > 12 && t.numSets() > 0) {
      for (int i = 0; i < t.numCards() - 2; i++) {
        for (int j = i + 1; j < t.numCards() - 1; j++) {
          for (int k = j + 1; k < t.numCards(); k++) {
            if (t.getCard(i).isSet(t.getCard(j), t.getCard(k)) == true) {
              t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
                return;
            }
          }
        }
      }
    }
  
    
    if (d.hasNext() == false && t.numSets() != 0) {
      for (int i = 0; i < t.numCards() - 2; i++) {
        for (int j = i + 1; j < t.numCards() - 1; j++) {
          for (int k = j + 1; k < t.numCards(); k++) {
            if (t.getCard(i).isSet(t.getCard(j), t.getCard(k))) {
              t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
              return;
            }
          }
        }
      }
    }
    return;
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