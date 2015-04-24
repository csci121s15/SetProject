public class Game {
  private Table t;
  private Deck d;
  
  public Game() {
    Deck d = new Deck();
    Table t = new Table();
    
    for (int i = 0; i < 12; i++) {
      t.add(d.getNext());
    }
  }
  
  public Game(String filename) {
    Deck d = new Deck(filename);
    Table t = new Table();
    
    for (int i = 0; i <= 12; i++) {
      t.add(d.getNext());
      
      if (t.numCards() == 12) {
        return;
      }
    }
  }
  
    public void playRound() {
    if(t.numSets() == 0 && d.hasNext() != false) {
        for (int i = 0; i < 3; i++) {
          t.add(d.getNext());
          return;
        }
        for (int i = 0; i < numCards() - 2; i++) {
          for (int j = i + 1; i < numCards() - 1; j++) {
            for (int k = j + 1; j < numCards(); k++) {
              Card c1 = t.getCard(i);
              Card c2 = t.getCard(j);
              Card c3 = t.getCard(k);
              
              if (t.getCard(i).isSet(t.getCard(j), t.getCard(k))) {
                t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
              }
              if(t.numCards() < 9) {
                for (int l = 0; l < 3; l++) {
                  t.add(d.getNext());
                }
                return;
              }
            }
          }
        }
    
        if (t.numSets() == 0) {
          for (int m = 0; m < 3; m++) {
            t.add(d.getNext());
          }
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