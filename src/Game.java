public class Game {
  private Table t;
  private Deck d;
  
  public Game() {
    t = new Table(); 
    d = new Deck();
    
    for(int i = 0; i < 12; i++)
      if(d.hasNext() != false) {
      t.add(d.getNext());
    }
  }
  
  public Game(String filename) {
 
    d = new Deck(filename);
    t = new Table();
    for( int i = 0; i<12; i++) {
      if(d.hasNext() == true)
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
    if(t.numSets() == 0 && d.hasNext() != false){
      for( int i = 0; i < 3; i++)
        t.add(d.getNext());
      return;
    }
    boolean foundSet = false;
     for( int i = 0; i < numCards() -2; i++) {
        if(foundSet)
         break;
      for(int j = i +1; j < numCards() -1; j++) {
        if( foundSet)
          break;
        for(int k = j +1; k < numCards(); k++) {
          Card wolverine = t.getCard(i);
          Card magneto = t.getCard(j);
          Card professorx = t.getCard(k);
          
          if (wolverine.isSet(magneto, professorx)) {
            t.removeSet(wolverine, magneto, professorx);
            foundSet = true;
            break;
          }
        }
      }
     }
      if (d.hasNext() == true && numCards() < 12) {
            for( int w = 0; w < 3; w++) {
              if(d.hasNext() == true) {
                
              t.add(d.getNext());
              }
            }
      }
  }

  public boolean isGameOver() {
    if( t.numSets() == 0 && d.hasNext() == false) {
      return true;
    }
    else {
      return false;
    }
  }
}

  