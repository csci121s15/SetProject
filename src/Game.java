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
      t.findSet();
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
      t.findSet();
      return;
     }
    
    if(numSets() > 0 && d.hasNext() == false) {
     //System.out.println("t5");
     //remove one set
     t.findSet();
     return;
    }
  }
  
  public boolean isGameOver() {
    return d.hasNext() == false && numSets() == 0;
  }
}