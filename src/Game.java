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
  
  public Game(String cardGame) {
    
    t = new Table();
    d = new Deck(cardGame);
    for (int i = 0; i < 12; i++) {
      if(d.hasNext() == true) {
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
  
  public void playRound() {
    //worked with Hailey Kester on the playRound in lab
    
    if (t.numSets() == 0 && d.hasNext() == true) {
      for (int i = 0; i < 3; i++) {
        if(d.hasNext() == true) {
          t.add(d.getNext());
        }
      }
      return;
    }
    
    if (t.numSets() > 0) {
      for (int a = 0; a < t.numCards() - 2; a++) {
        for (int b = a + 1; b < t.numCards() - 1; b++) {
          for (int c = b + 1; c < t.numCards(); c++) {
            Card c1 = t.getCard(a);
            Card c2 = t.getCard(b);
            Card c3 = t.getCard(c);
            
            if (c1.isSet(c2,c3)) {
              t.removeSet(c1, c2, c3);
              if (t.numCards() < 12 && d.hasNext()) { 
                for (int i = 0; i < 3; i++) {
                  if(d.hasNext() == true) {
                    t.add(d.getNext());
                  }
                  return;
                }
              }
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

  

      