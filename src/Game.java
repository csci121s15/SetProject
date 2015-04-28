public class Game {
  Table t;
  Deck d;
  
  Game() {
    t = new Table();
    d = new Deck();   
    for(int i = 0; i < 12; i++) {
      if(d.hasNext()) {
        t.add(d.getNext());
      }
      else {
        break;
      }
    }
  }
  
  Game(String deck) {
    t = new Table();
    d = new Deck(deck);    
    for(int i = 0; i < 12; i++) {
      if(d.hasNext()) {
        t.add(d.getNext());
      }
      else {
        break;
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
    if(numSets() == 0 && d.hasNext()) {
      //System.out.println("t0");
      if(d.hasNext()) {
        t.add(d.getNext());
       }
      if(d.hasNext()) {
        t.add(d.getNext());
      }
      if(d.hasNext()) {
        t.add(d.getNext());
      }
      return;
    }                
                
    if(d.hasNext() && numCards() == 12 && numSets() > 0) {
      //remove one set and add 3 cards
      findSet();
      if(d.hasNext()) {
        //System.out.println("t1");
        t.add(d.getNext());
      }
      if(d.hasNext()) {
        //System.out.println("t2");
        t.add(d.getNext());
      }
      if(d.hasNext()) {
        //System.out.println("t3");
        t.add(d.getNext());
      }
      return;
    }

    if(numCards() > 12 && numSets() > 0) {
      //System.out.println("t4");
      //remove one set but don't add 3 cards
      findSet();
      return;
     }
    
    if(numSets() > 0 && d.hasNext() == false) {
      //System.out.println("t5");
      //remove one set
      findSet();
      return;
    }
  }
  
  private void findSet() {
    for(int a = 0; a < t.numCards() - 2; a++) {
      for(int b = a + 1; b < t.numCards() - 1; b++) {
        for(int c = b + 1; c < t.numCards(); c++) {
          if(t.getCard(a).isSet(t.getCard(b), t.getCard(c))) {
            t.removeSet(t.getCard(a), t.getCard(b), t.getCard(c));
            return;
          }
        }
      }
    }
  }
  
  public boolean isGameOver() {
    return d.hasNext() == false && numSets() == 0;
  }
}