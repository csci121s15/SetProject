public class Game{
  private Deck d;
  private Table t;
  
  public Game(){
    //begins with randomly generated deck of 12 cards
    
    d = new Deck();
    t = new Table();
    
    for (int i = 0; i<12; i++){
      t.add(d.getNext());
    }
  }
  
  public Game(String filename){
    //loads specific deck
    
    d = new Deck(filename);
    t = new Table();
    
    while (d.hasNext()){
      t.add(d.getNext());
      
      if (t.numCards() == 12){
        return;
      }
    }
  }
  
  public int numSets(){
    //returns number of sets on the table
    return t.numSets();
  }
  
  public int numCards(){
    
    //returns number of cards on table which is 12 
    //or less if deck has lest than 12 cards
    return t.numCards();
  }
  
  public void playRound(){
    //used to advance game from one round to the next
    //
    //a round deals with removing one set 
    //and adding additional cards
    //
    //1.)when no sets on table but still cards in deck:
    //   this means just add 3 cards
    //2.)most of the time:
    //   cards in deck and 12 on table containing 1+ sets
    //     in this situation we move from one round
    //     to the next by removing one set and adding 3 cards
    //     to the table from the deck
    //3.)if a round starts with 12+ cards on table:
    //   (due to no sets)
    //   and theres is at least one set,
    //   then after removing a set we do not add cards
    //4.)if there is at least one set but no cards left:
    //   we move to next round by just removing set
    //5.)if no cards in deck or sets on table:
    //   game over
    //
    //6.)sometimes when you use custom decks:
    //   there may be only 1-2 cards remaining
    //   when you have to add cards to table
    //      in this case cards are added like normal
    //      and the table remains short a few cards

    int sets = t.numSets();

    //1.)
    if (sets == 0 && d.hasNext() == true){
      for (int i = 0; i < 3; i++){
        if (d.hasNext() == false){
         return;
        }
        t.add(d.getNext());
      }
      return;
    }
    
    
    //2.)
    if (sets > 0 && d.hasNext() == true){ 
      //call the number of cards in the begining to make it quicker
      int numCards = t.numCards();
      //go through the table looking for the set
      for (int i=0; i<numCards-2; i++) {
        for (int j=i+1; j<numCards-1; j++){
          for (int k=j+1; k<numCards; k++){
                  
            Card card1 = t.getCard(i);
            Card card2 = t.getCard(j);
            Card card3 = t.getCard(k);
                  
            if (card1.isSet(card2,card3)) {
              t.removeSet(card1, card2, card3);
              
              for (int p = 0; t.numCards() < 12; p++){
                if (d.hasNext() == false){
                  return;
                }
                t.add(d.getNext());
              }
              return;
            }
          }
        }
       }
      return;
    }
    
    
    //3.)
    if (t.numCards() > 12 && sets > 0){
      //call the number of cards in the begining to make it quicker
      int numCards = t.numCards();
      //go through the table looking for the set
      for (int i=0; i<numCards-2; i++) {
        for (int j=i+1; j<numCards-1; j++){
          for (int k=j+1; k<numCards; k++){
                  
            Card card1 = t.getCard(i);
            Card card2 = t.getCard(j);
            Card card3 = t.getCard(k);
                  
            if (card1.isSet(card2,card3)) {
              t.removeSet(card1, card2, card3);
              return;
            }
          }
        }
      }
      return;
    }
    
    //4.)
    if (sets > 0 && d.hasNext() == false){
      //call the number of cards in the begining to make it quicker
      int numCards = t.numCards();
      //go through the table looking for the set
      for (int i=0; i<numCards-2; i++) {
        for (int j=i+1; j<numCards-1; j++){
          for (int k=j+1; k<numCards; k++){
                  
            Card card1 = t.getCard(i);
            Card card2 = t.getCard(j);
            Card card3 = t.getCard(k);
                  
            if (card1.isSet(card2,card3)) {
              t.removeSet(card1, card2, card3);
              return;
            }
          }
        }
      }
      return;
    }
    
    //5.)
    if (d.hasNext() == false && sets == 0){
      return;
    }

  }
  
  public boolean isGameOver(){
    //returns true only if there are no sets on table
    // and no cards in deck
    
    if (d.hasNext() == false && t.numSets() == 0){
      return true;
    }
    else {
      return false;
    }
  }
  
}