public class Game {
  private Table t;
  private Deck d;
  
  public Game() {
    //12 cards on the table, randomly generated deck//
    t = new Table();
    d = new Deck();
    
    for (int i = 0; i < 12; i++) {
      t.add(d.getNext());
    }
  }
  
  public Game(String theString) {
    //Starts with 12 cards on the table//
    //Number of cards on table is either 12 or the number of cards in the deck, whatever one is smaller//
    t = new Table();
    d = new Deck(theString);
    
    int i = 0;
    while (d.hasNext() == true) {
      t.add(d.getNext());
      i += 1;
      
      if (t.numCards() == 12) {
        return;
      }
    }
  }
  
  public int numSets() {
    //This method would return the number of sets in the table//
    return t.numSets();
  }
  
  public int numCards() {
    //This method would return number of cards in the table//
    return t.numCards();
  }
  
  public void playRound() {
    //Worked with John Ferguson in lab 4/23//
    //When no sets on table, but still cards in deck, add three cards to move to next round//
    if (t.numSets() == 0 && d.hasNext() == true) {
      for (int i = 0; i < 3; i++) {
        if (d.hasNext() == true) {
          t.add(d.getNext());
        }
      }
      return;
    }
    //12 cards on table and cards in deck, move to next round by removing one set then adding three cards//
    //If starts with more than 12 cards then we remove a set but don't add any more cards//
    //At least one set on the table but no cards left in deck, move to next round by removing a set//
    if (t.numSets() > 0) {
      
      for (int m = 0; m < t.numCards() - 2; m++) {
        for (int n = m + 1; n < t.numCards() - 1; n++) {
          for (int p = n + 1; p < t.numCards(); p++) {
            
            Card card1 = t.getCard(m);
            Card card2 = t.getCard(n);
            Card card3 = t.getCard(p);
            
            if (card1.isSet(card2, card3)) {
              t.removeSet(card1, card2, card3);
              
              if (t.numCards() < 12 && d.hasNext() == true) {
                for (int i = 0; i < 3; i++) {
                  if (d.hasNext() == true) {
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
    //True when no sets on table and no cards in the deck, then the game is over//
    //Otherwise false, game is still on//
    if (d.hasNext() == false && t.numSets() == 0) {
      return true;
  
    }
    else {
      return false;
    }
    
    
  }
}