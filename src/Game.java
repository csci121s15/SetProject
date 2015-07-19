public class Game {
  
  private Table table;
  private Deck deck;
  
  public Game() {
    table = new Table();
    deck = new Deck();
    for (int i = 0; i < 12; i++) {
      table.add(deck.getNext());
    }      
  }
  
  public Game(String filename) {
    table = new Table();
    deck = new Deck(filename);
    while (deck.hasNext()) {
      table.add(deck.getNext());
      if (table.numCards() == 12)
        return;
    }    
  }
  
  public int numSets() {
    return table.numSets();
  }
  
  public int numCards() {
    return table.numCards();
  }
  
  public void playRound() {
    //no sets on table but still cards in deck. add three cards
    if (numSets() == 0 && deck.hasNext()) {
      for (int i = 0; i < 3; i++) {
        if (deck.hasNext())
          table.add(deck.getNext());
      }
      return;
    }
    
    //there are 12 cards on the table containing 1+ sets.
    //remove one set and add three cards to the table
    if (table.numCards() > 0 && table.numSets() > 0) {
      for (int i=0; i < table.numCards()-2; i++) {
        for (int j = i + 1; j < table.numCards()-1; j++) {
          for (int k = j + 1; k < table.numCards(); k++) {
            
            Card c1 = table.getCard(i);
            Card c2 = table.getCard(j);
            Card c3 = table.getCard(k);
            
            if (c1.isSet(c2, c3)) { 
              table.removeSet(c1, c2, c3);
              for (int x = 0; x < 3; x++) {
                if (deck.hasNext()) {
                  table.add(deck.getNext());
                }
              }
            return;
            }
          }
        }
      }
    }
    //round starts with more that 12 cards because no sets in prev round
    //remove cards but do not add more
    else if (table.numCards() > 12 && table.numSets() > 0) {
       for (int i= 0; i < table.numCards()-2; i++) {
         for (int j = i + 1; j < table.numCards()-1; j++) {
           for (int k = j + 1; k < table.numCards(); k++) {
            
            Card c1 = table.getCard(i);
            Card c2 = table.getCard(j);
            Card c3 = table.getCard(k);
            
            if (c1.isSet(c2, c3)) {
              table.removeSet(c1, c2, c3);
              return;
            }
          }
        }
      }
    }    
    //there is 1+ set on the table but no cards in the deck
    //remove cards from the table
    else if (deck.hasNext() == false && table.numSets() >= 1) {
      for (int i=0; i < table.numCards()-2; i++) {
        for (int j = i + 1; j < table.numCards()-1; j++) {
          for (int k = j + 1; k < table.numCards(); k++) {
            
            Card c1 = table.getCard(i);
            Card c2 = table.getCard(j);
            Card c3 = table.getCard(k);
            
            if (c1.isSet(c2, c3))
              table.removeSet(c1, c2, c3);
            return;
          }
        }
      }
    }
    //there are no cards in the deck and no sets on the table
    //game is over.
    else if (deck.hasNext() == false && table.numSets() == 0) {
      return;
    }   
  }
   
  
  public boolean isGameOver() {
    return (table.numSets() == 0 && deck.hasNext() == false);
  }
}
  