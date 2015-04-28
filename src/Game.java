public class Game {
  Table t;
  Deck d;
  
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
      boolean setFound = false;
      
      for (int i = 0; i < t.numCards() - 2; i++) {
           if (setFound) {
              break;
        }
        for (int j = i + 1; j < t.numCards() - 1; j++) {  
            if (setFound) {
              break;
        }
          for (int k = j + 1; k < t.numCards(); k ++) { 
            if (setFound) {
              break;
            }
           
            if (t.getCard(i).isSet(t.getCard(j), t.getCard(k))){  
            t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
            setFound = true;
              if(t.numCards() <= 9) {
                if (d.hasNext()) {
                  t.add(d.getNext());
                }
                if (d.hasNext()) {
                  t.add(d.getNext());
                }
                if (d.hasNext()) {
                  t.add(d.getNext());
                  }
                }
              }
           }
        }
      }
      if (t.numSets() == 0) {
         if (d.hasNext()) {
                  t.add(d.getNext());
                }
         if (d.hasNext()) {
                  t.add(d.getNext());
                }
         if (d.hasNext()) {
                  t.add(d.getNext());
                }
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